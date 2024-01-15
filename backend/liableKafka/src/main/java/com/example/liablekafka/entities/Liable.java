package com.example.liablekafka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Liable {
    private int id;
    private String lastName;
    private String firstName;
    private String cin;
    private String password;
}
