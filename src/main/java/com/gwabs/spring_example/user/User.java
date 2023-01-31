package com.gwabs.spring_example.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min=2, message = "Name should at have least 2 characters")
   // @JsonProperty("User_Name")
    //@JsonIgnore
    private String name;

    public User() {
    }


    public void setId(int id) {
        this.id = id;
    }

    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min = 4)
    private String birthDate;


    private String occupation;

    @NotEmpty
    @NotBlank
    @NotNull
    private String relationship_Status;

    public User(int id, String name, String birthDate, String occupation, String relationship_Status) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.occupation = occupation;
        this.relationship_Status = relationship_Status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public String getRelationship_Status() {
        return relationship_Status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", work='" + occupation + '\'' +
                ", relationship_Status='" + relationship_Status + '\'' +
                '}';
    }
}
