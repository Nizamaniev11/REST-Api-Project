package a1qa.nizam.base;

import a1qa.nizam.utilit.DataFilePathUtil;
import a1qa.nizam.utilit.JsonFileReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

abstract public class BaseTest {

    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = JsonFileReader.getDataForTest("mainPage", DataFilePathUtil.getTestConfig());
    }

}
