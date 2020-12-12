/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project04.datamahasiswa;

import java.util.Scanner;
import java.util.ArrayList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author LestariR
 */
public class DataMahasiswa {
    int pilih;
    int index;
    
    ArrayList<String> nim = new ArrayList<>();
    ArrayList<String> nama = new ArrayList<>();
    ArrayList<Date> tglLahir = new ArrayList<>();
    ArrayList<Integer> gender = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);
    
    void print(){
        System.out.println("NIM             : " + this.nim.get(index));
        System.out.println("Nama            : " + this.nama.get(index));
        System.out.println("Tanggal Lahir   : " + this.tglLahir.get(index));
        System.out.println("Gender          : " + this.gender.get(index));
    }
    
    int menuUtama(){
        System.out.println("--------------------------------");
        System.out.println("          DATA MAHASISWA"        );
        System.out.println("--------------------------------");
        System.out.println("Menu :");
        System.out.println("1. Tambah Data");
        System.out.println("2. Hapus Data");
        System.out.println("3. Cari Data");
        System.out.println("4. Tampil Data");
        System.out.println("5. Keluar");
        System.out.print("\nPilih menu : ");
        this.pilih = input.nextInt();
        return this.pilih;
    }
    
    void tambahData() throws ParseException{
        char tambahLagi;
        System.out.println("--------------------------------");
        System.out.println("            Tambah Data");
        System.out.println("--------------------------------");
        do {
            input.nextLine();
            System.out.print("Masukkan NIM : ");
            this.nim.add(input.nextLine());
            System.out.print("Masukkan Nama : ");
            this.nama.add(input.nextLine());
            System.out.print("Masukkan Tanggal Lahir (dd-mm-yyyy) : ");
            String tgl = input.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            this.tglLahir.add(dateFormat.parse(tgl));
            System.out.print("Masukkan gender 0/1 (0 : laki-laki, 1 : perempuan) : ");
            this.gender.add(input.nextInt());
            input.nextLine();
            System.out.print("\nTambah data lagi (y/n) ? ");
            tambahLagi = input.nextLine().charAt(0);
        }while (tambahLagi == 'y');
    }
    
    void hapusData(){
        String nimHapus;
        Boolean cekNim;
        char konfirm;
        char hapusLagi = 0;
        System.out.println("--------------------------------");
        System.out.println("            Hapus Data");
        System.out.println("--------------------------------");
        input.nextLine();
        do {
            System.out.print("Masukkan nim Mahasiswa yang ingin dihapus datanya : ");
            nimHapus = input.nextLine();
            cekNim = this.nim.contains(nimHapus);
            if (cekNim == true) {
                this.index = this.nim.indexOf(nimHapus);
                print();
                System.out.print("Apakah benar ingin menghapus data di atas (y/n)? ");
                konfirm = input.nextLine().charAt(0);
                if (konfirm == 'y') {
                    this.nim.remove(index);
                    this.nama.remove(index);
                    this.tglLahir.remove(index);
                    this.gender.remove(index);
                    System.out.println("\n---Berhasil menghapus data---\n");
                }else {
                    continue;
                }
            } else {
                System.out.println("---Data tidak ditemukan---\n");
            }
            System.out.print("Hapus lagi (y/n)? ");
            hapusLagi = input.nextLine().charAt(0);
        }while (hapusLagi == 'y'); 
    }

    void cariData() {
        int cari;
        int cariGender;
        String cariNim;
        boolean ditemukan;
        System.out.println("--------------------------------");
        System.out.println("            Cari Data");
        System.out.println("--------------------------------");
        System.out.println("Kriteria pencarian :");
        System.out.println("1. Berdasarkan gender");
        System.out.println("2. Berdasarkan nim\n");
        System.out.print("Pilih kriteria pencarian (1/2) : ");
        cari = input.nextInt();
        if (cari == 1){
            System.out.print("\nMasukkan jenis gender (0/1) : ");
            cariGender = input.nextInt();
            ditemukan = this.gender.contains(cariGender);
            if (ditemukan == true) {
                System.out.println("\n---Data ditemukan---");
                for(int i=0; i < this.gender.size(); i++) {
                    this.index = i;
                    if (this.gender.get(i) == cariGender){
                        System.out.println();
                        print();
                    }
                }
            }else {
                System.out.println("\n---Data tidak ditemukan---");
            }
        }else if (cari == 2) {
            input.nextLine();
            System.out.print("Masukkan nim mahasiswa yang ingin dicari datanya : ");
            cariNim = input.nextLine();
            ditemukan = this.nim.contains(cariNim);
            if (ditemukan == true) {
                System.out.println("\n---Data ditemukan---");
                this.index = this.nim.indexOf(cariNim);
                print();
            }else {
                System.out.println("\n---Data tidak ditemukan---");
            }  
        }
    }
    
    void tampilData(){
        System.out.println("--------------------------------");
        System.out.println("            Tampil Data");
        System.out.println("--------------------------------");
        for (int i=0; i < this.nim.size(); i++){
            this.index = i;
            print();
            System.out.println();
        }
        System.out.println("Jumlah Data Mahasiswa : " + this.nim.size());   
    }
}