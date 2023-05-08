package api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest {
    private static final String URL = "https://reqres.in/";

    @Test
    public void deleteUserTest () {
        Specifications.installSpecs(Specifications.requestSpec(URL), Specifications.respSpecUnique(204));
        given()
                .when()
                .delete("/api/users/2")
                .then().log().all();
    }
}
