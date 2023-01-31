package com.gwabs.spring_example.user;

public class PersonV2 {
    private String firstName,lastName;

    public PersonV2(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
