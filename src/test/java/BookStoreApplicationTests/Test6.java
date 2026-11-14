package BookStoreApplicationTests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Test6 {

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "http://195.38.164.168:8181";
    }

    @Test
    public void Test1() {
        String body = """
                {
                    "cardNumber": "1111",
                    "pin": "1234",
                    "amount": -500
                }
                """;

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/atm/withdraw")
                .then()
                .statusCode(400);
    }

    @Test
    public void Test4() {
        String body = """
                {
                    "cardNumber": "1111",
                    "pin": "1",
                    "amount": 1222
                }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(body)
                .when()
                .post("/api/atm/withdraw")
                .then()
                .statusCode(200)
                .extract().response();
        String string = response.jsonPath().getString("pin");
        System.out.println("pin = " + string);
    }

}