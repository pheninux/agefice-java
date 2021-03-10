package com.agefice.doc.repository;

import com.agefice.doc.entity.Documents;
import com.agefice.doc.entity.Stagiaires;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends JpaRepository<Documents,Integer> {




}
