package a1qa.nizam.utilit;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;


import java.util.Arrays;
import java.util.List;

public class Mapper {

    public static <T> T fromJson(String json, Class<T> clazz) {
        return new Gson().fromJson(json, clazz);
    }

    public static <T> List<T> fromJsonAsList(String json, Class<T[]> clazz) {
        return Arrays.asList(new Gson().fromJson(json, clazz));
    }


    public static String ObjectToJsonString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = null;
        try {
            requestBody = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LoggerUtil.logger().error("Could not map json to POJO, full stack trace follows:",
                    e);
        }
        return requestBody;
    }
}
