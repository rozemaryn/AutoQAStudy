package api;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private static final String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest() {
        Specifications.installSpecs(Specifications.requestSpec(URL), Specifications.respSpec200());

        List<UserData> users = given()
                .when()
                //.contentType(ContentType.JSON) // указываем тип данных, который получаем
                .get("api/users?page=2") //указываем запрос и куда он обращается
                .then().log().all() // выводим данные
                .extract().body().jsonPath().getList("data", UserData.class);
        // извлекаем данные и записываем их в класс

        users.stream().forEach(x -> x.getAvatar().contains(x.getId().toString()));
        Assert.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("reqres.in")));



        // второй способ проверки
//        List <String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
//        List <String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
//
//        for (int i = 0; i < avatars.size() ; i++) {
//            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

