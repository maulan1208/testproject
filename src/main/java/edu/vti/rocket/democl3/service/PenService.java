package edu.vti.rocket.democl3.service;

import edu.vti.rocket.democl3.domain.Pen;
import edu.vti.rocket.democl3.repository.PenRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

//import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Service
public class PenService {

    private final PenRepository penRepository;

    public PenService(PenRepository penRepository) {
        this.penRepository = penRepository;
    }

    //find all
    public List<Pen> findAll(){
        return  penRepository.findAll();
    }

    public Page<Pen> findAllPaging(Pageable pageable){
        return penRepository.findAll(pageable);
    }
    //find one
    public Optional<Pen> findOneOptional(Long id) {
        return penRepository.findById(id);
    }

    public Pen findOne(Long id){
        Optional<Pen> optionalPen = penRepository.findById(id);
        if(optionalPen.isPresent()){
            return optionalPen.get();
        }
        return new Pen();
//        return null;
    }

    // save
    public Pen save(Pen pen){
        return penRepository.save(pen);
    }

    // update
    public Pen update(Pen pen){
        return penRepository.save(pen);
    }

    // delete
    public void delete(Pen pen){
        penRepository.delete(pen);
    }

    public void deleteById(Long id){
        penRepository.deleteById(id);
    }
}
