package org.example.entity;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentForThymeleaf {
    private String firstName;
    private String lastName;
    private String country;
    private List<String> favoriteLanguage;
    //with multiple choices, spring will automagically concat all object into a String with a delimeter
    //This student favorite operating system is: Linux,macOS,Microsoft Windows
    //The true definition we can use here can be List<String>
    private String favoriteOperatingSystem;

    public String getFirstName() {
        return firstName;
    }

    public String getFavoriteOperatingSystem() {
        return favoriteOperatingSystem;
    }

    public void setFavoriteOperatingSystem(String favoriteOperatingSystem) {
        this.favoriteOperatingSystem = favoriteOperatingSystem;
    }

    public List<String> getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(List<String> favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
