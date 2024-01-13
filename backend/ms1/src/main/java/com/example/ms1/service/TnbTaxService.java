package com.example.ms1.service;

import com.example.ms1.dao.CategoryDao;
import com.example.ms1.dao.TnbTaxDao;
import com.example.ms1.entities.Category;
import com.example.ms1.entities.Field;
import com.example.ms1.entities.TnbTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TnbTaxService {

    @Autowired
    private TnbTaxDao tnbTaxDao;
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private FieldService fieldService;

    public List<TnbTax> findAll() {
        return tnbTaxDao.findAll();
    }

    public ResponseEntity<List<TnbTax>> findAllByField_Id(int fieldId) {
        if (tnbTaxDao.findAllByField_Id(fieldId).isEmpty())
            return ResponseEntity.badRequest().build();
        else {
            return ResponseEntity.ok(tnbTaxDao.findAllByField_Id(fieldId));
        }
    }

    public ResponseEntity<String> updatePayement(int id, boolean IsPayed) {
        if (tnbTaxDao.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().body("Cannot find category with id " + id);
        } else {
            TnbTax tnbTax = tnbTaxDao.findById(id).get();
            tnbTax.setIsPayed(IsPayed);
            tnbTaxDao.save(tnbTax);
            return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<String> save(TnbTax tnbTax) {
        if (tnbTax == null)
            return ResponseEntity.badRequest().body("Cannot save null tax");
        else {
            try {

                TnbTax tnbTaxResult = new TnbTax();
                Field field = new Field();
                Category category = new Category();
                float taxTNB;

                tnbTaxResult = tnbTax;
                field = tnbTax.getField();
                category = field.getCategory();
                taxTNB = (field.getSurface() * category.getRate());
                System.out.println("SURFACE : " + field.getSurface() + " |  RATE : " + category.getRate());
                tnbTaxResult.setTotal(taxTNB);
                tnbTaxDao.save(tnbTaxResult);
            } catch (Exception e) {
                System.out.println("ERREUR POST : " + e.getMessage());
            }
                return ResponseEntity.ok().build();
        }
    }

    public ResponseEntity<String> setTotale(int id) {
        if (tnbTaxDao.findById(id).isEmpty()) {
            return ResponseEntity.badRequest().body("Cannot find category with id " + id);
        } else {
            TnbTax tnbTax = tnbTaxDao.findById(id).get();
            float rate = categoryDao.findById(tnbTax.getField().getCategory().getId()).get().getRate();
            float surface = fieldService.findById(tnbTax.getField().getId()).get().getSurface();
            tnbTax.setTotal(rate * surface);
            tnbTaxDao.save(tnbTax);
            return ResponseEntity.ok().build();
        }
    }
}
