package menu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.Order;
import model.Produk;

public class Menu {

    private Order order = new Order();
    private List<Produk> listProduk = new ArrayList<>();
    private Date tanggal = new Date();

    public void menuUtama(Integer menu) {

        Scanner scan = new Scanner(System.in);
     

        try {

            if (menu == 0) {

                Integer pilihanMenu = 0;
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");

                System.out.println("Tanggal: " + sdf.format(tanggal));
                System.out.println("-----Selamat Datang di Supermarket Kami...----");
                System.out.println("Apa yang ingin anda lakukan? ");
                System.out.println("1. Belanja");
                System.out.println("2. Keluar");
                System.out.println("Pilih menu: ");

                pilihanMenu = Integer.parseInt(scan.next());

                switch (pilihanMenu) {
                    case 1:
                        menuBelanja();
                        break;
                    case 2:
                        System.out.println("Terima Kasih, sampai jumpa kembali...");
                        System.exit(0);
                        break;
                    default:
                        menuUtama(0);

                }

            } else {
                switch (menu) {
                    case 1:
                        menuBelanja();
                        break;
                    case 2:
                        System.out.println("Terima Kasih, sampai jumpa kembali...");
                        System.exit(0);
                        break;
                    default:
                        menuUtama(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            menuUtama(menu);
        }
    }

    private void menuBelanja() {

        Scanner scan = new Scanner(System.in);
        String namaPelanggan = "";
        String orderId= String.valueOf(Math.ceil(Math.random() * 1 * 10000000));
        Double diskon = 0.0;
        
        
        try {
            System.out.println("Nama Pelanggan: ");
            namaPelanggan = scan.next();
            System.out.println("==================================");
            System.out.println("Masukkan jumlah barang belanjaan: ");
            int jumlahBarangBelanjaan = Integer.parseInt(scan.next());
            
            for(int i=1; i<= jumlahBarangBelanjaan; i++){
                System.out.println("======================");
                System.out.println("Barang ke-"+i);
                System.out.println("Nama Barang; ");
                String namaBarang = scan.next();
                
                System.out.println("Deskripsi Barang: ");
                String deskripsiBarang = scan.next();
                
                System.out.println("Harga Satuan: ");
                Double hargaSatuan = Double.parseDouble(scan.next());
                
                System.out.println("Quantity: ");
                Integer quantity = Integer.parseInt(scan.next());
                
                Produk produk = new Produk(namaBarang, deskripsiBarang, hargaSatuan, quantity);
                
                listProduk.add(produk);
                
            }
            System.out.println("Apakah ada diskon? (Y/N) ");
            
            if(scan.next().equalsIgnoreCase("Y")){
                System.out.println("Masukkan diskon: (percentage) ");
                diskon = Double.parseDouble(scan.next());
                //diskon = diskon / 100;
                
            }
            
            order.setDiskon(diskon);
            order.setOrderId(orderId);
            order.setProduks(listProduk);
            order.setTanggalOrder(tanggal);
            order.setNamaPelanggan(namaPelanggan);
            
            order.infoOrder();
            
            System.out.println("Pilih Menu: ");
            System.out.println("1. Keluar   2. Kembali");
            Integer menu = Integer.parseInt(scan.next());
            menu = menu == 1 ? 2 : 0;
            menuUtama(menu);
            
            
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            menuBelanja();
        }

    }
}
