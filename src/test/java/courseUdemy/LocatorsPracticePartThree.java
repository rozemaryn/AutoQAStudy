package courseUdemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LocatorsPracticePartThree {

    public static String getPassword (WebDriver driver) {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reset-pwd-btn")));
        driver.findElement(By.className("reset-pwd-btn")).click();

        String passwordText = driver.findElement(By.className("infoMsg")).getText();
        String[] array = passwordText.split(" ");
        String password = array[4].replaceAll("[^\\w]", "");
        return password;
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String name = "rahul";
        String password = getPassword(driver);

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.cssSelector("input[placeholder = 'Password']")).sendKeys(password);
        driver.findElement(By.className("signInBtn")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p")));
        Assert.assertEquals(element.getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Hello " + name + ",");
        driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
        driver.quit();
    }
}
