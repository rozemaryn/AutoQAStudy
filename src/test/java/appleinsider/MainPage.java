package appleinsider;/*
Главная страница сайта appleinsider.ru
 */

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement textBoxInput = $x("//input[@type=\"text\"]");

    public MainPage (String url) {
        Selenide.open(url);
    }

    /**
     * выполняем поиск на сайте опр. текста и нажимаем enter
     * @param searchValue текст, который ищем
     */
    public SearchPage search (String searchValue) {
        textBoxInput.setValue(searchValue);
        textBoxInput.sendKeys(Keys.ENTER);
        return new SearchPage();
    }
}
