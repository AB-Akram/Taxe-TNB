package com.example.ms2.service;

import com.example.ms2.dao.LiableDao;
import com.example.ms2.entities.Liable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiableService {
    @Autowired
    private LiableDao liableDao;

    public int save(Liable liable) {
        if (liable == null) return -1;
        else {
            liableDao.save(liable);
            return 1;
        }
    }

    public List<Liable> findAll() {
        return liableDao.findAll();
    }

    public Optional<Liable> findById(int id) { //Optional peut rendre un ou plusieur
        return liableDao.findById(id);
    }

    public void deleteAll() {
        liableDao.deleteAll();
    }
}
