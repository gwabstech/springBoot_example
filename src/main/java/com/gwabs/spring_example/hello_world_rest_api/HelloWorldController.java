package com.gwabs.spring_example.hello_world_rest_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Rest API
@RestController
public class HelloWorldController {

    // /hello-world

    // return hello world
    // get mapping and the method
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        HelloWorldBean helloWorldBean = new HelloWorldBean(" Abubakar %s".formatted(name),26,"Android Developer");
        return helloWorldBean;
    }
}
