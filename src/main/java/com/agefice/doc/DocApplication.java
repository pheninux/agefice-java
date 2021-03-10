package com.agefice.doc;

import com.agefice.doc.entity.*;
import com.agefice.doc.repository.*;
import com.sun.org.apache.xml.internal.security.utils.JavaUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.Document;

import javax.rmi.CORBA.Util;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}, scanBasePackages = "com.agefice.doc")
public class DocApplication {

    public static void main(String[] args) {
        SpringApplication.run(DocApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(DossierRepository dossierRepository,
                                        FormationRepository formationRepository,
                                        StagiaireRepository stagiaireRepository,
                                        EntrepriseRepository entrepriseRepository,
                                        DocumentRepository documentRepository) {
        return args -> {

            System.out.println("save stagiaire");

            /*Documents d1 = new Documents();
            d1.setIntitule("DOC1");
            Documents d2 = new Documents();
            d2.setIntitule("DOC2");
            Documents d3 = new Documents();
            d3.setIntitule("DOC3");

            ArrayList docs = new ArrayList<String>();
            docs.add(d1);
            docs.add(d2);
            docs.add(d3);
            documentRepository.saveAll(docs);*/


            Integer[] postDocs = {3, 1};
            ArrayList docsFromDb = new ArrayList<String>();
            int t = postDocs[0];
            for (int i = 0; i < postDocs.length; i++) {

                Documents d = new Documents();
                d = documentRepository.findById(postDocs[i]).orElse(null);
                docsFromDb.add(d);
            }

            boolean selectedEntreprise = false;

            Entreprises entr = new Entreprises();
            entr = entrepriseRepository.findById(32).orElse(null);
            if (entr != null) selectedEntreprise = true;


            boolean selectedStagiaire = false;

            Stagiaires stag = new Stagiaires();
            stag = stagiaireRepository.findById(31).orElse(null);
            if (stag != null) selectedEntreprise = true;


            Stagiaires s = new Stagiaires();
            if (!selectedStagiaire) {
                s.setNom("sherine");
                s.setPrenom("haddad");
                s.setMail("adil@gmail.com");
                s.setMfa(false);
                s.setProspection(false);
                s.setCom1("rien");
                s.setCom2("rien");
                s.setSecuriteSociale(1245454545);
                s.setTel("065454324");
                s.setAge(36);
                s.setDateNaissance(new Timestamp(565655));
                s.setAdresse("rue jules verne");
                stagiaireRepository.save(s);
            }

            if (!selectedEntreprise) {
                Entreprises e = new Entreprises();
                e.setNom("PIf");
                e.setStagiaire(!selectedStagiaire ? s : stag);
                entrepriseRepository.save(e);
            }


            Formations f = new Formations();
            f.setCout(400);
            f.setDateDebut(new Timestamp(656565));
            f.setIntitule("PIZZEIRA");
            f.setDateFin(new Timestamp(57576576));
            f.setDateDebut(new Timestamp(868769));
            f.setNbrHeures(45);
            formationRepository.save(f);


            Dossiers d = new Dossiers();
            d.setDateCreation(new Timestamp(678768676));
            d.setStatut("En cours");
            d.setNumDossier("8888999");
            d.setStagiaires(!selectedStagiaire ? s : stag);
            d.setFormation(f);
            d.setDocuments(docsFromDb);
            dossierRepository.save(d);


        };
    }

}
