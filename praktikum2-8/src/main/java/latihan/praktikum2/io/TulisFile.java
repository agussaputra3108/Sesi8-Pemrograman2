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
public class TulisFile {
    public static void main (String[] x) throws Exception {
        //1. Writer ke file tujuan
        String namaFile = "target/output.txt";
        FileWriter output = new FileWriter(namaFile);
        
        //2. Tangkap input dari command line menggunakan BufferedReader
        BufferedReader reader = new BufferedReader (new InputStreamReader (System.in));
        
        //3. Beri aba-aba untuk user
        System.out.println("Silahkan mengetik. Ketik exit untuk selesai");
        String data;
        while((data = reader.readLine()) != null){
            //kalau kita ketik exit. selesai loop
            if("exit".equalsIgnoreCase(data)){
                break;
            }
            output.write(data);
            output.write("\r\n");
            output.flush();
        }
        reader.close();
    }
}
