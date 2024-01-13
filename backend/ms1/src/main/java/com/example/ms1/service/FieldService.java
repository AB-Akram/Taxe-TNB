package com.example.ms1.service;

import com.example.ms1.dao.FieldDao;
import com.example.ms1.entities.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FieldService {
    @Autowired
    private FieldDao fieldDao;

    public int save(Field field) {
        if (field == null) return -1;
        else {
            fieldDao.save(field);
            return 1;
        }
    }

    public List<Field> findAll() {
        return fieldDao.findAll();
    }

    public Field findFieldByAddress(String address){
        return fieldDao.findFieldByAddress(address);
    }

    public Optional<Field> findById(int id) { //Optional peut rendre un ou plusieur
        return fieldDao.findById(id);
    }

    public void deleteAll() {
        fieldDao.deleteAll();
    }
}
