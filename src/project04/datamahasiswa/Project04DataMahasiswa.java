/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project04.datamahasiswa;

import java.text.ParseException;

/**
 *
 * @author LestariR
 */
public class Project04DataMahasiswa {

    /**
     * @param args the command line arguments
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        DataMahasiswa dm = new DataMahasiswa();
        
        OUTER:
        while (true) {
            int pilih = dm.menuUtama();
            switch (pilih) {
                case 1:
                    dm.tambahData();
                    break;
                case 2 :
                    dm.hapusData();
                    break;
                case 3 :
                    dm.cariData();
                    break;
                case 4:
                    dm.tampilData();
                    break;
                case 5:
                    System.out.println("---Terima kasih---");
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
}
