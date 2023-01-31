package com.gwabs.spring_example.user;

import org.aspectj.bridge.Message;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDao {


    private static List<User> usersList = new ArrayList<>();
    private static int usersCount = 0;

    static {
        usersList.add(new User(++usersCount,"Abubakar","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Aliyu","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Abdullahi","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Isa","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Sani","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Musa","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Abbah","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Hauwa","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Halima","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Buhari","18/09/1996","Android Application Developer","single"));
        usersList.add(new User(++usersCount,"Kopat","18/09/1996","Android Application Developer","single"));

    }

    // get spesific user by id
    public User getSpecificUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return usersList.stream().filter(predicate).findFirst().orElse(null);
    }

    // get all users and return them
    public List<User> getUserList(){
        List<User> users = null;
        if (!usersList.isEmpty()){
            users = usersList;
        }else {
            users = null;
        }
        return users;
    }

    // save user
    public User saveUser(User user) {

        user.setId(++usersCount);
        usersList.add(user);
        return user;
    }

    public boolean checkIfUserExist(User user){
        boolean isIn = false;

        for ( User userr : usersList){
            if (user.getName().equalsIgnoreCase(userr.getName()) ||
                    user.getBirthDate().equalsIgnoreCase(userr.getBirthDate())){
                isIn = true;
                break;
            }

        }
        return  isIn;
    }

    // Delete user by id
    public void deleteUserById (int id){

        for (int i = 0 ; i < usersList.size() ; i++){
            if (usersList.get(i).getId() == id){
                usersList.remove(i);
                break;
            }
        }
    }
}
