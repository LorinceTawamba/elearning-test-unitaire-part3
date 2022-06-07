package com.iuc.master.tl.bd;

import com.iuc.master.tl.entite.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BdManager {

    private String driverName;
    private String url;
    private String userName;
    private String userPassword;

    private Connection conn;
    private Statement statement;
    private ResultSet resultset;
    public BdManager(String url, String userName, String userPassword) {
        driverName = "com.mysql.cj.jdbc.Driver";
        this.url = url;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public void loadDriver() {
        try {
            Class.forName(driverName);
            System.out.println("==== Load Driver OK ====");
        }
        catch (ClassNotFoundException exc) {
            System.out.println("==== Load Driver Error ====");
            exc.printStackTrace();
        }
    }

    public void connectToBd() {
        try {
            conn = DriverManager.getConnection(url, userName, userPassword);
            System.out.println("==== Connection OK ====");
        }
        catch (SQLException exc) {
            System.out.println("==== Connection Error ====");
            exc.printStackTrace();
        }
    }

    public int setProduitInBd(String query) {
        int result = 0;
        if (conn != null) {
            try {
                statement = conn.createStatement();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
        try {
            result = statement.executeUpdate(query);
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }

        return result;
    }

    public List<Produit> getProduitInBd(String query) {
        List<Produit> produits = new ArrayList<Produit>();
        Produit produit = new Produit();

        if (conn != null) {
            try {
                statement = conn.createStatement();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        try {
            resultset = statement.executeQuery(query);
            while (resultset.next()) {
                produit.setId(resultset.getInt("id"));
                produit.setId(resultset.getInt("id"));
            }
        }
        catch (SQLException exc) {
            exc.printStackTrace();
        }

        while(true) {
            try {
                if (!resultset.next())
                    break;
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                produit.setId(resultset.getInt("id"));
                produit.setRef(resultset.getString("ref"));
                produit.setNom(resultset.getString("nom"));
                produit.setDesc(resultset.getString("desc"));
                produit.setPrix(resultset.getDouble("prix"));
                produit.setQte(resultset.getInt("qte"));
            }
            catch (SQLException e) {
                throw new RuntimeException(e);
            }

            produits.add(produit);
        }

        return produits;
    }

    public void close() {
        if (resultset != null) {
            try {
                resultset.close();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            }
            catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }
}
