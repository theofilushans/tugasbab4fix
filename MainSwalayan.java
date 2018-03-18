package laporanpraktikum.Bab4;

import java.util.Scanner;

public class MainSwalayan {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // instansiasi pelanggan
        Pelanggan pelanggan1 = new Pelanggan("Theo");
        Pelanggan pelanggan3 = new Pelanggan("Ami");
        Pelanggan pelanggan2 = new Pelanggan("Adam");

        //instansiasi akun
        Akun akun1 = new Akun(pelanggan1.getNama(), "7414045", 2000000, 1234, "Platinum");
        Akun akun3 = new Akun(pelanggan2.getNama(), "3814045", 1300000, 1234, "Silver");
        Akun akun2 = new Akun(pelanggan3.getNama(), "5614045", 1700000, 1234, "Gold");

        //set akun pada objek pelanggan
        pelanggan1.setAkun(akun1);
        pelanggan2.setAkun(akun2);
        pelanggan3.setAkun(akun3);

        Pelanggan[] pelanggan = new Pelanggan[3];
        for (int i = 0; i < pelanggan.length; i++) {
            pelanggan[i] = new Pelanggan();
        }

        //inisialisasi objek pelanggan
        pelanggan[0] = pelanggan1;
        pelanggan[1] = pelanggan2;
        pelanggan[2] = pelanggan3;

        // instansiasi objek transaksi
        Transaksi transaksi = new Transaksi();
        Swalayan tiny = new Swalayan();
        System.out.println("\t\tSELAMAT DATANG DI SWALAYAN TINY");
        System.out.println("Siapakah Anda ? ");
        for (int i = 0; i < pelanggan.length; i++) {
            System.out.println((i + 1) + ". " + pelanggan[i].getNama() + "\t(" + pelanggan[i].getAkun().getTipe() + ")");
        }

        System.out.print("Pilih : ");
        int pilihan = in.nextInt();
        switch (pilihan) {
            case 1:
                transaksi = new Transaksi(pelanggan1);
                break;
            case 2:
                transaksi = new Transaksi(pelanggan2);
                break;
            case 3:
                transaksi = new Transaksi(pelanggan3);
                break;
            default:
                break;
        }
        int x = 0;
        while (x == 0) {
            System.out.println("1. Beli Produk"
                    + "\n2. Top Up Saldo"
                    + "\n3. Keluar");
            System.out.print("Pilihan : ");
            int pilih = in.nextInt();
            in.nextLine();
            switch (pilih) {
                case 1:
                    String ans = "Ya";
                    while (ans.equalsIgnoreCase("Ya")) {
                        System.out.println("\n1. Coki - Coki      (3000/pcs)"
                                + "\n2. Ken Master       (20000/pcs)"
                                + "\n3. Kanebo           (15000/pcs)"
                                + "\n4. Gery Salut       (10000/pcs)"
                                + "\n5. Baygon 200ml     (15000/pcs)"
                                + "\n6. Beras Ketan 2kg  (50000/pcs)"
                                + "\n7. Kong Guan Kaleng (35000/pcs)"
                                + "\n8. Kisspray         (10000/pcs)");
                        System.out.print("Pilihan : ");
                        int pil = in.nextInt();
                        in.nextLine();
                        // pilih produk yang akan dibeli
                        switch (pil) {
                            case 1:
                                transaksi.tambahProduk(tiny.getProduk()[0]);
                                break;
                            case 2:
                                transaksi.tambahProduk(tiny.getProduk()[1]);
                                break;
                            case 3:
                                transaksi.tambahProduk(tiny.getProduk()[2]);
                                break;
                            case 4:
                                transaksi.tambahProduk(tiny.getProduk()[3]);
                                break;
                            case 5:
                                transaksi.tambahProduk(tiny.getProduk()[4]);
                                break;
                            case 6:
                                transaksi.tambahProduk(tiny.getProduk()[5]);
                                break;
                            case 7:
                                transaksi.tambahProduk(tiny.getProduk()[6]);
                                break;
                        }
                        System.out.println("Tambah produk lagi? (Ya/Tidak) ");
                        ans = in.nextLine();
                        if (ans.equalsIgnoreCase("Tidak")) {
                            break;
                        }
                    }
                    //untuk login akun
                    
                    
                    System.out.println("==Login Akun==");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Nomor pelanggan   : ");
                        String nomor = in.nextLine();
                        System.out.print("Nomor PIN         : ");
                        int pin = in.nextInt();
                        in.nextLine();
                        if (transaksi.getPelanggan().getAkun() == null) {
                            System.out.println("Akun anda telah diblokir");
                            break;
                        }
                        if (transaksi.authentikasi(nomor, pin) ) {
                        transaksi.bayarProduk(nomor, pin);
                        System.out.println("Saldo Anda Saat ini :Rp. " + transaksi.getPelanggan().getAkun().getSaldo());
                        break;
                        } else {
                            if (transaksi.getCount() == 3) {
                                System.out.println("Akun anda diblokir");
                            }
                        }
                 
                    }
                    break;
                case 2:
                    System.out.println("Pilih Top Up :"
                            + "\n1. Top Up Rp.300.000"
                            + "\n2. Top Up Rp. 100.000");
                    System.out.print("Pilih :");
                    pilih = in.nextInt();
                    in.nextLine();
                    //pilih top up
                    switch (pilih) {
                        case 1:
                            transaksi.tambahSaldo(transaksi.getPelanggan().getAkun(), tiny.getProduk()[9]);
                            System.out.println("Saldo anda        : Rp. " + transaksi.getPelanggan().getAkun().getSaldo());
                            break;
                        case 2:
                            transaksi.tambahSaldo(transaksi.getPelanggan().getAkun(), tiny.getProduk()[8]);
                            System.out.println("Saldo anda        : Rp. " + transaksi.getPelanggan().getAkun().getSaldo());
                            break;
                        default:
                            System.out.println("Input Salah");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("\t===Terima Kasih===");
                    x = 1;
                    break;
            }

        }
    }
}
