package com.agefice.doc.repository;

import com.agefice.doc.entity.Formations;
import com.agefice.doc.entity.Stagiaires;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StagiaireRepository extends JpaRepository<Stagiaires,Integer> {

}
