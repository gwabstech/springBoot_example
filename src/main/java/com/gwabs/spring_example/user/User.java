package com.gwabs.spring_example.user;

import java.time.LocalDate;

public class User {

  private int id ;
  private String name;
  private String birthDate;
  private String Work;

  private String Relationship_Status;
  public  enum Gender{
      Male,
      Femalle
  }
    private  Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User(int id, String name, String birthDate, String work, String relationship_Status, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        Work = work;
        Relationship_Status = relationship_Status;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", Work='" + Work + '\'' +
                ", Relationship_Status='" + Relationship_Status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

    public String getRelationship_Status() {
        return Relationship_Status;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setRelationship_Status(String relationship_Status) {
        Relationship_Status = relationship_Status;
    }

}
