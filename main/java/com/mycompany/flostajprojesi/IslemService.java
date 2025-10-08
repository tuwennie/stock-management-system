/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flostajprojesi;

/**
 *
 * @author tuba
 */
import com.mycompany.flostajprojesi.IslemDAO;
import com.mycompany.flostajprojesi.StokDAO;
import com.mycompany.flostajprojesi.Islem;
import com.mycompany.flostajprojesi.Stok;
import javax.swing.JOptionPane;
import java.util.List;

public class IslemService {
    
    private IslemDAO islemDAO = new IslemDAO();
    private StokDAO stokDAO = new StokDAO();

    public boolean satisYap(int urunId, int magazaId, int adet, int kullaniciId) {
        
        // 1. Stok Kontrolü
        int mevcutStok = stokDAO.getStokAdet(urunId, magazaId);
        
        if (mevcutStok < adet) {
            JOptionPane.showMessageDialog(null, "Yetersiz stok! Mevcut stok: " + mevcutStok, "Stok Hatası", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // 2. İşlem Nesnesini Oluşturma
        Islem islem = new Islem();
        
        islem.setUrunId(urunId); 
        islem.setMagazaId(magazaId);
        islem.setIslemTipi("stok_azalt"); 
        islem.setAdet(adet);
        islem.setKullanicilarId(kullaniciId);

        try {
            islemDAO.islemEkle(islem);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Satış işlemi kaydedilirken hata oluştu: " + e.getMessage(), "Veritabanı Hatası", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
