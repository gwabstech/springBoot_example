package com.gwabs.spring_example.user;

import com.gwabs.spring_example.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class UserController {


    private UserRepository userRepo;
    private PostRepository postRepo;
    public UserController(UserRepository userRepo,PostRepository postRepo){

        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @GetMapping("/users")
    public List<User> alluser(){
        return userRepo.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getSpecificUser(@PathVariable int id){
       Optional<User> user =  userRepo.findById(id);
       if (user.isEmpty()){
           throw new UserNotFoundException(" user with id:"+id+" is not found");
       }

       return user;
    }


    @DeleteMapping("/user/delete_user/{id}")
    public message deleteSpecificUser(@PathVariable int id){
        userRepo.deleteById(id);
        return new message(ResponseEntity.status(200).build().getStatusCode().value(),"User"+ id+ " Deleted",null);
    }



    @PostMapping("/user")
    public message createUser(@Valid @RequestBody User user){

        /*
        if (userDAO.checkIfUserExist(user)){
            return new message(403,"User Already Exist",null);

        }else {
         }

         */
            User saveduser =  userRepo.save(user);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveduser.getId()).toUri();
            return new message(ResponseEntity.created(location).build().getStatusCode().value(),"User Created",location);


        /*
        validation code
        else if(user.getName().equalsIgnoreCase("") ||
                user.getBirthDate().equalsIgnoreCase("") ||
                user.getWork().equalsIgnoreCase("") ||
                user.getRelationship_Status().equalsIgnoreCase("")){
            return new message(403,"User can not be empty",null);
         */

    }


    /*
    @GetMapping("/word/{keyword}")
    public String getCryptoPrice(@PathVariable String keyword) throws IOException {

        URL url = new URL("https://api.api-ninjas.com/v1/dictionary?word="+keyword);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-Key","1LqVgUjLl8clSiVDdj9U6A==m8jBasDWlyUDbvxv");

        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);
        System.out.println(root.path("fact").asText());
        return root.get("definition").asText();

    }



     */

    // return with link hateos
    @GetMapping("/user/h/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) {
        Optional<User> user = userRepo.findById(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link =  linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).alluser());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }


    // get users post
    @GetMapping("/user/{user_id}/post")
    public List<Post> getPostForUser(@PathVariable int user_id){

        Optional<User> user = userRepo.findById(user_id);

        if (user.isEmpty())
            throw new UserNotFoundException("id"+user_id);

       return user.get().getPostList();


    }


    @GetMapping("/user/{user_id}/post/{post_id}")
    public Optional<Post> getUsersPostById(@PathVariable int user_id, @PathVariable int post_id){

        Optional<User> user = userRepo.findById(user_id);

        if (user.isEmpty())
            throw new UserNotFoundException("id"+user_id);
        return postRepo.findById(post_id);
    }


    // creat post api
    @PostMapping("/user/{user_id}/post")
    public ResponseEntity<Object> CreatePostForUser(@PathVariable int user_id,@Valid @RequestBody Post post){

        Optional<User> user = userRepo.findById(user_id);

        if (user.isEmpty())
            throw new UserNotFoundException("id"+user_id);

        post.setUser(user.get());
        Post savedPost = postRepo.save(post);

       URI location = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/{id}")
               .buildAndExpand(savedPost.getId())
               .toUri();

       return  ResponseEntity.created(location).build();
    }

}

