package com.example.ms2.controller;

import com.example.ms2.entities.Liable;
import com.example.ms2.service.LiableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/liable")
public class LiableController {
    @Autowired
    private LiableService liableService;

    @GetMapping("")
    public List<Liable> findAll() {
        return liableService.findAll();
    }

    @GetMapping("id/{id}")
    public Optional<Liable> findById(@PathVariable int id) {
        return liableService.findById(id);
    }

    @PostMapping("")
    public int save(@RequestBody Liable field) {
        return liableService.save(field);
    }

    @DeleteMapping("")
    public void deleteAll() {
        liableService.deleteAll();
    }
}
