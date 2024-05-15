package postmanTests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;
import org.junit.Test;
import specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchRequestTest extends Specifications {
    ResponseSpecification responseSpec;
    RequestSpecification requestSpec;


    @Test
    public void patch() {
        requestSpec = getReqstSpec();
        responseSpec = getResSpec();
        JSONObject requestBody = new JSONObject()
                .put("name", "updated name");


        given()
                .spec(requestSpec)
                .body(requestBody.toString())
                .contentType("application/json")
                .when()
                .patch("/patch")
                .then()
                .log().body()
                .spec(responseSpec)
                .body("data.name", equalTo("updated name"));

    }
}
