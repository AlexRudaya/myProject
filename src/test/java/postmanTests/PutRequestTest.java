package postmanTests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.Test;
import specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutRequestTest extends Specifications {
    ResponseSpecification responseSpec;
    RequestSpecification requestSpec;


    @Test
    public void put() {
        requestSpec = getReqstSpec();
        responseSpec = getResSpec();
        JSONObject requestBody = new JSONObject()
                .put("name", "updated name")
                .put("surname","updated surname");

        given()
                .spec(requestSpec)
                .body(requestBody.toString())
                .log().body()
                .contentType("application/json")
                .when()
                .put("/put")
                .then()
                .log().body()
                .spec(responseSpec)
                .body("data.name", equalTo("updated name"))
                .body("data.surname", equalTo("updated surname"));


    }
}
