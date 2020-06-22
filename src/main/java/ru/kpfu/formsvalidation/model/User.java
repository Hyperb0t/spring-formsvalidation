package ru.kpfu.formsvalidation.model;

import ru.kpfu.formsvalidation.model.validation.MyConstraint;

import javax.validation.constraints.*;
import java.util.Objects;

public class User {
    @NotBlank
    @Email
    private String email;

    @Size(min = 5)
    private String password;

    @NotBlank
    @Pattern(regexp = "m|f")
    private String gender;

    private String country;

    @AssertTrue
    private boolean agree;

    public User() {
    }

    public User(String email, String password, String gender, String country, boolean agree) {
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.country = country;
        this.agree = agree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return gender == user.gender &&
                agree == user.agree &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(country, user.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, gender, country, agree);
    }
}
