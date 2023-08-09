package edu.vti.rocket.democl3.service;

import edu.vti.rocket.democl3.domain.QuanAo;
import edu.vti.rocket.democl3.repository.QuanAoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class QuanAoService {

    private final QuanAoRepository quanAoRepository;

    public QuanAoService(QuanAoRepository quanAoRepository) {
        this.quanAoRepository = quanAoRepository;
    }


    //find all
    public List<QuanAo> findAll(){
        return quanAoRepository.findAll();
    }

    public Page<QuanAo> findAllPaging(Pageable pageable){
        return quanAoRepository.findAll(pageable);
    }
    //find one
    public Optional<QuanAo> findOneOptional(Long id) {
        return quanAoRepository.findById(id);
    }

    public QuanAo findOne(Long id){
        Optional<QuanAo> optionalQuanAo = quanAoRepository.findById(id);
        if(optionalQuanAo.isPresent()){
            return optionalQuanAo.get();
        }
        return new QuanAo();
//        return null;
    }

    // save
    public QuanAo save(QuanAo quanAo){
        return quanAoRepository.save(quanAo);
    }

    // update
    public QuanAo update(QuanAo quanAo){
        return quanAoRepository.save(quanAo);
    }

    // delete
    public void delete(QuanAo quanAo){
        quanAoRepository.delete(quanAo);
    }

    public void deleteById(Long id){
        quanAoRepository.deleteById(id);
    }
}
