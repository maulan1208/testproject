package edu.vti.rocket.democl3.domain;

import javax.persistence.*;

@Entity
@Table(name = "TB_PK") //ORM
public class QuanAo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private LoaiMatHang loaiMatHang;
    public enum LoaiMatHang {
        Ao, Quan, PK
    }
    @Column(name = "size")
    private int size;
    @Column(name = "price")
    private float price;
    @Column(name = "gender")
    private String gender;

    public QuanAo(){
    }
    public QuanAo(Long id, LoaiMatHang loaiMatHang, int size, float price, String gender) {
        this.id = id;
        this.loaiMatHang = loaiMatHang;
        this.size = size;
        this.price = price;
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public LoaiMatHang getLoaiMatHang() {
        return loaiMatHang;
    }

    public void setLoaiMatHang(LoaiMatHang loaiMatHang) {
        this.loaiMatHang = loaiMatHang;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
