package newVersion.common.utils;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class ValidDateMatcher extends BaseMatcher<Object> {
    public boolean matches(Object item) {
        return DateUtils.isValidMandatoryDate(item);
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText("Is not a valid date: ").appendValue(item);
    }

    @Override
    public void describeTo(Description description) {

    }
}
