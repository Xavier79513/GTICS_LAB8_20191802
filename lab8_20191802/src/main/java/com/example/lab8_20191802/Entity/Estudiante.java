package com.example.lab8_20191802.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Entity
@Table(name = "Estudiante")
@Getter
@Setter
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEstudiante", nullable = false)
    private Integer idEstudiante;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @ColumnDefault("0.00")
    @Column(name = "gpa", precision = 10, scale = 2)
    private BigDecimal gpa;

    @Column(name = "facultad", nullable = false, length = 45)
    private String facultad;

    @ColumnDefault("0.00")
    @Column(name = "creditosCom", precision = 10, scale = 2)
    private BigDecimal creditosCom;

}
