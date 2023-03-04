import a1qa.nizam.base.BaseTest;
import a1qa.nizam.models.Post;
import a1qa.nizam.models.User;
import a1qa.nizam.utilit.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;


public class MainTest extends BaseTest {


    @Test
    public void GetTest() {
        SoftAssert softAssert = new SoftAssert();
        Response response = ResponseUtil.sendGetRequest(
                JsonFileReader.getDataForTest("getPost", DataFilePathUtil.getDataForTest()));
        List<Post> post = Mapper.fromJsonAsList(response.getBody().asString(), Post[].class);
        Assertions.assertEquals(HttpStatus.SC_SUCCESS, response.statusCode(), "Status code does not match!");
        for (int i = 0; i < post.size() - 1; i++) {
            softAssert.assertTrue(post.get(i).getId() < post.get(i + 1).getId(), "Id's are not in ascending order!");
        }
        softAssert.assertAll();
    }

    @Test
    public void CertainElementGetTest() {
        Response response = ResponseUtil.sendGetRequest(JsonFileReader.getDataForTest("getPosts", DataFilePathUtil.getDataForTest()));
        Post post = Mapper.fromJson(response.getBody().asString(), Post.class);
        Assertions.assertEquals(HttpStatus.SC_SUCCESS, response.statusCode(), "Status code does not match!");
        Assertions.assertEquals(Integer.parseInt(JsonFileReader.getDataForTest("Id", DataFilePathUtil.getDataForTest())), post.getId(), "Id is wrong!");
        Assertions.assertEquals(Integer.parseInt(JsonFileReader.getDataForTest("UserId", DataFilePathUtil.getDataForTest())), post.getUserId(), "UserId is wrong!");

    }

    @Test
    public void ErrorGetRequestTest() {
        Response response = ResponseUtil.sendGetRequest(JsonFileReader.getDataForTest("errorGet", DataFilePathUtil.getDataForTest()));
        Assertions.assertEquals(HttpStatus.SC_NOT_FOUND, response.statusCode(), "Status code does not match!");
        Assert.assertEquals(response.getBody().asString(), "{}", "Body is not null!");
    }

    @Test
    public void PostRequestTest() {
        Post post = new Post();
        post.setUserId(Integer.parseInt(JsonFileReader.getDataForTest("UserId", DataFilePathUtil.getDataForTest())));
        post.setBody(Randomizer.randomSymbolsString(Integer.parseInt(JsonFileReader.getDataForTest("UserId", DataFilePathUtil.getDataForTest())), false));
        post.setTitle(Randomizer.randomSymbolsString(Integer.parseInt(JsonFileReader.getDataForTest("UserId", DataFilePathUtil.getDataForTest())), false));
        String requestBody = Mapper.ObjectToJsonString(post);
        Response response = ResponseUtil.sendPutRequest(JsonFileReader.getDataForTest("getPost", DataFilePathUtil.getDataForTest()), requestBody);
        Assertions.assertEquals(HttpStatus.SC_CREATED, response.statusCode(), "Status code does not match!");
        Post responsePost = Mapper.fromJson(response.getBody().asString(), Post.class);
        Assert.assertEquals(post, responsePost, "Response Post does not match with expected one!");
    }

    @Test
    public void UserGetRequestTest() {
        Response response = ResponseUtil.sendGetRequest(JsonFileReader.getDataForTest("getUsers", DataFilePathUtil.getDataForTest()));
        Assertions.assertEquals(HttpStatus.SC_SUCCESS, response.statusCode(), "Status code does not match!");
        List<User> user = Mapper.fromJsonAsList(response.getBody().asString(), User[].class);
        int i, temp = Integer.parseInt(JsonFileReader.getDataForTest("expectedIdForGetUser", DataFilePathUtil.getDataForTest()));
        for (i = 0; i < user.size() - 1; i++) {
            if (user.get(i).getId() == temp) break;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        User expectedUser = null;
        try {
            expectedUser = objectMapper.readValue(JsonFileReader.getJsonElement(DataFilePathUtil.getTestData()).toString(), User.class);
        } catch (IOException e) {
            LoggerUtil.logger().error("Could not map json to POJO, full stack trace follows:",
                    e);
        }
        Assert.assertEquals(user.get(i), expectedUser, "Users are not the same!");

    }


    @Test
    public void CertainUserGetTest() {
        ObjectMapper objectMapper = new ObjectMapper();
        Response response = ResponseUtil.sendGetRequest(JsonFileReader.getDataForTest("getUser", DataFilePathUtil.getDataForTest()));
        Assertions.assertEquals(HttpStatus.SC_SUCCESS, response.statusCode());
        User user = Mapper.fromJson(response.getBody().asString(), User.class);
        User expectedUser = null;
        try {
            expectedUser = objectMapper.readValue(JsonFileReader.getJsonElement(DataFilePathUtil.getTestData()).toString(), User.class);
        } catch (IOException e) {
            LoggerUtil.logger().error("Could not map json to POJO, full stack trace follows:",
                    e);
        }
        Assert.assertEquals(user, expectedUser);
    }


}
