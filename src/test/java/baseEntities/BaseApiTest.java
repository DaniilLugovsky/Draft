package baseEntities;

import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import lombok.Getter;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;
import services.ProjectService;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected ProjectService projectService;

    @BeforeTest
    public void setUpApiClient() {
        RestAssured.baseURI = ReadProperties.getUri();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());

        projectService = new ProjectService();
    }
}
