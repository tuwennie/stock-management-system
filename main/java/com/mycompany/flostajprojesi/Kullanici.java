/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flostajprojesi;

import java.sql.Timestamp;

/**
 *
 * @author tuba
 */
public class Kullanici {

    private int kullanici_id;
    private String kullanici_adi;
    private String sifre;
    private String ad_soyad;
    private String rol;
    private java.sql.Timestamp kayit_tarihi;

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAd_soyad() {
        return ad_soyad;
    }

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Timestamp getKayit_tarihi() {
        return kayit_tarihi;
    }

    public void setKayit_tarihi(Timestamp kayit_tarihi) {
        this.kayit_tarihi = kayit_tarihi;
    }

    
}
