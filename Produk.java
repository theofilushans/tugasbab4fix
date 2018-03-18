package laporanpraktikum.Bab4;

public class Produk {
   private String namabarang;
   private int harga;
   public Produk() {
       
   }
    public Produk(String namabarang,int harga){
        this.namabarang= namabarang;
        this.harga = harga;
    }
    public String getNamabarang() {
        return namabarang;
    }
    public int getHarga() {
        return harga;
    } 
}
