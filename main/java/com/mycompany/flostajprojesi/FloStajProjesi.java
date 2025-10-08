/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.flostajprojesi;

/**
 * Projenin ana başlatma sınıfı.
 */
public class FloStajProjesi {

    public static void main(String[] args) {
        // GUI uygulamaları için standart başlatma şekli
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GirisEkrani().setVisible(true);
            }
        });
    }
}