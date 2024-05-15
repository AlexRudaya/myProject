package postmanTests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
import specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class GetRequestTest extends Specifications {
    ResponseSpecification responseSpec;
    RequestSpecification requestSpec;

    @Test
    public void get() {

        requestSpec = getReqstSpec();
        responseSpec = getResSpec();
        given()
                .spec(requestSpec)
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when().get("/get")
                .then()
                .log().body()
                .spec(resSpec)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));

    }
}
