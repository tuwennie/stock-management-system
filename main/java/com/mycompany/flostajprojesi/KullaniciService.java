/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flostajprojesi;

/**
 *
 * @author tuba
 */
public class KullaniciService {

    private KullaniciDAO kullaniciDAO = new KullaniciDAO();


    public boolean kullaniciKaydet(Kullanici kullanici) {
        return kullaniciDAO.kullaniciKaydet(kullanici);
    }


    public boolean kullaniciGirisYap(String kullaniciAdi, String sifre) {
        return kullaniciDAO.kullaniciKontrol(kullaniciAdi, sifre);
    }
}
