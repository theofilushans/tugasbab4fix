package laporanpraktikum.Bab4;
public class Swalayan {
    private Produk []produk = new Produk[10];
    public Swalayan(){
       produk[0] = new Produk("Coki-Coki",3000);
       produk [1] = new Produk ("Ken Master",20000);
       produk[2] = new Produk("Kanebo",15000);
       produk[3] = new Produk("Gery Salut",10000);
       produk [4] = new Produk("Baygon 200ml",15000);
       produk[5] = new Produk ("Beras Ketan 2kg",500000);
       produk [6] = new Produk ("Kong Guan Kaleng",35000);
       produk[7] = new Produk ("Kisspray",10000);
       produk[8] = new Produk("Top Up 100",100000);
       produk [9] = new Produk("Top Up 300",300000);
     }
    public Produk[] getProduk() {
        return produk;
     }
    }

