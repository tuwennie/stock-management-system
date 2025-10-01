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

public class TedarikciDAO {

    public List<Tedarikci> tumTedarikcileriGetir() {
        List<Tedarikci> tedarikciListesi = new ArrayList<>();
        String sql = "SELECT * FROM tedarikciler";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Tedarikci tedarikci = new Tedarikci();
                tedarikci.setTedarikci_id(rs.getInt("tedarikci_id"));
                tedarikci.setTedarikci_adi(rs.getString("tedarikci_adi"));
                tedarikci.setAdres(rs.getString("adres"));
                tedarikci.setTelefon(rs.getString("telefon"));
                tedarikciListesi.add(tedarikci);
            }
        } catch (SQLException e) {
            System.err.println("Tedarikçiler listelenirken hata oluştu: " + e.getMessage());
        }
        return tedarikciListesi;
    }
}

