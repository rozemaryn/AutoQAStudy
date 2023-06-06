package courseUdemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LumosityLoginTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.get("https://www.lumosity.com/en/");
        driver.findElement(By.xpath("//a[@data-track-button-press='log_in']")).click();
        driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("animalitos");
        driver.findElement(By.xpath("//input[@placeholder = 'Email']")).clear();
        driver.findElement(By.xpath("//input[@placeholder = 'Email']")).sendKeys("animalitos@yandex.ru");
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("wrongpassword");
        driver.findElement(By.name("persistent_login")).click();
        driver.findElement(By.cssSelector("input.btn-primary")).click();

        driver.findElement(By.xpath("//a[@data-track-link-click = \"forgot_password\"]")).click();
        driver.
                findElement(By.xpath("//input[@placeholder=\"Email address\"]")).
                sendKeys("animalitos@yandex");
        driver.findElement(By.className("btn-primary")).click();

        System.out.println(driver.findElement(By.className("alert-success")).getText());





    }
}
