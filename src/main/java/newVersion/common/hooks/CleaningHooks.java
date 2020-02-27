package newVersion.common.hooks;

import com.crealogix.common.core.BaseE2ETest;
import com.crealogix.common.core.Loggable;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicBoolean;

public class CleaningHooks extends Loggable {

    private static final String RESET_DB_FILE_NOT_FOUND_ERROR_MESSAGE = "The project should contain the liquibase script \"db/resetDB.xml\" in order to be able to roll-back the DB";
    private static final String RESET_DB_XML = "db/resetDB.xml";
    
    // these fields can be static because for every a separate the jvm is started
    private static final AtomicBoolean resetDbXmlFound = new AtomicBoolean();
    private static Liquibase liquibase;
    
    @Autowired
    @SuppressWarnings("SpringJavaAutowiredMembersInspection")
    private DataSource datasource;

    @Before(order = 2)
    public void setupTestConditions() throws FileNotFoundException, SQLException, LiquibaseException {
        if (!resetDbXmlFound.get()) {
            if (CleaningHooks.class.getClassLoader().getResource(RESET_DB_XML) == null) {
                log.error(RESET_DB_FILE_NOT_FOUND_ERROR_MESSAGE);
                throw new FileNotFoundException(RESET_DB_FILE_NOT_FOUND_ERROR_MESSAGE);
            } else {
                resetDbXmlFound.set(true);
            }
        }

        // setup liquibase
        if (liquibase == null) {
            JdbcConnection connection = new JdbcConnection(datasource.getConnection());
            liquibase = new Liquibase(
                    RESET_DB_XML,
                    new ClassLoaderResourceAccessor(),
                    DatabaseFactory.getInstance().findCorrectDatabaseImplementation(connection)
            );
        }
    }

    @Before(order = 3)
    @Transactional
    public void cleanDataBase(Scenario scenario) throws LiquibaseException {
        log.debug(String.format("Reset database for scenario %s", scenario.getName()));
        liquibase.update(new Contexts(""), new LabelExpression(), false);
    }

    @Before(order = 4)
    public void cleanTestState(Scenario scenario) {
        log.debug(String.format("Clean test state for scenario %s", scenario.getName()));
        new BaseE2ETest().resetState();
    }

}
