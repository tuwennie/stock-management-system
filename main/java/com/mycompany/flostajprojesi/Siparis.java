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
public class Siparis {
    
    private int siparis_id;
    private java.sql.Timestamp siparis_tarihi;
    private double toplam_fiyat;
    private int magaza_id;

    public int getSiparis_id() {
        return siparis_id;
    }

    public void setSiparis_id(int siparis_id) {
        this.siparis_id = siparis_id;
    }

    public Timestamp getSiparis_tarihi() {
        return siparis_tarihi;
    }

    public void setSiparis_tarihi(Timestamp siparis_tarihi) {
        this.siparis_tarihi = siparis_tarihi;
    }

    public double getToplam_fiyat() {
        return toplam_fiyat;
    }

    public void setToplam_fiyat(double toplam_fiyat) {
        this.toplam_fiyat = toplam_fiyat;
    }

    public int getMagaza_id() {
        return magaza_id;
    }

    public void setMagaza_id(int magaza_id) {
        this.magaza_id = magaza_id;
    }
    
}
