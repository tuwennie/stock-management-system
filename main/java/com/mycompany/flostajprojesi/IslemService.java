/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flostajprojesi;

/**
 *
 * @author tuba
 */
import java.util.List;

public class IslemService {
    
    private IslemDAO islemDAO = new IslemDAO();
    
    private StokDAO stokDAO = new StokDAO();
    

    public boolean satisYap(int urunId, int magazaId, int adet, int kullaniciId) {
        int mevcutStok = stokDAO.getStokAdet(urunId, magazaId);
        if (mevcutStok < adet) {
            System.out.println("Hata: Yetersiz stok! Mevcut stok: " + mevcutStok);
            return false;
        }

        Islem islem = new Islem();
        islem.setUrun_id(urunId);
        islem.setMagaza_id(magazaId);
        islem.setIslem_tipi("stok_azalt");
        islem.setAdet(adet);
        islem.setKullanici_id(kullaniciId);

        islemDAO.islemEkle(islem);
        
        return true;
    }
}
