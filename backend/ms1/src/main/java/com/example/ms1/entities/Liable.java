package com.example.ms1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liable extends Person {
    private String cin;
    @OneToMany(mappedBy = "liable")
    private List<Field> fields;

}
