package postmanTests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;
import specification.Specifications;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class DeleteRequestTest extends Specifications {
    ResponseSpecification responseSpec;
    RequestSpecification requestSpec;

    @Test
    public void delete() {

        requestSpec = getReqstSpec();
        responseSpec = getResSpec();
        given()
                .spec(requestSpec)
                .body("This is expected to be sent back as part of response body.")
                .when().delete("/delete")
                .then()
                .log().body()
                .spec(resSpec)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.content-type",equalTo("text/plain; charset=ISO-8859-1"));

    }
}
