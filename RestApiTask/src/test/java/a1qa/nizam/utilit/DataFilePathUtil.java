package a1qa.nizam.utilit;

public class DataFilePathUtil {
    private static final String testConfig = "src/test/resources/testConfig.json";
    private static final String testData = "src/test/resources/testData.json";
    private static final String dataForTest = "src/test/resources/testDataForRestTest.json";

    public static String getTestConfig() {
        return testConfig;
    }

    public static String getTestData() {
        return testData;
    }

    public static String getDataForTest() {
        return dataForTest;
    }
}
