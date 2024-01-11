package com.example.ms1.service;

import com.example.ms1.dao.CategoryDao;
import com.example.ms1.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public ResponseEntity<List<Category>> findAll() {
        if (categoryDao.findAll().isEmpty())
            return ResponseEntity.badRequest().build();
        else
        {
            return ResponseEntity.ok(categoryDao.findAll());
        }
    }

    public ResponseEntity<Category> findById(int id) {
        if (categoryDao.findById(id).isEmpty())
            return ResponseEntity.badRequest().build();
        else
            return ResponseEntity.ok(categoryDao.findById(id).get());
    }

    public ResponseEntity<String> save(Category category) {
        if (category == null)
            return ResponseEntity.badRequest().body("Cannot save null category");
        else {
            categoryDao.save(category);
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<String> deleteCategory(int id) {
        if (categoryDao.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("Cannot find category with id " + id);
        else {
            categoryDao.deleteById(id);
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<String> updateRate(int id, float rate) {
        if (categoryDao.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().body("Cannot find category with id " + id);
        } else {
            Category category = categoryDao.findById(id).get();
            category.setRate(rate);
            categoryDao.save(category);
            return ResponseEntity.ok().build();
        }
    }



}
