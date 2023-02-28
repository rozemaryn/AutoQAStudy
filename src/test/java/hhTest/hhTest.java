package hhTest;
import com.codeborne.selenide.Selenide;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static hhTest.HHResumePage.*;

public class hhTest extends BaseTest {

    private final static String Resume_URL = "https://hh.ru/resume/484165f2ff03ae95f40039ed1f7368304f4e44";

    @Test
    public void checkAttributesHashMap() {
        HHResumePage hhResumePage = new HHResumePage(Resume_URL);
        Map<String, Object> expectedAttributes = new HashMap<>();
        expectedAttributes.put(SEX, "Ж");
        expectedAttributes.put(AGE, 31);
        expectedAttributes.put(CITY, "Москва");
        expectedAttributes.put(CONFIRMED_PHONE, true);
        expectedAttributes.put(READY_TO_RELOCATE, true);

        Map <String, Object> actualAttributes = hhResumePage.getAttributes();

        Assert.assertEquals(expectedAttributes, actualAttributes);
    }
}
