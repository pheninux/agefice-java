package com.agefice.doc.repository;

import com.agefice.doc.entity.Dossiers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierRepository extends JpaRepository<Dossiers,String> {

}
