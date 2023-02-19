package UnitTests;

import org.testng.annotations.Test;

public class Test1 extends BaseTest  {

    @Test (description = "этот тест что-то проверяет")
    public void checkSmth () {
        System.out.println("Check this out");
    }
}
