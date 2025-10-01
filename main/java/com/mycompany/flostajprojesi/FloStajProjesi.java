/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.flostajprojesi;

/**
 *
 * @author tuba
 */
public class FloStajProjesi {
public static void main(String[] args) {
        // Servis katmanından nesneler oluştur
        KullaniciService kullaniciService = new KullaniciService();
        UrunService urunService = new UrunService();
        StokService stokService = new StokService();
        IslemService islemService = new IslemService();
        RaporService raporService = new RaporService();

        System.out.println("Uygulama başlatıldı. Test senaryoları çalışıyor...");
        
        Kullanici yeniKullanici = new Kullanici();
        yeniKullanici.setKullanici_adi("deneme_user");
        yeniKullanici.setSifre("password123");
        yeniKullanici.setAd_soyad("Deneme Kullanıcı");
        yeniKullanici.setRol("admin");
kullaniciService.kullaniciKaydet(yeniKullanici);

boolean girisBasarili = kullaniciService.kullaniciGirisYap("deneme_user", "password123");
if (girisBasarili) {
    System.out.println("Giriş başarılı: Hoş geldiniz, deneme_user!");
} else {
    System.out.println("Giriş başarısız: Kullanıcı adı veya şifre yanlış.");
}
    }

    }

