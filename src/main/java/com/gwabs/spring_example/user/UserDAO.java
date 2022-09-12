package com.gwabs.spring_example.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {


    private static List<User> usersList = new ArrayList<>();
    private static int userCount = 0;

    static {
        usersList.add(new User(++userCount,"Abubakar Abdullahi","18 - 09 - 1996","Mobile Application Developer","Single", User.Gender.Male));
        usersList.add(new User(++userCount,"Abubakar Aliyu","18 - 09 - 1996","Mobile Application Developer","Single", User.Gender.Male));
        usersList.add(new User(++userCount,"Abubakar Hauwa","18 - 09 - 1996","Mobile Application Developer","Single",User.Gender.Femalle));
        usersList.add(new User(++userCount,"Abubakar Buhari","18 - 09 - 1996","Mobile Application Developer","Single", User.Gender.Male));
        usersList.add(new User(++userCount,"Abubakar Abbah","18 - 09 - 1996","Mobile Application Developer","Single", User.Gender.Male));
        usersList.add(new User(++userCount,"Abubakar Kopat","18 - 09 - 1996","Mobile Application Developer","Single", User.Gender.Male));

    }

    public List<User> getUsersList(){

        return usersList;
    }


    public User saveUser(User user){
        user.setId(++userCount);
        usersList.add(user);

        return user;
    }


    public User getSpecificUser(int id ) {


        User user = null;
        for (int i = 0; i <= usersList.size()-1; i++) {
            if (usersList.get(i).getId() == id) {
                user = usersList.get(i);
                break;
            } else {
                user = null;
            }
        }
        return user;
    }

    public String deleteUser(int id){
        String message = "";
        for (int i = 0; i < usersList.size(); i++) {
            if (usersList.get(i).getId() == id) {
                usersList.remove(i);
                message = "Deleted Successfully";
                break;
            } else {
                message = "User not found";
            }
        }
        return message;
    }
}
