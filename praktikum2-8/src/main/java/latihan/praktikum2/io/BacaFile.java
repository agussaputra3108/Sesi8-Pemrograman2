package latihan.praktikum2.io;

import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Putra Tarihoran
 */
public class BacaFile {
    public static void main(String[] x) throws Exception {
        //1. buat variabel bertipe FileReader
        String namafile = "src/main/resources/mahasiswa.csv";
        FileReader fr = new FileReader (namafile);
        
        //2. Bungkus dalam BufferedReader supaya ada method radLine
        BufferedReader reader = new BufferedReader (fr);
        
        //3. Looping, baca data, dan tampilkan
        String data = reader.readLine(); //header, ignore
        data = reader.readLine();
        while(data != null){
            System.out.println("========================");
            String[] mahasiswa = data.split(",");
            System.out.println("NPM : "+mahasiswa[0]);
            System.out.println("Nama : "+mahasiswa[1]);
            System.out.println("Email : "+mahasiswa[2]);
            data = reader.readLine();
        }
        //4. Tutup file
        reader.close();
    }
}
