package com.example.hp.retailmakanan.Model;

public class MenuModel {

    private String id_menu, nama_menu, deskripsi,imgUrl;
    private int harga;

    public MenuModel(String id_menu, String nama_menu, String deskripsi, String imgUrl, int harga) {
        this.id_menu = id_menu;
        this.nama_menu = nama_menu;
        this.deskripsi = deskripsi;
        this.imgUrl = imgUrl;
        this.harga = harga;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public String getNama_menu() {
        return nama_menu;
    }

    public void setNama_menu(String nama_menu) {
        this.nama_menu = nama_menu;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
