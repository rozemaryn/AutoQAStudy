package api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReqresTestRegistration {

    private static final String URL = "https://reqres.in/";

    @Test
    public void testRegistration () {
        Specifications.installSpecs(Specifications.requestSpec(URL), Specifications.respSpec200());

        // указываем, какие данные мы должны получить с сервера
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        // указываем, что мы будем передать в post-запросе
        RegistrationData user = new RegistrationData("eve.holt@reqres.in", "pistol");

        // создаём класс, в котором будут актуальные данные (что мы получим с сервера на самом деле)

        SuccessfulReg successfulReg = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessfulReg.class);

        // проверка, что мы получаем не пустой класс
        Assert.assertNotNull(successfulReg.getId());
        Assert.assertNotNull(successfulReg.getToken());

        // сравниваем заданные поля с тем, что мы получаем фактически
        Assert.assertEquals(id, successfulReg.getId());
        Assert.assertEquals(token, successfulReg.getToken());
    }

    @Test
    public void unsuccesfulRegTest () {

        Specifications.installSpecs(Specifications.requestSpec(URL), Specifications.respSpec400());
        RegistrationData user = new RegistrationData("sydney@fife", "");

        UnsuccessfulReg fail = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessfulReg.class);

        Assert.assertEquals("Missing password", fail.getError());
    }
}
