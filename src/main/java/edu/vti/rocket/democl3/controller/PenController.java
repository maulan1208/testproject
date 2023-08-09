package edu.vti.rocket.democl3.controller;

import edu.vti.rocket.democl3.domain.Pen;
import edu.vti.rocket.democl3.service.PenService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class PenController {
    private final PenService penService;

    public PenController(PenService penService) {
        this.penService = penService;
    }

//    @GetMapping("/pen")
//    public List<Pen> getAll() {
//        return penService.findAll();
//    }

    @GetMapping("/pen")
    public Page<Pen> findAll() {
//        Pageable pageable = Pageable.ofSize(10);
      Pageable pageable = PageRequest.of(1, 2);
        return penService.findAllPaging(pageable);
    }

//    @GetMapping("/pen")
//    public Page<Pen> findAll(Pageable pageable) {
//        Pageable pageable = Pageable.ofSize(10);
////      Pageable pageable = PageRequest.of(1, 20);
//        return penService.findAllPaging(pageable);
//    }

    //    @GetMapping("/pen")
//    public Page<Pen> findAll(int page, int size) {
////      Pageable pageable = PageRequest.of(page, size);
//        return penService.findAllPaging(pageable);
//    }

    @GetMapping("/pen/{id}")
    public Pen getOne(@PathVariable Long id) {
        Optional<Pen> penOptional = penService.findOneOptional(id);
        if(penOptional.isPresent()){
            return penOptional.get();
        } else {
            return null;
        }
    }

    @PostMapping("/pen")
    public Pen createJob(@RequestBody Pen pen)  {
        System.out.println(pen);
        return penService.save(pen);
    }
}
