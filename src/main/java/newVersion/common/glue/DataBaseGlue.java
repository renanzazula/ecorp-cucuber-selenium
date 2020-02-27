package newVersion.common.glue;

import com.crealogix.common.core.BaseE2ETest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class contains all the DB related steps.
 * <p>See the readme.md file to get more information about the steps.
 */
@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class DataBaseGlue extends BaseE2ETest {

    private final ObjectMapper mapper = new ObjectMapper();
    @Autowired
    protected LocalContainerEntityManagerFactoryBean entityManagerFactory;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    DataSource datasource;

    /**
     * See the readme.md file to get more information about this step.
     */
    @Given("that the DB is initialized with the file {string}")
    @Transactional
    public void thatTheDBIsInitializedWithTheFile(String pathToFile) throws Exception {
        JdbcConnection connection = new JdbcConnection(datasource.getConnection());
        try {
            new Liquibase(
                    fileBasePath + pathToFile,
                    new ClassLoaderResourceAccessor(),
                    DatabaseFactory.getInstance().findCorrectDatabaseImplementation(connection)
            ).update(new Contexts(""), new LabelExpression(), false);
        } finally {
            connection.close();
        }
    }

    /**
     * See the readme.md file to get more information about this step.
     */
    @Then("the result of executing the query in {string} should be as in {string}")
    @Transactional
    public void theResultOfExecutingTheQueryInShouldBeAsIn(String pathToQueryFile, String pathToCsvFile) throws Throwable {
        String sqlSentence = readFile(pathToQueryFile);
        List<Map<String, Object>> queryResults = generifyDbJsonFiles(jdbcTemplate.queryForList(sqlSentence));

        List<Map<String, Object>> data = generifyDbJsonFiles(
                mapper.readValue(readFile(pathToCsvFile), new TypeReference<List<Map<String, Object>>>() {})
        );

        String actualResult = mapper.writeValueAsString(queryResults);
        String expectedResult = mapper.writeValueAsString(data);

        compareJson(actualResult, expectedResult);
    }

    /**
     * <p>Private method generify the given JSON in oder to be able to check it across several DB.</p>
     * <p>This is required since not all DB return the column name in a common format, nor the saved value.</p>
     * <p>To check the specifid replacements, see {@link DataBaseGlue#generalizeDbColumnName(String)} and {@link DataBaseGlue#generalizeDbColumnValue(Object)}</p>
     *
     * @see DataBaseGlue#generalizeDbColumnName(String)
     * @see DataBaseGlue#generalizeDbColumnValue(Object)
     * @param data the json file to process
     * @return the json generified to be DB independent
     */
    private List<Map<String, Object>> generifyDbJsonFiles(List<Map<String, Object>> data) {
        return data.stream().map(
                original -> original.entrySet().stream()
                        .filter(entry -> entry.getValue() != null)
                        .filter(entry -> !(entry.getValue() instanceof String) || StringUtils.isNotEmpty((String) entry.getValue()))
                        .collect(Collectors.toMap(
                                columnName -> generalizeDbColumnName(columnName.getKey()),
                                columnValue -> generalizeDbColumnValue(columnValue.getValue())
                        ))
        ).collect(Collectors.toList());
    }

    /**
     * <p>Changes the given columnName to be checked in a DB independent way.</p>
     * <p>It applies the following modifications:</p>
     * <ul>
     *     <li>Makes it "uppercase", so that the comparison is case insensitive.</li>
     * </ul>
     *
     * @param columnName the columnName to be processed
     * @return the columnName processed to be DB independent.
     */
    private String generalizeDbColumnName(String columnName) {
        return columnName.toUpperCase();
    }

    /**
     * <p>Changes the given columnValue to be checked in a DB independent way.</p>
     * <p>It applies the following modifications:</p>
     * <ul>
     *     <li>Boolean values are mapped to either "0" or "1".</li>
     *     <li>"true" and "false" strings are mapped to either "0" or "1".</li>
     * </ul>
     *
     * @param columnValue the columnValue to be processed
     * @param <V> any object
     * @return the columnValue processed to be DB independent.
     */
    private <V> Object generalizeDbColumnValue(V columnValue) {
        if (columnValue instanceof Boolean) {
            return (Boolean) columnValue ? 1 : 0;
        }

        if (columnValue instanceof String) {
            if ("true".equalsIgnoreCase((String) columnValue)) {
                return 1;
            } else if ("false".equalsIgnoreCase((String) columnValue)) {
                return 0;
            }
        }

        return columnValue;
    }
}
