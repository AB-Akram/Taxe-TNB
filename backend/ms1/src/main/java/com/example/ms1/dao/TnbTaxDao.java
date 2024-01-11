package com.example.ms1.dao;

import com.example.ms1.entities.TnbTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TnbTaxDao extends JpaRepository<TnbTax, Integer> {

    List<TnbTax> findAllByField_Id(int fieldId);
}