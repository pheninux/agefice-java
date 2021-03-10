package com.agefice.doc.repository;

import com.agefice.doc.entity.Entreprises;
import com.agefice.doc.entity.Stagiaires;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepository extends JpaRepository<Entreprises,Integer> {

}
