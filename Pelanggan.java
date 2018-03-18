package laporanpraktikum.Bab4;
public class Pelanggan {
    private final String nama;
    private Akun akun;
    Pelanggan() {
        this.nama = "";
    }
    public Pelanggan (String nama){   
         this.nama = nama;
    }
    public void setAkun(Akun akun) {
        this.akun = akun;
    }
    public Akun getAkun() {
        return akun;
    }
    public String getNama() {
        return nama;
    } 
}
