package hhTest;
import core.BaseTest;
import hh.Resume;
import org.apache.commons.lang3.builder.EqualsBuilder;
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

    @Test
    public void checkAttributesClass () {

        HHResumePage hhResumePage = new HHResumePage(Resume_URL);
        Resume expectedAttributes = new Resume("Ж", 31, "Москва", true, true);
        Resume actualAttributes = new Resume(hhResumePage.getFirstLetterOfSex(), hhResumePage.getAge(),
                hhResumePage.getCity(), hhResumePage.phoneConfirmed(), hhResumePage.isReadyToRelocate());

        Assert.assertEquals(expectedAttributes, actualAttributes);

         // другой способ сравнения, без перезаписи equals
        //Assert.assertTrue(EqualsBuilder.reflectionEquals(expectedAttributes, actualAttributes));
    }
}
