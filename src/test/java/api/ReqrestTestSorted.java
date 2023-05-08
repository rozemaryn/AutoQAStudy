package api;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqrestTestSorted {

    private static final String URL = "https://reqres.in/";

    @Test
    public void areYearsSorted () {
        Specifications.installSpecs(Specifications.requestSpec(URL), Specifications.respSpec200());
        List<ColoursData> colours = given()
                .when()
                .get("api/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ColoursData.class);

        List <Integer> years = colours.stream().map(ColoursData :: getYear).sorted().collect(Collectors.toList());
        List <Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());

        Assert.assertEquals(sortedYears, years);

        System.out.println(years);
        System.out.println(sortedYears);
    }
}
