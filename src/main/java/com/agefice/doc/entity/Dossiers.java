package com.agefice.doc.entity;

import lombok.Data;
import org.w3c.dom.Document;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Data
public class Dossiers {
    @Id
    private String numDossier;
    private Timestamp dateCreation;
    private String statut;

    @OneToOne
    private Formations formation;

    @ManyToOne
    private Stagiaires stagiaires ;

    @ManyToMany(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinTable(name = "documents_dossiers" ,
               joinColumns = {@JoinColumn(name = "num_dossier")} ,
               inverseJoinColumns = {@JoinColumn(name = "document_id" )} )
    private Collection<Documents> documents;

}
