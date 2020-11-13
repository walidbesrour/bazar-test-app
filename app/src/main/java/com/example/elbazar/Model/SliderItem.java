package com.example.elbazar.Model;

public class SliderItem {

    private String description;
    private String imageUrl;
    private int image ;

    public SliderItem(String description, String imageUrl, int image) {
        this.description = description;
        this.imageUrl = imageUrl;
        this.image = image;
    }

    public SliderItem(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public SliderItem(int image) {
        this.image = image;
    }

    public SliderItem() {
       super();
    }

    public int getImage() {
        return image;
    }

    public void setImageResource(int image) {
        this.image = image;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
