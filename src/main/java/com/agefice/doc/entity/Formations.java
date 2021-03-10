package com.agefice.doc.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Data
public class Formations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String intitule;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int nbrHeures;
    private double cout;

}

