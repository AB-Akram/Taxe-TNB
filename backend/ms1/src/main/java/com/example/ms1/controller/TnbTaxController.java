package com.example.ms1.controller;

import com.example.ms1.entities.TnbTax;
import com.example.ms1.service.CategoryService;
import com.example.ms1.service.TnbTaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/tax")
public class TnbTaxController {

    @Autowired
    private TnbTaxService tnbTaxService;

    @GetMapping("")
    public List<TnbTax> findAll(){return tnbTaxService.findAll();}
    @GetMapping("get/{id}")
    public ResponseEntity<List<TnbTax>> findAll(@PathVariable int id) {
        return tnbTaxService.findAllByField_Id(id);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody TnbTax tnbTax) {
        return tnbTaxService.save(tnbTax);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updatePayement(@PathVariable int id, @RequestBody Map<String, Boolean> IsPayedMap) {
        if (!IsPayedMap.containsKey("IsPayed")) {
            return ResponseEntity.badRequest().body("Missing 'IsPayed' field in the request body.");
        }

        boolean IsPayed = IsPayedMap.get("IsPayed");
        return tnbTaxService.updatePayement(id, IsPayed);
    }
}
