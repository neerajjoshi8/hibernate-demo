package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
public class Student {
    private long id;
    private String name;
    private String email;
    private String department;
}
