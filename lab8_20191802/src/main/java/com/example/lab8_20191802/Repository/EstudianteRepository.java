package com.example.lab8_20191802.Repository;

import com.example.lab8_20191802.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
    List<Estudiante> findByFacultadOrderByGpaDesc(String facultad);

}
