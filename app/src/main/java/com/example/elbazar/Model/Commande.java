package com.example.elbazar.Model;

public class Commande {

    private boolean  Etat ;
    private String Nom_produit ;
    private int Prix ;
    private String Marque ;
    private int Quantité ;
    private int image_commande ;

    public Commande(boolean etat, String nom_produit, int prix, String marque, int quantité, int image_commande) {
        Etat = etat;
        Nom_produit = nom_produit;
        Prix = prix;
        Marque = marque;
        Quantité = quantité;
        this.image_commande = image_commande;
    }

    public Commande(String nom_produit, int prix, int quantité, int image_commande) {
        Nom_produit = nom_produit;
        Prix = prix;
        Quantité = quantité;
        this.image_commande = image_commande;
    }

    public boolean isEtat() {
        return Etat;
    }

    public void setEtat(boolean etat) {
        Etat = etat;
    }

    public String getNom_produit() {
        return Nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        Nom_produit = nom_produit;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public int getQuantité() {
        return Quantité;
    }

    public void setQuantité(int quantité) {
        Quantité = quantité;
    }

    public int getImage_commande() {
        return image_commande;
    }

    public void setImage_commande(int image_commande) {
        this.image_commande = image_commande;
    }
}
