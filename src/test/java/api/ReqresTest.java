package api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private static final String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
        List<UserData> users = given()
                .when()
                .contentType(ContentType.JSON) // указываем тип данных, который получаем
                .get(URL + "api/users?page=2") //указыаем запрос и куда он обращается
                .then().log().all() // выводим данные
                .extract().body().jsonPath().getList("data", UserData.class);
        // извлекаем данные и записываем их в класс

        users.stream().forEach(x -> x.getAvatar().contains(x.getId().toString()));
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));

        int a = 1;
    }
}
