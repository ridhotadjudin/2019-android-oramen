package com.example.hp.retailmakanan;

public class RekomenModel {
    private int image;
    private String title;
    private String harga;

    public RekomenModel(int image, String title, String harga) {
        this.image = image;
        this.title = title;
        this.harga = harga;
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

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}
