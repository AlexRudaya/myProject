package specification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;
import org.junit.jupiter.api.TestInstance;
import static org.hamcrest.Matchers.equalTo;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Specifications {
    public static ResponseSpecification resSpec;
    public static RequestSpecification reqstSpec;

    private static void setBuildResponse() {
        ResponseSpecBuilder buildResponse = new ResponseSpecBuilder();
        buildResponse.expectBody("headers.x-forwarded-proto", equalTo("https"));
        buildResponse.expectBody("headers.x-forwarded-port", equalTo("443"));
        buildResponse.expectBody("headers.host", equalTo("postman-echo.com"));
        buildResponse.expectBody("headers.accept-encoding", equalTo("gzip,deflate"));
        buildResponse.expectStatusCode(200);
        resSpec = buildResponse.build();

    }
    private static void setBuildRequest() {
        RequestSpecBuilder buildRequest = new RequestSpecBuilder();
        buildRequest.setBaseUri("https://postman-echo.com");
        reqstSpec = buildRequest.build();

    }

    public RequestSpecification getReqstSpec() {
        return reqstSpec;
    }
    public ResponseSpecification getResSpec() {
        return resSpec;
    }

    @BeforeClass
    public static void callSpec() {
        setBuildResponse();
        setBuildRequest();
    }
}
