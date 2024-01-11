package com.example.ms1.controller;

import com.example.ms1.entities.Field;
import com.example.ms1.entities.Liable;
import com.example.ms1.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;
    @Autowired
    RestTemplate restTemplate;
    String uri = "http://localhost:8080/api";
    @GetMapping("/liable")
    public List<Liable> getLiable(){
        return restTemplate.getForObject(this.uri + "/liable", List.class);
    }
    @GetMapping("")
    public List<Field> findAll() {
        return fieldService.findAll();
    }

    @GetMapping("id/{id}")
    public Optional<Field> findById(@PathVariable int id) {
        return fieldService.findById(id);
    }

    @PostMapping("")
    public int save(@RequestBody Field field) {
        return fieldService.save(field);
    }

    @DeleteMapping("")
    public void deleteAll() {
        fieldService.deleteAll();
    }
}
