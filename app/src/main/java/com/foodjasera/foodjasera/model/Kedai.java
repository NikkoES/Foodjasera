package com.foodjasera.foodjasera.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Kedai implements Serializable {

    @SerializedName("")
    private String idKedai;
    @SerializedName("")
    private String idPujasera;
    @SerializedName("")
    private String namaKedai;
    @SerializedName("")
    private String deskripsi;
    @SerializedName("")
    private String status;
    @SerializedName("")
    private String imageKedai;
    @SerializedName("")
    private List<MenuKedai> listMenuKedai;

    public Kedai(String idKedai, String idPujasera, String namaKedai, String deskripsi, String status, String imageKedai, List<MenuKedai> listMenuKedai) {
        this.idKedai = idKedai;
        this.idPujasera = idPujasera;
        this.namaKedai = namaKedai;
        this.deskripsi = deskripsi;
        this.status = status;
        this.imageKedai = imageKedai;
        this.listMenuKedai = listMenuKedai;
    }

    public String getIdKedai() {
        return idKedai;
    }

    public String getIdPujasera() {
        return idPujasera;
    }

    public String getNamaKedai() {
        return namaKedai;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getStatus() {
        return status;
    }

    public String getImageKedai() {
        return imageKedai;
    }

    public List<MenuKedai> getListMenuKedai() {
        return listMenuKedai;
    }
}
