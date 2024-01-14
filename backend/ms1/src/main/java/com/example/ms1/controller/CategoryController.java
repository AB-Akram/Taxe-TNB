package com.example.ms1.controller;

import com.example.ms1.entities.Category;
import com.example.ms1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("id/{id}")
    public ResponseEntity<Category> findById(@PathVariable int id) {
        return categoryService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<String> save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }

    @PatchMapping("rate/{id}")
    public ResponseEntity<String> updateRate(@PathVariable int id, @RequestBody Map<String, Float> rateMap) {
        if (!rateMap.containsKey("rate")) {
            return ResponseEntity.badRequest().body("Missing 'rate' field in the request body.");
        }

        float rate = rateMap.get("rate");
        return categoryService.updateRate(id, rate);
    }
    @PutMapping("")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

}
