package com.example.ms1.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int surface;
    private String address;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "field")
    @JsonIgnore
    private List<TnbTax> tnbTaxes;
    @ManyToOne
    private Liable liable;

}
