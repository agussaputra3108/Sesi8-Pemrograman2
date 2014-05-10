/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package latihan.praktikum2.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Putra Tarihoran
 */
public class InsertDataGuru {
        public static void main(String[] x) throws Exception {
        //1. buat variabel bertipe FileReader
        String namafile = "src/main/resources/guru.csv";
        FileReader fr = new FileReader (namafile);
        
        //2. Bungkus dalam BufferedReader supaya ada method radLine
        BufferedReader reader = new BufferedReader (fr);
        
        //3. Looping, baca data, dan tampilkan
        String data = reader.readLine(); //header, ignore
        data = reader.readLine();
        
        // 0. Variabel untuk koneksi
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbUrl = "jdbc:mysql://localhost/nilai_dan_jadwal";
        String dbUser = "root";
        String dbPass = "";

        // 1. Aktivasi driver database
        Class.forName(dbDriver);

        // 2. Connect ke database
        Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
        
        while(data != null){
            System.out.println("========================");
            String[] guru = data.split(",");
            String sql = "INSERT INTO tbl_guru (nip,nama_guru,alamat,jabatan) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, guru[0]);
            ps.setString(2, guru[1]);
            ps.setString(3, guru[2]);
            ps.setString(4, guru[3]);
            ps.executeUpdate();
            data = reader.readLine();
        }
        //4. Tutup file
        reader.close();
        conn.close();
    }
}
