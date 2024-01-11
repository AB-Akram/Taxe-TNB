package com.example.ms1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TnbTax {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String labelle;
    private int year;
    private boolean IsPayed;
    private float total;
    @ManyToOne
    private Field field;
}
