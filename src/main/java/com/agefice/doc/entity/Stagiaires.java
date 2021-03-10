package com.agefice.doc.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class Stagiaires {
    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String nom;
    private String prenom;
    private int age;
    private Timestamp dateNaissance;
    private String adresse;
    private boolean mfa;
    private boolean prospection;
    private String com1;
    private String com2;
    private String  tel;
    private int securiteSociale;
    private String mail;
    @OneToMany(mappedBy = "stagiaire")
    private Collection<Entreprises> entreprises;
    @OneToMany(mappedBy = "stagiaires", fetch = FetchType.LAZY)
    private Collection<Dossiers> dossiers ;


}
