package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {

    private String orderId;
    private List<Produk> produks;
    private Date tanggalOrder;
    private static final double PPN = 0.1; //10%
    private Double diskon;
    private Double totalOrder;
    private String namaPelanggan;
    
    public Order() {
    }

    public Order(String orderId, List<Produk> produks, Date tanggalOrder) {
        this.orderId = orderId;
        this.produks = produks;
        this.tanggalOrder = tanggalOrder;
    }
    
    private Double hitungTotalorder(){
      Double total = 0.0;
        
        for(Produk p : produks){
            total += (p.getHarga() * p.getQuantity());
        }
        return total;
        
    }
    
    private void hitungTotalOrderFinal(){
        
        Double total = 0.0;
        
        for(Produk p : produks){
            total += (p.getHarga() * p.getQuantity());
            
        }
        
        total = total + (total * getPPN());
        total = total - (total * diskon);
        
        setTotalOrder(total);
    }

    
    
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the produks
     */
    public List<Produk> getProduks() {
        return produks;
    }

    /**
     * @param produks the produks to set
     */
    public void setProduks(List<Produk> produks) {
        this.produks = produks;
    }

    /**
     * @return the tanggalOrder
     */
    public Date getTanggalOrder() {
        return tanggalOrder;
    }

    /**
     * @param tanggalOrder the tanggalOrder to set
     */
    public void setTanggalOrder(Date tanggalOrder) {
        this.tanggalOrder = tanggalOrder;
    }

    public static double getPPN() {
        return PPN;
    }
    
 
    /**
     * @return the diskon
     */
    public Double getDiskon() {
        return diskon;
    }

    /**
     * @param diskon the diskon to set
     */
    public void setDiskon(Double diskon) {
        this.diskon = diskon;
    }

    /**
     * @return the totalOrder
     */
    public Double getTotalOrder() {
        return totalOrder;
    }

    /**
     * @param totalOrder the totalOrder to set
     */
    public void setTotalOrder(Double totalOrder) {
        this.totalOrder = totalOrder;
    }

    /**
     * @return the namaPelanggan
     */
    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    /**
     * @param namaPelanggan the namaPelanggan to set
     */
    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    private String formatHarga(Double harga){
        String format = String.format("%,.2f", harga);
        return format;
    }
    
    
    
    
    public void infoOrder() {
    
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
        System.out.println("Tanggal Belanja: " + sdf.format(tanggalOrder));
        System.out.println("Nama Pelanggan: " + this.getNamaPelanggan());
        System.out.println("Order ID: " + this.getOrderId());
        System.out.println("==============================================");
        
        int i = 1;
        for(Produk produk : produks){
            System.out.println(i++ + " " + produk.getNamaProduk()
                    + " " + produk.getDeskripsi()
                    + " " + "Rp " + formatHarga(produk.getHarga())
                    + " " + produk.getQuantity()
                    + " " + "Rp " + formatHarga(produk.getHarga() * produk.getQuantity()));
                  
        }
        System.out.println("=============================================");
        System.out.println("Total Harga: " + "Rp " + formatHarga(hitungTotalorder()));
        System.out.println("Diskon: " + (this.getDiskon() * 100) + "%");
        System.out.println("PPN: " + (this.PPN * 100) + "%");
        hitungTotalOrderFinal();
        System.out.println("Total Tagihan: " + "Rp " + formatHarga(this.getTotalOrder()));
        
        
        
    }

    
    
    
    
}
