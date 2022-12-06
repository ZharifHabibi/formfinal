package CleaningServices;

import java.text.NumberFormat;
import java.util.Locale;

public class ServicePrice {
    private String namaPelanggan;
    private String jenisBarang;
    private String opsiLayanan;
    private String alamat;
    private int nomorHP;
    private int hargaJenisBarang;
    private int hargaOpsiLayanan;
    private int totalHarga;

    private NumberFormat nf;

    public ServicePrice() { nf = NumberFormat.getInstance(Locale.US);}

    public int getHargaJenisBarang(int i) { return hargaJenisBarang; }

    public String getHargaJenisBarangString() { return nf.format(hargaJenisBarang); }

    public String getNamaPelanggan() {
        return namaPelanggan;
    }

    public void setNamaPelanggan(String namaPelanggan) {
        this.namaPelanggan = namaPelanggan;
    }

    public String getJenisBarang() {
        return jenisBarang;
    }

    public void setJenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
        switch (jenisBarang){
            case "Mesin cuci":
                setHargaJenisBarang(100000);
                break;
            case "Kulkas":
                setHargaJenisBarang(80000);
                break;
            case "AC":
                setHargaJenisBarang(50000);
                break;
        }
    }

    public String getOpsiLayanan() {
        return opsiLayanan;
    }

    public void setOpsiLayanan(String opsiLayanan) {
        this.opsiLayanan = opsiLayanan;
        switch (opsiLayanan){
            case "Cleaning and Service":
                setHargaOpsiLayanan(400000);
                break;
            case "Cleaning only":
                setHargaOpsiLayanan(100000);
                break;
            case "Service only":
                setHargaOpsiLayanan(350000);

        }
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getNomorHP() {
        return nomorHP;
    }

    public void setNomorHP(int nomorHP) {
        this.nomorHP = nomorHP;
    }

    public int getHargaJenisBarang() {
        return hargaJenisBarang;
    }

    public void setHargaJenisBarang(int hargaJenisBarang) {
        this.hargaJenisBarang = hargaJenisBarang;
        setHarga(this.hargaJenisBarang);
    }

    public int getHargaOpsiLayanan(int i) {
        return hargaOpsiLayanan;
    }

    public String getHargaOpsiLayanan(){
        return nf.format(hargaOpsiLayanan);
    }

    public void setHargaOpsiLayanan(int hargaOpsiLayanan) {
        this.hargaOpsiLayanan = hargaOpsiLayanan;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setHarga(int harga) {
        this.totalHarga += harga;
    }

    public NumberFormat getNf() {
        return nf;
    }

    public void setNf(NumberFormat nf) {
        this.nf = nf;
    }
    public String calculateTotalAkhir() {
        int totalHargaFinal = this.totalHarga+getHargaJenisBarang(0)+getHargaOpsiLayanan(0);
        restartTotalHarga();
        return "Rp"+nf.format(totalHargaFinal);
    }
    public void restartTotalHarga(){
        this.totalHarga = 0;
        setHargaJenisBarang(0);
        setHargaOpsiLayanan(0);
    }
}
