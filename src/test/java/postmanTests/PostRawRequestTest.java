package postmanTests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.Test;
import specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostRawRequestTest extends Specifications {
    ResponseSpecification responseSpec;
    RequestSpecification requestSpec;

    @Test
    public void postRaw() {
        requestSpec = getReqstSpec();
        responseSpec = getResSpec();
        JSONObject requestBody = new JSONObject()
                .put("name", "test name");
        //  Response response =
        given()
                .spec(requestSpec)
                .contentType("application/json")
                .body(requestBody.toString())
                .when()
                .post("/post")
                .then()
                .log().body()
                .body("data.name", equalTo("test name"))
                .spec(responseSpec)
                .contentType("application/json; charset=UTF-8");

    }
}
