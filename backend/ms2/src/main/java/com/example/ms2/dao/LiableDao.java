package com.example.ms2.dao;

import com.example.ms2.entities.Liable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiableDao extends JpaRepository<Liable, Integer> {
}
