package com.foodjasera.foodjasera.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Transaksi implements Serializable {

    @SerializedName("")
    private String idTransaksi;
    @SerializedName("")
    private String tanggalTransaksi;
    @SerializedName("")
    private String alamatTransaksi;
    @SerializedName("")
    private String statusTransaksi;
    @SerializedName("")
    private String jumlahPesanan;
    @SerializedName("")
    private String totalHarga;
    @SerializedName("")
    private String idKurir;
    @SerializedName("")
    private String namaKurir;
    @SerializedName("")
    private String phoneKurir;
    @SerializedName("")
    private String imageKurir;
    @SerializedName("")
    private String idUser;
    @SerializedName("")
    private String namaUser;
    @SerializedName("")
    private String phoneUser;
    @SerializedName("")
    private String alamatUser;
    @SerializedName("")
    private String idPujasera;
    @SerializedName("")
    private String namaPujasera;
    @SerializedName("")
    private String alamatPujasera;
    @SerializedName("")
    private String phonePujasera;
    @SerializedName("")
    private List<MenuKedai> listPesanan;

    public Transaksi(String idTransaksi, String tanggalTransaksi, String alamatTransaksi, String statusTransaksi, String jumlahPesanan, String totalHarga, String idKurir, String namaKurir, String phoneKurir, String imageKurir, String idUser, String namaUser, String phoneUser, String alamatUser, String idPujasera, String namaPujasera, String alamatPujasera, String phonePujasera, List<MenuKedai> listPesanan) {
        this.idTransaksi = idTransaksi;
        this.tanggalTransaksi = tanggalTransaksi;
        this.alamatTransaksi = alamatTransaksi;
        this.statusTransaksi = statusTransaksi;
        this.jumlahPesanan = jumlahPesanan;
        this.totalHarga = totalHarga;
        this.idKurir = idKurir;
        this.namaKurir = namaKurir;
        this.phoneKurir = phoneKurir;
        this.imageKurir = imageKurir;
        this.idUser = idUser;
        this.namaUser = namaUser;
        this.phoneUser = phoneUser;
        this.alamatUser = alamatUser;
        this.idPujasera = idPujasera;
        this.namaPujasera = namaPujasera;
        this.alamatPujasera = alamatPujasera;
        this.phonePujasera = phonePujasera;
        this.listPesanan = listPesanan;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public String getAlamatTransaksi() {
        return alamatTransaksi;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public String getJumlahPesanan() {
        return jumlahPesanan;
    }

    public String getTotalHarga() {
        return totalHarga;
    }

    public String getIdKurir() {
        return idKurir;
    }

    public String getNamaKurir() {
        return namaKurir;
    }

    public String getPhoneKurir() {
        return phoneKurir;
    }

    public String getImageKurir() {
        return imageKurir;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public String getPhoneUser() {
        return phoneUser;
    }

    public String getAlamatUser() {
        return alamatUser;
    }

    public String getIdPujasera() {
        return idPujasera;
    }

    public String getNamaPujasera() {
        return namaPujasera;
    }

    public String getAlamatPujasera() {
        return alamatPujasera;
    }

    public String getPhonePujasera() {
        return phonePujasera;
    }

    public List<MenuKedai> getListPesanan() {
        return listPesanan;
    }
}
