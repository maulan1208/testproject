package edu.vti.rocket.democl3.controller;

import edu.vti.rocket.democl3.domain.QuanAo;
import edu.vti.rocket.democl3.repository.QuanAoRepository;
import edu.vti.rocket.democl3.service.QuanAoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class QuanAoController {
    final QuanAoRepository quanAoRepository;
    final QuanAoService quanAoService;

    public QuanAoController(@Autowired QuanAoRepository quanAoRepository, QuanAoService quanAoService) {
        this.quanAoRepository = quanAoRepository;
        this.quanAoService = quanAoService;
    }



    // Lấy toàn bộ danh sách QUANAO
    // url: http://address:port/api/version/object
    // url: http://localhost:8080/api/v1/clothes + GET ALL
//    @GetMapping("/quanao")
//    public List<QuanAo> getAll() {
//        return quanAoRepository.findAll();
//    }

    @GetMapping("/quanao")
    public Page<QuanAo> findAll() {
//        Pageable pageable = Pageable.ofSize(10);
        Pageable pageable = PageRequest.of(1, 2);
        return quanAoService.findAllPaging(pageable);
    }

    // Lấy 1 theo id
    // url: http://localhost:8080/api/v1/clothes/{cloth_id} + GET ALL
    @GetMapping("/quanao/{id}") //lay du lieu tu FE
    // URL chứa duoc thong tin va truyen tai den voi FE
    // PATH / PARAM
    public QuanAo getOne(@PathVariable Long id) {
        Optional<QuanAo> quanAoOptional = quanAoRepository.findById(id);
        if(quanAoOptional.isPresent()){
            return quanAoOptional.get();
        } else {
            return null;
        }
    }

    // Tìm kiếm theo tiêu chí người dùng
    // url: http://localhost:8080/api/v1/clothes/findByGender + GET ALL
    @GetMapping("/quanao1/{type}") //lay du lieu tu FE
    // URL chứa duoc thong tin va truyen tai den voi FE
    // PATH / PARAM
    public List<QuanAo> getByType(@RequestParam String type) {
        return quanAoRepository.getByTypeWithHQL(QuanAo.LoaiMatHang.valueOf(type));
    }

    // Thêm 1 (n) đối tượng
    // url: http://localhost:8080/api/v1/clothes + POST
    @PostMapping("/quanao")
    public QuanAo createJob(@RequestBody QuanAo quanAo)  {
        System.out.println(quanAo);
        return quanAoRepository.save(quanAo);
    }


    // sửa 1 (n) đối tượng
    // url: http://localhost:8080/api/v1/clothes/{cloth_id} + PUT
    @PutMapping ("/quanao/{id}") //lay du lieu tu FE
    // URL chứa duoc thong tin va truyen tai den voi FE
    // PATH / PARAM
    public QuanAo updateOne(@PathVariable Long id, @RequestBody QuanAo quanAo) {
        Optional<QuanAo> newQuanAo = quanAoRepository.findById(id);
        if (newQuanAo.isPresent()){
            QuanAo quanAo1 = newQuanAo.get();
            quanAo1.setLoaiMatHang(quanAo.getLoaiMatHang());
            quanAo1.setSize(quanAo.getSize());
            quanAo1.setPrice(quanAo.getPrice());
            quanAo1.setGender(quanAo.getGender());
            return new ResponseEntity<>(quanAoRepository.save(quanAo1), HttpStatus.OK).getBody();
        } else {
            return null;
        }
    }

    // Xóa 1 (n) đối tượng
    // url: http://localhost:8080/api/v1/clothes/{cloth_id} + DELETE
    @DeleteMapping ("/quanao/{id}") //lay du lieu tu FE
    // URL chứa duoc thong tin va truyen tai den voi FE
    // PATH / PARAM
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            quanAoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
