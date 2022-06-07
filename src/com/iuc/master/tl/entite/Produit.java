package com.iuc.master.tl.entite;

import java.util.Objects;

public class Produit {
    private int id;
    private String ref;
    private String nom;
    private String desc;
    private double prix;
    private int qte;

    public Produit() {
        super();
    }

    public Produit(int id, String ref, String nom, String desc, double prix, int qte) {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produit)) return false;

        Produit produit = (Produit) o;

        if (getId() != produit.getId()) return false;
        if (Double.compare(produit.getPrix(), getPrix()) != 0) return false;
        if (getQte() != produit.getQte()) return false;
        if (getRef() != null ? !getRef().equals(produit.getRef()) : produit.getRef() != null) return false;
        if (getNom() != null ? !getNom().equals(produit.getNom()) : produit.getNom() != null) return false;
        return getDesc() != null ? getDesc().equals(produit.getDesc()) : produit.getDesc() == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRef(), getNom(), getDesc(), getPrix(), getQte());
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", ref='" + ref + '\'' +
                ", nom='" + nom + '\'' +
                ", desc='" + desc + '\'' +
                ", prix=" + prix +
                ", qte=" + qte +
                '}';
    }
}
