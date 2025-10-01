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

public class RaporService {

    private StokDAO stokDAO = new StokDAO();
    private UrunDAO urunDAO = new UrunDAO();
    

    public int getToplamStok(int urunId) {
        return stokDAO.getToplamStok(urunId);
    }

    public List<Urun> getEnCokSatanUrunler() {
        // Normalde burada JOIN ve GROUP BY içeren bir SQL sorgusu çalıştırılır.
        // Şimdilik UrunDAO'dan tüm ürünleri listeleyelim.
        return urunDAO.urunleriListele();
    }
}
