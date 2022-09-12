package com.gwabs.spring_example.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDAO userDAO;
    public UserController(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public List<User> alluser(){
        return userDAO.getUsersList();
    }

    @GetMapping("/users/{id}")
    public User getSpesificUser(@PathVariable int id){
        return userDAO.getSpecificUser(id);
    }

    /*
    @DeleteMapping("/users/delete_user/{id}")
    public String deleteSpesificUser(@PathVariable int id){
        return userDAO.deleteUser(id);
    }


     */

    /*
     private String name;
  private String birthDate;
  private String Work;

  private String Relationship_Status;
     */

    @PostMapping("/users")
    public message createUser(@RequestBody User user){
      User saveduser =  userDAO.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
       return new message(ResponseEntity.created(location).build().getStatusCode().value(),"User Created",location);

    }
}

/*
{
    "id": 1,
    "name": "Danlami lawandi ",
    "birthDate": "18 - 09 - 1556",
    "gender": "Male",
    "relationship_Status": "Single",
    "work": "Baduqu"
}

 */