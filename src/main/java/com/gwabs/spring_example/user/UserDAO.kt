package com.gwabs.spring_example.user

import org.springframework.stereotype.Component

@Component
class UserDAO {
    val usersList: List<User>
        get() = Companion.usersList

    fun saveUser(user: User): User {
        user.id = ++userCount
        Companion.usersList.add(user)
        return user
    }

    fun getSpecificUser(id: Int): User? {
        var user: User? = null
        for (i in 0..Companion.usersList.size - 1) {
            if (Companion.usersList[i].id == id) {
                user = Companion.usersList[i]
                break
            } else {
                user = null
            }
        }
        return user
    }

    fun deleteUser(id: Int): String {
        var message = ""
        for (i in Companion.usersList.indices) {
            if (Companion.usersList[i].id == id) {
                Companion.usersList.removeAt(i)
                message = "Deleted Successfully"
                break
            } else {
                message = "User not found"
            }
        }
        return message
    }

    companion object {
        private val usersList: MutableList<User> = ArrayList()
        private var userCount = 0

        init {
            usersList.add(
                User(
                    ++userCount,
                    "Abubakar Abdullahi",
                    "18 - 09 - 1996",
                    "Mobile Application Developer",
                    "Single",
                    User.Gender.Male
                )
            )
            usersList.add(
                User(
                    ++userCount,
                    "Abubakar Aliyu",
                    "18 - 09 - 1996",
                    "Mobile Application Developer",
                    "Single",
                    User.Gender.Male
                )
            )
            usersList.add(
                User(
                    ++userCount,
                    "Abubakar Hauwa",
                    "18 - 09 - 1996",
                    "Mobile Application Developer",
                    "Single",
                    User.Gender.Femalle
                )
            )
            usersList.add(
                User(
                    ++userCount,
                    "Abubakar Buhari",
                    "18 - 09 - 1996",
                    "Mobile Application Developer",
                    "Single",
                    User.Gender.Male
                )
            )
            usersList.add(
                User(
                    ++userCount,
                    "Abubakar Abbah",
                    "18 - 09 - 1996",
                    "Mobile Application Developer",
                    "Single",
                    User.Gender.Male
                )
            )
            usersList.add(
                User(
                    ++userCount,
                    "Abubakar Kopat",
                    "18 - 09 - 1996",
                    "Mobile Application Developer",
                    "Single",
                    User.Gender.Male
                )
            )
        }
    }
}