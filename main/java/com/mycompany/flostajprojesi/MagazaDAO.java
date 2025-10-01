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
import java.util.ArrayList;
import java.util.List;

public class MagazaDAO {

    public List<Magaza> tumMagazalariGetir() {
        List<Magaza> magazaListesi = new ArrayList<>();
        String sql = "SELECT * FROM magazalar";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Magaza magaza = new Magaza();
                magaza.setMagaza_id(rs.getInt("magaza_id"));
                magaza.setMagaza_adi(rs.getString("magaza_adi"));
                magaza.setAdres(rs.getString("adres"));
                magaza.setTelefon(rs.getString("telefon"));
                magazaListesi.add(magaza);
            }
        } catch (SQLException e) {
            System.err.println("Mağazalar listelenirken hata oluştu: " + e.getMessage());
        }
        return magazaListesi;
    }
}
