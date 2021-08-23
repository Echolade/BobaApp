package com.example.boba;

public class Data {
    private String bobaplace;
    private String description;
    private int logos;

    public Data(String bobaplace, String description, int logos) {
        this.bobaplace = bobaplace;
        this.description = description;
        this.logos = logos;

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBobaplace() {
        return bobaplace;
    }

    public void setBobaplace(String bobaplace) {
        this.bobaplace = bobaplace;
    }

    public int getLogos() {
        return logos;
    }

    public void setLogos(int Logos) {
        this.logos = logos;
    }


}
