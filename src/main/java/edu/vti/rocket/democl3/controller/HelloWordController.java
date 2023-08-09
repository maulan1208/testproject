package edu.vti.rocket.democl3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //spring stereotype annotattions
@RequestMapping("/api")
public class HelloWordController {
    @GetMapping("/p")
    public String getAl() {
        return "h";
    }

//    @GetMapping("/people")
//    public List<People> getAll() {
//        return peopleRepository.findAll();
//    }

}
