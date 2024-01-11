package com.example.ms1.controller;

import com.example.ms1.entities.Field;
import com.example.ms1.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/field")
public class FieldController {

    @Autowired
    private FieldService fieldService;

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
