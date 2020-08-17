package org.my.group;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MyResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when()
          .header("X-Remote-User", "my name")
          .get("/hi")
          .then()
             .statusCode(200)
             .body(is("my name"));
    }

}