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
public class Stok {
    private int stok_id;
    private int urun_id;
    private int magaza_id;
    private int adet;
    private java.sql.Timestamp son_guncelleme_tarihi;

    public int getStok_id() {
        return stok_id;
    }

    public void setStok_id(int stok_id) {
        this.stok_id = stok_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public int getMagaza_id() {
        return magaza_id;
    }

    public void setMagaza_id(int magaza_id) {
        this.magaza_id = magaza_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    public Timestamp getSon_guncelleme_tarihi() {
        return son_guncelleme_tarihi;
    }

    public void setSon_guncelleme_tarihi(Timestamp son_guncelleme_tarihi) {
        this.son_guncelleme_tarihi = son_guncelleme_tarihi;
    }
    
}
