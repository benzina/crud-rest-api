package com.crud.api.crudrestapitutoriel.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "employes")
@Entity
@Data
public class Employe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name",nullable = false)
    private String firstName;

    @Column(name = "last_name",nullable = false)
    private String lastName;

    @Column(name = "email")
     private String email;
}
