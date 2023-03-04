package a1qa.nizam.utilit;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonFileReader {

    public static String getDataForTest(String data, String path) {
        return (String) parseJson(path).get(data);
    }

    public static Object getJsonElement(String path) {
        return parseJson(path);
    }


    private static JSONObject parseJson(String path) {
        JSONParser parser = new JSONParser();
        JSONArray a = null;
        try {
                    a = (JSONArray) parser.parse(new FileReader(path));
        } catch (IOException | ParseException e) {
            LoggerUtil.logger().error("Threw a Exception in JsonFileReader::getDataForTest, full stack trace follows:",
                    e);
        }
        return (JSONObject) a.get(0);
    }

}
