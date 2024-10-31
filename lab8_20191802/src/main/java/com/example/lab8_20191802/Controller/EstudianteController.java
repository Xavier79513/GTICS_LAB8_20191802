package com.example.lab8_20191802.Controller;

import com.example.lab8_20191802.Entity.Estudiante;
import com.example.lab8_20191802.Repository.EstudianteRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class EstudianteController {

    final EstudianteRepository estudianteRepository;


    public EstudianteController(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    //Listar Estudiantes con filtro
    @GetMapping(value = {"/estudiante/{facultad}"}, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public List<Estudiante> listaEstudiantesFacultad(@PathVariable String facultad) {
        return estudianteRepository.findByFacultadOrderByGpaDesc(facultad);
    }

    @GetMapping(value = {"/estudiante", ""}, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public List<Estudiante> listaEstudiantes() {
        return estudianteRepository.findAll();
    }

    @PostMapping(value = {"/estudiante"}, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<HashMap<String, Object>> guardarEstudiante(@RequestBody Estudiante estudiante,
                                                                    @RequestParam(value = "fetchIdEstudiante", required = false) boolean fetchid) {
        HashMap<String, Object> responseMap = new HashMap<>();
        estudianteRepository.save(estudiante);
        if (fetchid) {
            responseMap.put("idEstudiante", estudiante.getIdEstudiante());
        }
}
