package com.example.kas.model;

public class Organization {
    private String description;
    private String image_display_url;

    public Organization(){}

    public Organization(String description, String image_display_url) {
        this.description = description;
        this.image_display_url = image_display_url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_display_url() {
        return image_display_url;
    }

    public void setImage_display_url(String image_display_url) {
        this.image_display_url = image_display_url;
    }
}