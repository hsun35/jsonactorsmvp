package com.example.hefen.jsonactorsmvp.model;

import java.util.List;

/**
 * Created by hefen on 5/4/2018.
 */

public class Actor {
    String name;
    String country;
    String height;
    String image;

    public Actor(String name, String country, String height, String image) {
        this.name = name;
        this.country = country;
        this.height = height;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
