package mainapp;

import java.util.List;
import lib.LibraryProduk;
import model.Produk;

public class TesLibrary {

    public static void main(String[] args) {
        
        List<Produk> prodss = LibraryProduk.daftarProdukFromFile();
        
        prodss.add(new Produk("Coca Cola", "Minuman", 3000.0, 50));
        prodss.add(new Produk("Chiki Chuba", "Makanan", 1000.0, 150));
        
        LibraryProduk.insertNewProduk(prodss);
        
        prodss = LibraryProduk.daftarProdukFromFile();
        
        for (Produk prod : prodss){
            System.out.println("========LAMA========");
            System.out.println("Nama: " + prod.getNamaProduk());
            System.out.println("Desc: " + prod.getDeskripsi());
            System.out.println("Harga: " + prod.getHarga());
            System.out.println("Quantity: " + prod.getQuantity());
            
        }
        
        for(Produk prod : prodss){
            if(prod.getNamaProduk().equalsIgnoreCase("Rendang")){
                prod.setQuantity(100);
                break;
            }
        }
        LibraryProduk.insertNewProduk(prodss);
        
        prodss = LibraryProduk.daftarProdukFromFile();
        for (Produk prod : prodss){
            System.out.println("========BARU========");
            System.out.println("Nama: " + prod.getNamaProduk());
            System.out.println("Desc: " + prod.getDeskripsi());
            System.out.println("Harga: " + prod.getHarga());
            System.out.println("Quantity: " + prod.getQuantity());
        }

    }
    
}
