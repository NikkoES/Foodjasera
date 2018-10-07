package com.foodjasera.foodjasera.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MenuKedai implements Serializable {

    @SerializedName("")
    private String idMenu;
    @SerializedName("")
    private String idKedai;
    @SerializedName("")
    private String namaMenu;
    @SerializedName("")
    private String hargaMenu;
    @SerializedName("")
    private String deskripsiMenu;
    @SerializedName("")
    private String imageMenu;
    @SerializedName("")
    private String statusMenu;

    public boolean isSelected;

    public MenuKedai(String idMenu, String idKedai, String namaMenu, String hargaMenu, String deskripsiMenu, String imageMenu, String statusMenu) {
        this.idMenu = idMenu;
        this.idKedai = idKedai;
        this.namaMenu = namaMenu;
        this.hargaMenu = hargaMenu;
        this.deskripsiMenu = deskripsiMenu;
        this.imageMenu = imageMenu;
        this.statusMenu = statusMenu;
    }

    public boolean getSelected() {
        return isSelected;
    }
    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public String getIdKedai() {
        return idKedai;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public String getHargaMenu() {
        return hargaMenu;
    }

    public String getDeskripsiMenu() {
        return deskripsiMenu;
    }

    public String getImageMenu() {
        return imageMenu;
    }

    public String getStatusMenu() {
        return statusMenu;
    }
}
