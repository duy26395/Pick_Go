package com.example.mypc.i_tour.Data;

/**
 * Created by MyPC on 07/08/2017.
 */

public class Data_favorite {
    private int id;
    private String name,intro,image;

    public Data_favorite(int id, String name, String intro, String image) {
        this.id = id;
        this.name = name;
        this.intro = intro;
        this.image = image;
    }
    public Data_favorite(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
