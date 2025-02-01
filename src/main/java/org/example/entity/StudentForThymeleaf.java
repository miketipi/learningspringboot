package org.example.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentForThymeleaf {
    private String firstName;
    private String lastName;
    private String country;

    public String getFirstName() {
        return firstName;
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
