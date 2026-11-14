package BookStoreApplicationTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest {

    String baseUrl = "http://195.38.164.168:8181/api/v1/users/get";
    @Test
    public void getUser2() {
        given()
                .queryParam("id", 1)
                .when()
                .get(baseUrl)
                .then()
                .log().all()
                .statusCode(500)
                .body("id", equalTo(3))
                .body("firstName", equalTo("Lionel"))
                .body("lastName", equalTo("Pepsi"))
                .body("username", equalTo("pepsicola"))
                .body("password", equalTo("1qazCFT^123"))
                .body("email", equalTo("pepsicola.email.com"));
    }
}