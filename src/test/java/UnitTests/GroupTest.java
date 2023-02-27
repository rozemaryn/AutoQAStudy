//package UnitTests;
//
//import Calculator.Calculator;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class GroupTest extends BaseTest {
//
//    private Calculator calculator = new Calculator();
//    private final double FIRST_NUM = 10;
//    private final double SECOND_NUM = 5;
//
//    @Test(description = "этот тест что-то проверяет", groups = "some group")
//    public void checkSmth() {
//        System.out.println("Check this out");
//    }
//
//    @Test (groups = "other group", dependsOnMethods = "checkMultError", alwaysRun = true)
//    public void checkAdd() {
//        double expectedResult = FIRST_NUM + SECOND_NUM;
//        double actualResult = calculator.add(FIRST_NUM, SECOND_NUM);
//
//        Assert.assertEquals(expectedResult, actualResult, "The result of adding isn't correct");
//    }
//
//    @Test (priority = 1)
//    public void checkMultError() {
//        double expectedResult = FIRST_NUM * SECOND_NUM;
//        double actualResult = calculator.errorMult(FIRST_NUM, SECOND_NUM);
//
//        Assert.assertEquals(expectedResult, actualResult, "The result of multiplication isn't correct");
//    }
//}
