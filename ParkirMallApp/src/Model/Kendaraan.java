/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Kendaraan {
    private String namaPemilik;
    private String platNomor;
    private String merkKendaraan;
    private int durasiParkir; // dalam jam
    private int biayaParkir;

    public Kendaraan(String namaPemilik, String platNomor, String merkKendaraan, int durasiParkir) {
        this.namaPemilik = namaPemilik;
        this.platNomor = platNomor;
        this.merkKendaraan = merkKendaraan;
        this.durasiParkir = durasiParkir;
        hitungBiayaParkir();
    }

    private void hitungBiayaParkir() {
        if (durasiParkir <= 4) {
            biayaParkir = durasiParkir * 5000; // Rp 5.000 per jam
        } else {
            biayaParkir = (4 * 5000) + ((durasiParkir - 4) * 7000); // Rp 7.000 per jam setelah 4 jam
        }
    }

    // Getter dan Setter
    public String getNamaPemilik() {
        return namaPemilik;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public String getMerkKendaraan() {
        return merkKendaraan;
    }

    public int getDurasiParkir() {
        return durasiParkir;
    }

    public int getBiayaParkir() {
        return biayaParkir;
    }
}

