import com.codeborne.selenide.Config;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

abstract public class BaseTest {

    public void setUp(){
        WebDriverManager.chromedriver().setup(); // настраиваем нужный webdriver
        Configuration.browser = "chrome";// ! нужно выбирать selenide, а то много ещё других Configuration есть
        Configuration.driverManagerEnabled = true; // указываем, что да, у нас активен WDManager
        Configuration.browserSize = "1920x1080"; // указываем размер окна
        Configuration.headless = false; // это для Jenkins, см. ещё конспекты

    }

    @BeforeTest
    public void init() {
        setUp();
    }

    @AfterTest
    public void tearDown () {
        Selenide.closeWebDriver();
    }
}
