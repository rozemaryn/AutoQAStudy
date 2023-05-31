package courseUdemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IntroTests {
    public static void main(String[] args) {

        System.setProperty("webdriver.http.factory", "jdk-http-client");

        // set path to the Chrome Driver
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");

        // set path to the Firefox Driver
        System.setProperty("webdriver.gecko.driver", "C:\\data\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe");

        // invoke browser through driver
        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new FirefoxDriver();

        //переходим по ссылке
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.close();
    }
}
