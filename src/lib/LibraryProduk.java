package lib;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Produk;

public class LibraryProduk {
    
    public static List<Produk> daftarProdukFromFile(){
        List<Produk> daftarProduk = new ArrayList<>();
        try{
            File file = new File("C:\\Users\\Aspire E5-473G\\Downloads\\Documents\\produk.txt");
            Scanner scan = new Scanner(file);
            String line = "";
            while (scan.hasNextLine()){
                line = scan.nextLine();
                String[] word = line.split(",");
                Produk p = 
                        new Produk(
                                word[0].trim(),
                                word[1].trim(),
                                Double.valueOf(word[2].trim()),
                                Integer.valueOf(word[3].trim()));
                daftarProduk.add(p);
            }
            scan.close();
            System.out.println("abcd");
        } catch (FileNotFoundException fe){
            System.out.println("File Not Found");
            fe.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return daftarProduk;
    }
    
    public static List<Produk> daftarProdukFromOtherPackage(){
        List<Produk> daftarProduk = new ArrayList<>();
        try{
            Scanner scan = new Scanner
                    (LibraryProduk.class.getResourceAsStream("/file/produk.txt"));
            String line = "";
            while (scan.hasNextLine()){
                line = scan.nextLine();
                String[] word = line.split(",");
                Produk p = 
                        new Produk(
                                word[0].trim(),
                                word[1].trim(),
                                Double.valueOf(word[2].trim()),
                                Integer.valueOf(word[3].trim()));
                daftarProduk.add(p);
            }
            scan.close();
        
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            LibraryProduk.daftarProdukFromOtherPackage();
        }
        return daftarProduk;
    }
    
    public static void insertNewProduk(List<Produk> listProduk){
        try{
            File fout = new File("C:\\Users\\Aspire E5-473G\\Downloads\\Documents\\produk.txt");
//            FileOutputStream fos = new FileOutputStream(fout, true); //utk menambahkan line baru
            FileOutputStream fos = new FileOutputStream(fout); //utk menambahkan line baru sekalian overwrite
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            
            for (Produk p : listProduk){
                bw.write(p.getNamaProduk());
                bw.append(",");
                bw.append(p.getDeskripsi());
                bw.append(",");
                bw.append(String.valueOf(p.getHarga()));
                bw.append(",");
                bw.append(String.valueOf(p.getQuantity()));
                bw.newLine();
            }
            
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }    
}
