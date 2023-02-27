import org.testng.Assert;
import org.testng.annotations.Test;

public class AppleTest extends BaseTest {

    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "iPhone 12 или Samsung Galaxy S22. Что выбрать";

    @Test
    public void testHref () {
        MainPage mainPage = new MainPage(BASE_URL);
        String href = mainPage.search(SEARCH_STRING).getHrefFromFirstArticle();
        Assert.assertTrue(href.contains("iphone-12"));
    }
}
