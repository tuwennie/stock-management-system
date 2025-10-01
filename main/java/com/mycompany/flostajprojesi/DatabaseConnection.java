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
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Veritabanı bağlantı bilgileri
    private static final String URL = "jdbc:mysql://localhost:3306/flostajproje";
    private static final String USER = "root@localhost"; // MySQL kullanıcı adı
    private static final String PASSWORD = "sEiKa/09"; // MySQL şifresi

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanı bağlantısı başarıyla kuruldu.");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Sürücüsü bulunamadı.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantısı kurulamadı. Hata: " + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Bağlantı başarıyla kapatıldı.");
            } catch (SQLException e) {
                System.err.println("Bağlantı kapatılırken hata oluştu.");
                e.printStackTrace();
            }
        }
    }
}
