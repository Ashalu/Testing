package com.cpu_z.Model;

public class DataModel {

    String text;
    int image;


    public DataModel(String name, int type) {
        this.text = name;
        this.image = type;

    }

    public String getName() {
        return text;
    }

    public int getType() {
        return image;
    }

}