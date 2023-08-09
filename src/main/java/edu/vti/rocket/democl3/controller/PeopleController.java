package edu.vti.rocket.democl3.controller;

import edu.vti.rocket.democl3.domain.People;
import edu.vti.rocket.democl3.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeopleController {

    final PeopleRepository peopleRepository;

    public PeopleController(@Autowired PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/people")
    public List<People> getAll() {
        return peopleRepository.findAll();
    }
}
