package UnitTests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void beforeTest () {
        System.out.println("This runs before tests");
    }

    @AfterTest
    public void afterTest () {
        System.out.println("This runs after tests");
    }
}
