package laporanpraktikum.Bab4;
public class Akun {
    private final String nama;
    private String nomorpelanggan;
    private int pin;
    private long saldo;
    public String tipe;
   
    public Akun (String nama,String nomorpelanggan,long saldo,int pin,String tipe){
        this.nama = nama;
        this.nomorpelanggan = nomorpelanggan;
        this.saldo = saldo;
        this.pin = pin;
        this.tipe = tipe;
    }
   
    public String getNama() {
        return nama;
    }
    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
    public String getTipe() {
        return tipe;
    }
    public int getPin() {
        return pin;
    }
    public String getNomorpelanggan() {
        return nomorpelanggan;
    }
    public long getSaldo() {
        return saldo;
    }
     public boolean Authentifikasi(String nomorpelanggan,int pin){
        if (nomorpelanggan.equals(this.getNomorpelanggan()) && pin == this.getPin()) {
            return true;
        } else {
            return false;
        }
    }
}
