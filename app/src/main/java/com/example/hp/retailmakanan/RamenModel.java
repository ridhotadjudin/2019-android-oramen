package com.example.hp.retailmakanan;

public class RamenModel {

    private String id, nama, desk;
    private int harga;

    public RamenModel(String id, String nama, String desk, int harga) {
        this.id = id;
        this.nama = nama;
        this.desk = desk;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
