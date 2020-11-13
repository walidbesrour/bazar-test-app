package com.example.elbazar.Model;

public class Produit_Model {

    private boolean  Etat_produit ;
    private String Nom_produit ;
    private double Prix_produit ;
    private String Marque_produit ;
    private int Quantité_produit ;
    private String image_produit ;

    public Produit_Model(String nom_produit, double prix_produit, String image_produit) {
        Nom_produit = nom_produit;
        Prix_produit = prix_produit;
        this.image_produit = image_produit;
    }

    public Produit_Model(boolean etat_produit, String nom_produit, double prix_produit, String marque_produit, int quantité_produit, String image_produit) {
        Etat_produit = etat_produit;
        Nom_produit = nom_produit;
        Prix_produit = prix_produit;
        Marque_produit = marque_produit;
        Quantité_produit = quantité_produit;
        this.image_produit = image_produit;
    }

    public boolean isEtat_produit() {
        return Etat_produit;
    }

    public void setEtat_produit(boolean etat_produit) {
        Etat_produit = etat_produit;
    }

    public String getNom_produit() {
        return Nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        Nom_produit = nom_produit;
    }

    public double getPrix_produit() {
        return Prix_produit;
    }

    public void setPrix_produit(int prix_produit) {
        Prix_produit = prix_produit;
    }

    public String getMarque_produit() {
        return Marque_produit;
    }

    public void setMarque_produit(String marque_produit) {
        Marque_produit = marque_produit;
    }

    public int getQuantité_produit() {
        return Quantité_produit;
    }

    public void setQuantité_produit(int quantité_produit) {
        Quantité_produit = quantité_produit;
    }

    public String getImage_produit() {
        return image_produit;
    }

    public void setImage_produit(String image_produit) {
        this.image_produit = image_produit;
    }
}
