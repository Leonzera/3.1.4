package com.example.demo.model;


import lombok.*;

import jakarta.persistence.*;

@Entity
@Table
//очень хотелось потестировать ломбок
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private Integer age;
}