package edu.vti.rocket.democl3.repository;

import edu.vti.rocket.democl3.domain.QuanAo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuanAoRepository extends JpaRepository<QuanAo, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM rocket34.TB_PK WHERE type = ?1") //native Query
    //yeu cau -> SQL -> tao query o repo
    public List<QuanAo> getByType(String type);

    // HQL
    @Query(nativeQuery = false, value = "SELECT t FROM QuanAo t WHERE t.loaiMatHang = ?1")
    public List<QuanAo> getByTypeWithHQL(QuanAo.LoaiMatHang type);

    // Naming Query
    public List<QuanAo> findByLoaiMatHang(QuanAo.LoaiMatHang type);
}
