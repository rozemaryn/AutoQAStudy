package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Clock;

import static io.restassured.RestAssured.given;

public class TimeTest {

    private static final String URL = "https://reqres.in/";


    @Test
    public void timeTest() {
        Specifications.installSpecs(Specifications.requestSpec(URL), Specifications.respSpec200());
        UserTime user = new UserTime("morpheus", "zion resident");
        UserTimeResponse response = given()
                .body(user)
                .when()
                .put("api/users/2")
                .then().log().all()
                .extract().as(UserTimeResponse.class);

        String regex = "(.{5})$";
        String currentTime = Clock.systemUTC().instant().toString().replaceAll(regex, "");

        Assert.assertEquals(currentTime, response.getUpdatedAt().replaceAll(regex,""));
    }
}
