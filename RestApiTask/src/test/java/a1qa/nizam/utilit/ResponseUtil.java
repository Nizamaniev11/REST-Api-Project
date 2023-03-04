package a1qa.nizam.utilit;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ResponseUtil {
    public static Response sendGetRequest(String request) {
        return given().contentType(ContentType.JSON)
                .when()
                .get(request)
                .then()
                .extract().response();
    }

    public static Response sendPutRequest(String request, String body) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post(request)
                .then()
                .extract().response();
    }

}
