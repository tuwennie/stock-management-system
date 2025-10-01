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
import java.sql.Statement;
import java.sql.ResultSet;

public class SiparisDAO {

    public int siparisEkle(Siparis siparis) {
        String sql = "INSERT INTO siparisler (toplam_fiyat, magaza_id) VALUES (?, ?)";
        int siparisId = 0;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setDouble(1, siparis.getToplam_fiyat());
            pstmt.setInt(2, siparis.getMagaza_id());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        siparisId = rs.getInt(1);
                        System.out.println("Sipariş başarıyla kaydedildi. Sipariş ID: " + siparisId);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Sipariş kaydedilirken hata oluştu: " + e.getMessage());
        }
        return siparisId;
    }
}
