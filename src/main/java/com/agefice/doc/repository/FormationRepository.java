package com.agefice.doc.repository;

import com.agefice.doc.entity.Dossiers;
import com.agefice.doc.entity.Formations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formations,Integer> {

}
