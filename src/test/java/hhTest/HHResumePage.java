package hhTest;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class HHResumePage {

    private final SelenideElement sex = $x("//span[@data-qa=\"resume-personal-gender\"]");
    private final SelenideElement age = $x("//span[@data-qa = \"resume-personal-age\"]/span");
    private final SelenideElement city = $x ("//span[@data-qa=\"resume-personal-address\"]");
    private final SelenideElement tick = $x("//div[@data-qa = \"resume-contacts-phone\"]/span/preceding-sibling::*");
    private final SelenideElement locationData = $x("//span[@data-qa=\"resume-personal-address\"]/ancestor::p");

    public static String SEX = "Пол";
    public static String AGE = "Возраст";
    public static String CITY = "Город";
    public static String CONFIRMED_PHONE = "Подтверждённый номер";
    public static String READY_TO_RELOCATE = "Готовность к переезду";

    public Map <String, Object> getAttributes () {
        return new HashMap<>() {{
                put(SEX, getFirstLetterOfSex());
                put(AGE, getAge());
                put(CITY, getCity());
                put(CONFIRMED_PHONE, phoneConfirmed());
                put(READY_TO_RELOCATE, isReadyToRelocate());
            }};
    }
    public HHResumePage(String url) {
        Selenide.open(url);
    }

    public String getFirstLetterOfSex() {
        return String.valueOf(sex.getText().charAt(0));
    }

    //    другой вариант, через ternary if
//
//    public String getFirstLetterOfSex () {
//        return sex.getText().equals("Женщина") ? "Ж" : "М";
//    }

    public int getAge() {
        return Integer.parseInt(age.getText().replaceAll("\\D+", ""));
    }

    public String getCity () {
        return city.getText();
    }

    public boolean isReadyToRelocate() {
        String [] array = locationData.getText().split(", ");
        String relocate = array[2];
        return relocate.equals("готова к переезду");
    }

    public boolean phoneConfirmed () {
        return tick.isDisplayed();
    }

}

