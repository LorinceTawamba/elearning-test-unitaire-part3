package com.iuc.master.tl.traitement;

import com.iuc.master.tl.entite.Produit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestionProduitTest {

    private GestionProduit gestionProduit;

    @BeforeEach
    public void setup() {
        gestionProduit = new GestionProduit();
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void consulterProduitTest() {
        // Given : Étant donné ce contexte de test
        Produit produit = null;
        Produit compareProduit = new Produit(1, "REF1", "TOTO", "R.A.S", 22000, 18);
        int id = 1;

        // When : Quand j’exécute la fonctionnalité testée
        produit = gestionProduit.consulterProduit(id);

        // Then : je m’attends à ce résultat.
        assertNotNull(produit);

    }



}
