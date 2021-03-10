package com.agefice.doc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;


@Entity
@Data
public class Documents {
    @Id @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String intitule;
    @ManyToMany(fetch = FetchType.EAGER , cascade = CascadeType.ALL , mappedBy = "documents")
    private Collection<Dossiers> dossier ;

}
