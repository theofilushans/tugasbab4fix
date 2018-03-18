package laporanpraktikum.Bab4;
public class Transaksi {
    private Pelanggan pelanggan;
    private static int productCounter = 0;
    private Produk []produk = new Produk[10];
    static int count = 0;    
    Transaksi() {    
    }
    public Transaksi(Pelanggan pelanggan){
        this.pelanggan = pelanggan;
        for (int i = 0; i < produk.length; i++) {
            produk[i] = new Produk();
        }
    }
    public void tambahProduk(Produk product){
        this.produk[productCounter] = product;
        productCounter++;
    }
    public Pelanggan getPelanggan() {
        return pelanggan;
    }
    public Produk[] getProduk() {
        return produk;
    }
    public void bayarProduk(String nomor, int pin){
        long totalharga = 0;
        int ctr = 0;
        for (int i = 0; i < produk.length; i++) {
            totalharga += produk[i].getHarga();
        }
        if (authentikasi(nomor,pin) == true) {
            if (pelanggan.getAkun().getSaldo()-totalharga > 10000) {
            pelanggan.getAkun().setSaldo(pelanggan.getAkun().getSaldo()-totalharga);
            if (pelanggan.getAkun().getTipe().equalsIgnoreCase("Gold")){
            cashBack(pelanggan.getAkun().getTipe(),totalharga);
            }
        else if (pelanggan.getAkun().getTipe().equalsIgnoreCase("Platinum")) {
            cashBack(pelanggan.getAkun().getTipe(),totalharga);
        } else if (pelanggan.getAkun().getTipe().equalsIgnoreCase("Silver")) {
            cashBack(pelanggan.getAkun().getTipe(),totalharga);
    }System.out.println("Saldo Anda Saat ini :Rp. " + this.getPelanggan().getAkun().getSaldo());
            } else {
                    System.out.println("Saldo pasca transaksi kurang dari Rp10.000");
                    kosongkanKeranjang();
            }
        }else if (authentikasi(nomor,pin) == false) {
            if (ctr == 3) {
                System.out.println("Dibekukan");
            }
            ctr++;
        }
            
    }
    public boolean authentikasi(String nomor, int pin){
        if (nomor.equals(pelanggan.getAkun().getNomorpelanggan()) && pin == pelanggan.getAkun().getPin()) {
            return true;
        } else {
           count++;
            if (count == 3)
                pelanggan.setAkun(null);
            }
            return false;        
    }
    public static int getCount() {
        return count;
    }
    
    public void tambahSaldo(Akun akun,Produk produk){
        akun.setSaldo(akun.getSaldo()+produk.getHarga());
    }
    // method cashback
     public void cashBack(String jenisakun,long totalharga){
        if (jenisakun.equals("Gold") && totalharga>1000000) {
              pelanggan.getAkun().setSaldo(pelanggan.getAkun().getSaldo()+(totalharga*2)/100);
              System.out.println("Anda mendapatkan cashback tunai sebesar Rp. "+(totalharga*7)/100+" dan cashback saldo sebesar "+(totalharga*2)/100);
         }else if (jenisakun.equals("Platinum") && totalharga > 1000000) {
             pelanggan.getAkun().setSaldo(pelanggan.getAkun().getSaldo()+(totalharga*5)/100);
             System.out.println("Anda mendapatkan cashback tunai sebesar Rp. "+(totalharga*10)/100+" dan cashback saldo sebesar "+(totalharga*5)/100);
         }else if (jenisakun.equalsIgnoreCase("Silver")&& totalharga>1000000){
             System.out.println("Anda mendapatkan cashback tunai sebesar Rp. "+(totalharga*5)/100);
         }
    }
     private void kosongkanKeranjang(){
         for (int i = 0; i < produk.length; i++) {
             produk[i] = new Produk();
         }
     }
}
   
