package courseUdemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //implicit wait для всех элементов
        // driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2500));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("incorrectpassword");
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        // останавливаем поток, потому что элемент появляется не сразу
        Thread.sleep(2000);

        // wait для конкретного элемента
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(4000));
//        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("div.alert-danger")));

        WebElement element = driver.findElement(By.cssSelector("div.alert-danger"));
        System.out.println(element.getText());
        driver.quit();
    }
}
