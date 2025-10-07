/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flostajprojesi;

import com.mycompany.flostajprojesi.dao.UrunDAO;
import com.mycompany.flostajprojesi.model.Urun;
import java.util.List;
/**
 *
 * @author tuba
 */
public class UrunService {
    package com.mycompany.flostajprojesi.service;

    private UrunDAO urunDAO;
    
    public List<Urun> urunleriAdaGoreAra(String aramaKelimesi) {
    return urunDAO.urunleriAdaGoreAra(aramaKelimesi);
    }
    
    public List<Urun> dusukStokluUrunleriGetir() {
    return urunDAO.dusukStokluUrunleriGetir(10); 
    }
    
    public UrunService() {
        this.urunDAO = new UrunDAO();
    }

    public void urunEkle(Urun urun) {
        urunDAO.urunEkle(urun);
    }

    public void urunGuncelle(Urun urun) {
        urunDAO.urunGuncelle(urun);
    }

    public void urunSil(int urunId) {
        urunDAO.urunSil(urunId);
    }

    public List<Urun> tumUrunleriGetir() {
        return urunDAO.tumUrunleriGetir();
    }
}

