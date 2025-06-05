
package Connector;

import java.sql.*;

public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            // Menyambung ke database MySQL
            String url = "jdbc:mysql://localhost:3306/mall_parkir"; 
            String username = "root"; // Nama pengguna MySQL 
            String password = ""; // Password MySQL 
            
            // Mencoba koneksi
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi berhasil!");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Koneksi gagal!");
            return null;
        }
    }
    
    public static void main(String[] args) {
        // Test koneksi
        Connection conn = getConnection();
        if (conn != null) {
            // Koneksi berhasil
        }
    }
}

