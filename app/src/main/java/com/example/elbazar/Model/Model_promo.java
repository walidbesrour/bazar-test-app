package com.example.elbazar.Model;

public class Model_promo {

    private int image;
    private String title;
    private String desc;
    private String image_produit;

    public Model_promo(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public Model_promo(String title, String desc, String image_produit) {
        this.title = title;
        this.desc = desc;
        this.image_produit = image_produit;
    }

    public String getImage_produit() {
        return image_produit;
    }

    public void setImage_produit(String image_produit) {
        this.image_produit = image_produit;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
