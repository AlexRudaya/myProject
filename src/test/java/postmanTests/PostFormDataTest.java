package postmanTests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
import specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class PostFormDataTest extends Specifications {
    ResponseSpecification responseSpec;
    RequestSpecification requestSpec;

    @Test
    public void postForm() {
        requestSpec = getReqstSpec();
        responseSpec = getResSpec();
        given()
                .spec(requestSpec)
                .contentType("application/x-www-form-urlencoded;charset=UTF-8")
                .formParam("name", "test name")
                .when().post("/post")
                .then()
                .log().body()
                .spec(resSpec)
                .body("form.name", equalTo("test name"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded;charset=UTF-8"));

    }
}
