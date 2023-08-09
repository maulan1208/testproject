package edu.vti.rocket.democl3.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Pen")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pen {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    Color color;
    public enum Color{
        RED, GREEN, BLUE, YELLOW
    }
    Date year;

    String brand;

    Integer producNo;

    Boolean isTest;

    Float price;


}
