/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flostajprojesi;

/**
 *
 * @author tuba
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class KullaniciDAO {

    public void kullaniciEkle(Kullanici kullanici) {
    String sql = "INSERT INTO kullanicilar (kullanici_adi, sifre, ad_soyad, rol) VALUES (?, ?, ?, ?)";
    
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String hashedPassword = encoder.encode(kullanici.getSifre());

    try (Connection conn = DatabaseConnection.getConnection();
     PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, kullanici.getKullanici_adi());
        pstmt.setString(2, hashedPassword);
        pstmt.setString(3, kullanici.getAd_soyad());
        pstmt.setString(4, kullanici.getRol());
        
        pstmt.executeUpdate();
        System.out.println("Kullanıcı başarıyla eklendi.");
    } catch (SQLException e) {
        System.err.println("Kullanıcı eklenirken hata oluştu: " + e.getMessage());
    }
}
    public boolean kullaniciKaydet(Kullanici kullanici) {
        // Kullanıcı tablonuzun "kullanicilar" olduğunu varsayıyorum.
        String sql = "INSERT INTO kullanicilar (ad, soyad, kullanici_adi, sifre) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, kullanici.getAd());
            pstmt.setString(2, kullanici.getSoyad());
            pstmt.setString(3, kullanici.getKullaniciAdi());
            pstmt.setString(4, kullanici.getSifre()); // Şifre veritabanına düz metin olarak kaydediliyor. Güvenlik için HASH kullanmanız önerilir!

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0; // Bir satır eklendiyse başarılı
            
        } catch (SQLException e) {
            System.err.println("Kullanıcı kaydederken hata oluştu: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean kullaniciKontrol(String kullaniciAdi, String sifre) {
    String sql = "SELECT sifre FROM kullanicilar WHERE kullanici_adi = ?";
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, kullaniciAdi);
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                String storedHashedPassword = rs.getString("sifre");
                return encoder.matches(sifre, storedHashedPassword);
            }
        }
    } catch (SQLException e) {
        System.err.println("Giriş yapılırken hata oluştu: " + e.getMessage());
    }
    return false;
}

    private static class BCryptPasswordEncoder {

        public BCryptPasswordEncoder() {
        }

        private boolean matches(String sifre, String storedHashedPassword) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private String encode(String sifre) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}