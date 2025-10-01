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

public class StokDAO {

    /**
     * Belirli bir ürünün belirli bir mağazadaki stok miktarını döndürür.
     *
     * @param urunId Ürünün ID'si
     * @param magazaId Mağazanın ID'si
     * @return Stok adedi veya hata durumunda 0
     */
    public int getStokAdet(int urunId, int magazaId) {
        String sql = "SELECT adet FROM stoklar WHERE urun_id = ? AND magaza_id = ?";
        int adet = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, urunId);
            pstmt.setInt(2, magazaId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    adet = rs.getInt("adet");
                }
            }
        } catch (SQLException e) {
            System.err.println("Stok sorgulanırken hata oluştu: " + e.getMessage());
        }
        return adet;
    }

    public int getToplamStok(int urunId) {
        String sql = "SELECT SUM(adet) AS toplam_adet FROM stoklar WHERE urun_id = ?";
        int toplamAdet = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, urunId);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    toplamAdet = rs.getInt("toplam_adet");
                }
            }
        } catch (SQLException e) {
            System.err.println("Toplam stok sorgulanırken hata oluştu: " + e.getMessage());
        }
        return toplamAdet;
    }
}
