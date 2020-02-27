package newVersion.common.utils;

import com.crealogix.common.core.BaseE2ETest;
import com.crealogix.common.core.Loggable;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Utility class used to easily change the "Spring context" during runtime
 * <p><b>IMPORTANT:</b>
 * <p><b>This class should always be <code>@Autowired</code> into the class that needs to use it, otherwise it
 * will NOT have access to the current spring context and all the operations will fail.</b>
 * The only method offered by this class is {@link #replaceContextBeanProperty(Class, String, Object)}, see it's
 * JavaDoc to check how to use it.
 */
@SuppressWarnings("unused") // It's used in DBH modules
@Component
public final class SpringContextUtils extends Loggable {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * Method used to replace the value of a <code>beanProperty</code> inside the current "Spring context".
     * <p>It will work even with properties that are <code>private</code>, <code>static</code>, <code>final</code>,
     * without getter/setter or any other conditions, as far as:
     * <ul>
     *    <li><code>beanClass</code> is a valid class inside the current "Spring context"</li>
     *    <li><code>propertyName</code> is a member variable of <code>beanClass</code></li>
     *    <li><code>propertyValue</code> is of the same type of  <code>propertyName</code></li>
     * </ul>
     * This will allow you to change flags (ex.: Physical or Logical deletion strategy), validators
     * (ex.: Character converters) or any other thing without needing to reboot the application or to run a separate
     * test profile.
     * <p>Also, any change will be rolled back between tests, so the change will only be effective for the current test,
     * without having side effects in the following tests.
     *
     * @param beanClass the class of the bean you want to edit.
     * @param propertyName the name of the property you want to edit, should be written as in the class itself.
     * @param propertyValue the new value for that property, should be of the type of <code>propertyName</code>
     *                      inside <code>beanClass</code>
     * @throws Exception if any of the constraints are not respected
     */
    public void replaceContextBeanProperty(Class<?> beanClass, String propertyName, Object propertyValue) throws Exception {
        // Get bean from the spring context
        Object notSafeBean = applicationContext.getBean(beanClass);

        // Ensure that we have the real object, not an Spring proxy
        final Object safeBean;
        if (notSafeBean instanceof Advised) {
            safeBean =((Advised)notSafeBean).getTargetSource().getTarget();
        } else {
            safeBean = notSafeBean;
        }

        // Get the desired field
        Field f = FieldUtils.getField(beanClass, propertyName, true);

        // Remove final modifier
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);

        // Get old value for rollback
        Object oldPropertyValue = f.get(safeBean);

        // Set new value
        f.set(safeBean, propertyValue);

        // Add the rollback step
        BaseE2ETest.addRollBackStep(
                "Class: " + beanClass.getSimpleName() + " Field: " + propertyName,
                () -> {
                    try {
                        f.set(safeBean, oldPropertyValue);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                    log.info("Restored bean " + beanClass.getSimpleName());
                }
        );
    }
}

