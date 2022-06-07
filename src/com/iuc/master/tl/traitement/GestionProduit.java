package com.iuc.master.tl.traitement;

import com.iuc.master.tl.bd.BdManager;
import com.iuc.master.tl.entite.Produit;

import java.util.ArrayList;
import java.util.List;

public class GestionProduit {

    String url;
    String userName;
    String userPassword;

    BdManager bdManager;

    public GestionProduit() {
        super();
        url = "jdbc:mysql://127.0.0.1:3306/bd_gestion?serverTimezone=Africa/Douala";
        userName = "root";
        userPassword = "";
        bdManager = new BdManager(url, userName, userPassword);
    }

    public Produit consulterProduit(int id) {
        String query = "SELECT * FROM produit WHERE id='" + id +"'";
        List<Produit> produits = new ArrayList<Produit>();
        Produit produit = null;

        bdManager.loadDriver();
        bdManager.connectToBd();
        produits = bdManager.getProduitInBd(query);

        if (produits.size() == 1) {
            produit = produits.get(0);
        }
        return produit;
    }
}
