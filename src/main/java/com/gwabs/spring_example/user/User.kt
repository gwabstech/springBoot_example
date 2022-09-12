package com.gwabs.spring_example.user

class User(
    var id: Int,
    var name: String,
    var birthDate: String,
    var work: String,
    var relationship_Status: String,
    var gender: Gender
) {

    enum class Gender {
        Male, Femalle
    }

    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", Work='" + work + '\'' +
                ", Relationship_Status='" + relationship_Status + '\'' +
                '}'
    }
}