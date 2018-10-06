package com.foodjasera.foodjasera.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pujasera implements Serializable {

    @SerializedName("")
    private String id;
    @SerializedName("")
    private String nama;
    @SerializedName("")
    private String email;
    @SerializedName("")
    private String alamat;
    @SerializedName("")
    private String deskripsi;
    @SerializedName("")
    private String jumlahKedai;
    @SerializedName("")
    private String statusBuka;
    @SerializedName("")
    private double longitude;
    @SerializedName("")
    private double latitude;
    @SerializedName("")
    private String image;

    public Pujasera(String id, String nama, String email, String alamat, String deskripsi, String jumlahKedai, String statusBuka, double longitude, double latitude, String image) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.deskripsi = deskripsi;
        this.jumlahKedai = jumlahKedai;
        this.statusBuka = statusBuka;
        this.longitude = longitude;
        this.latitude = latitude;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getJumlahKedai() {
        return jumlahKedai;
    }

    public String getStatusBuka() {
        return statusBuka;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getImage() {
        return image;
    }
}
