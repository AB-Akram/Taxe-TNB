package com.example.ms1.dao;

import com.example.ms1.entities.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends JpaRepository<Field, Integer> {
    Field findFieldByAddress(String address);
}
