package hh;

import java.util.Objects;

public class Resume {
    private String gender;
    private int age;
    private String city;
    boolean isPhoneComfirmed;
    private boolean isReadytoRelocate;

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public boolean isPhoneComfirmed() {
        return isPhoneComfirmed;
    }

    public boolean isReadytoRelocate() {
        return isReadytoRelocate;
    }

    public Resume(String gender, int age, String city, boolean isPhoneComfirmed, boolean isReadytoRelocate) {
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.isPhoneComfirmed = isPhoneComfirmed;
        this.isReadytoRelocate = isReadytoRelocate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resume resume = (Resume) o;
        return age == resume.age && isPhoneComfirmed == resume.isPhoneComfirmed && isReadytoRelocate == resume.isReadytoRelocate && Objects.equals(gender, resume.gender) && Objects.equals(city, resume.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gender, age, city, isPhoneComfirmed, isReadytoRelocate);
    }
}
