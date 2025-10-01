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
import java.sql.SQLException;

public class IslemDAO {

    /**
     * Yeni bir işlem kaydı ekler.
     * Bu işlem, MySQL trigger'ları sayesinde stoğu otomatik olarak günceller.
     *
     * @param islem Eklenecek Islem nesnesi.
     */
    public void islemEkle(Islem islem) {
        String sql = "INSERT INTO islemler (urun_id, magaza_id, islem_tipi, adet, kullanici_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, islem.getUrun_id());
            pstmt.setInt(2, islem.getMagaza_id());
            pstmt.setString(3, islem.getIslem_tipi());
            pstmt.setInt(4, islem.getAdet());
            pstmt.setInt(5, islem.getKullanici_id());

            pstmt.executeUpdate();
            System.out.println("İşlem başarıyla kaydedildi.");
        } catch (SQLException e) {
            System.err.println("İşlem kaydedilirken hata oluştu: " + e.getMessage());
        }
    }
}