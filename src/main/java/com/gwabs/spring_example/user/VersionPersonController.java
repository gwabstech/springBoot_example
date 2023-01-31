package com.gwabs.spring_example.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionPersonController {

    @GetMapping("/v1/person")
    public Person getFirstVPerson(){
        return new Person("Abubakar");
    }

    @GetMapping("/v2/person")
    public PersonV2 get2ndVPerson(){
        return new PersonV2("Abubakar","Abdullahi");
    }
}
