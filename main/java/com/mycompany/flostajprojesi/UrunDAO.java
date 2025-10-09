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

public class UrunDAO {

    public void urunEkle(Urun urun) {
        String sql = "INSERT INTO urunler (urun_adi, barkod, sku, marka, kategori, beden, renk, fiyat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, urun.getUrun_adi());
            pstmt.setString(2, urun.getBarkod());
            pstmt.setString(3, urun.getSku());
            pstmt.setString(4, urun.getMarka());
            pstmt.setString(5, urun.getKategori());
            pstmt.setString(6, urun.getBeden());
            pstmt.setString(7, urun.getRenk());
            pstmt.setDouble(8, (double) urun.getFiyat());
            pstmt.executeUpdate();
            System.out.println("Ürün başarıyla eklendi.");
        } catch (SQLException e) {
            System.err.println("Ürün eklenirken hata: " + e.getMessage());
        }
    }

    public List<Urun> urunleriListele() {
        List<Urun> urunListesi = new ArrayList<>();
        String sql = "SELECT * FROM urunler";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Urun urun = new Urun();
                urun.setUrun_id(rs.getInt("urun_id"));
                urun.setUrun_adi(rs.getString("urun_adi"));
                urun.setBarkod(rs.getString("barkod"));
                urun.setSku(rs.getString("sku"));
                urun.setMarka(rs.getString("marka"));
                urun.setKategori(rs.getString("kategori"));
                urun.setBeden(rs.getString("beden"));
                urun.setRenk(rs.getString("renk"));
                urun.setFiyat(rs.getDouble("fiyat"));
                urunListesi.add(urun);
            }
        } catch (SQLException e) {
            System.err.println("Ürünler listelenirken hata: " + e.getMessage());
        }
        return urunListesi;
    }
    public List<Urun> dusukStokluUrunleriGetir(int esikDeger) {
    List<Urun> urunler = new ArrayList<>();
    String query = "SELECT * FROM urunler WHERE stok < ?"; // Stok alanı 'esikDeger'den küçük olanları çeker
    
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement(query)) {
        
        pstmt.setInt(1, esikDeger);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Urun urun = new Urun();
            // ... (urun nesnesini dolduran diğer set metotları)
            urun.setUrunId(rs.getInt("urun_id"));
            urun.setUrunAdi(rs.getString("urun_adi"));
            urun.setFiyat(rs.getDouble("fiyat"));
            urun.setStok(rs.getInt("stok"));
            urun.setKategori(rs.getString("kategori"));
            urunler.add(urun);
        }
    } catch (SQLException e) {
    }
    return urunler;
}
    public List<Urun> urunleriAdaGoreAra(String aramaKelimesi) {
    List<Urun> arananUrunler = new ArrayList<>();
    // Veritabanı sorgusu, arama kelimesini kullanarak ürün adı filtresi yapar.
    String query = "SELECT * FROM urunler WHERE urun_adi LIKE ?";
    try (Connection con = DatabaseConnection.getConnection();
         PreparedStatement pstmt = con.prepareStatement(query)) {
        
        pstmt.setString(1, "%" + aramaKelimesi + "%");
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            Urun urun = new Urun();
            urun.setUrunId(rs.getInt("urun_id"));
            urun.setUrunAdi(rs.getString("urun_adi"));
            urun.setFiyat(rs.getDouble("fiyat"));
            urun.setStok(rs.getInt("stok"));
            urun.setKategori(rs.getString("kategori"));
            arananUrunler.add(urun);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return arananUrunler;
}

    void urunGuncelle(Urun urun) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void urunSil(int urunId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<Urun> tumUrunleriGetir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
