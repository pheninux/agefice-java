package com.agefice.doc.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Entreprises {
    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String nom;

    @ManyToOne
    private Stagiaires stagiaire ;



}
