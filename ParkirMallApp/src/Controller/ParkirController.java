/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Kendaraan;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParkirController {

    private Connection connection;

    public ParkirController() {
        try {
            // Koneksi ke database MySQL
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkir_mall", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        try {
            String query = "INSERT INTO kendaraan (nama_pemilik, plat_nomor, merk_kendaraan, durasi_parkir, biaya_parkir) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, kendaraan.getNamaPemilik());
            stmt.setString(2, kendaraan.getPlatNomor());
            stmt.setString(3, kendaraan.getMerkKendaraan());
            stmt.setInt(4, kendaraan.getDurasiParkir());
            stmt.setInt(5, kendaraan.getBiayaParkir());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Kendaraan> tampilkanKendaraan() {
        List<Kendaraan> kendaraanList = new ArrayList<>();
        try {
            String query = "SELECT * FROM kendaraan";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String namaPemilik = rs.getString("nama_pemilik");
                String platNomor = rs.getString("plat_nomor");
                String merkKendaraan = rs.getString("merk_kendaraan");
                int durasiParkir = rs.getInt("durasi_parkir");
                int biayaParkir = rs.getInt("biaya_parkir");
                Kendaraan kendaraan = new Kendaraan(namaPemilik, platNomor, merkKendaraan, durasiParkir);
                kendaraanList.add(kendaraan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kendaraanList;
    }
    
    // Mengedit data kendaraan yang sudah ada
    public void editKendaraan(Kendaraan kendaraan) {
        try {
            String query = "UPDATE kendaraan SET nama_pemilik=?, merk_kendaraan=?, durasi_parkir=?, biaya_parkir=? WHERE plat_nomor=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, kendaraan.getNamaPemilik());
            stmt.setString(2, kendaraan.getMerkKendaraan());
            stmt.setInt(3, kendaraan.getDurasiParkir());
            stmt.setInt(4, kendaraan.getBiayaParkir());
            stmt.setString(5, kendaraan.getPlatNomor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    // Metode untuk menghapus kendaraan berdasarkan plat nomor
    public void hapusKendaraan(String platNomor) {
        try {
            String query = "DELETE FROM kendaraan WHERE plat_nomor=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, platNomor);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

