package courseUdemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.lang.model.element.Element;
import java.time.Duration;

public class LocatorsPracticePartTwo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//form/input")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[placeholder = 'Password']")).sendKeys("qwerty");
        driver.findElement(By.className("signInBtn")).click();
        String ErrorMessage = driver.findElement(By.className("error")).getText();
        System.out.println(ErrorMessage);

        driver.findElement(By.linkText("Forgot your password?")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reset-pwd-btn")));

        driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("John");
        driver.findElement(By.xpath("//input[@placeholder = 'Name']")).clear();
        driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("John");
        driver.findElement(By.xpath("//form/input[2]")).sendKeys("john@gmai.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("98553355614");
        driver.findElement(By.className("reset-pwd-btn")).click();

        String resetPassword = driver.findElement(By.className("infoMsg")).getText();
        System.out.println(resetPassword);

        driver.findElement(By.className("go-to-login-btn")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inputUsername")));

        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.id("chkboxOne")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/p")));

        Assert.assertEquals(element.getText(), "You are successfully logged in.");
        // driver.quit();
    }
}
