package CleaningServices;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class CleanAndServ {
    private JComboBox comboBarang;
    private JComboBox comboLayanan;
    private JTextField textNama;
    private JTextField textAlamat;
    private JButton buatPesananButton;
    private JTable tableCAS;
    private JPanel rootPanel;
    private JTextField textNomor;
    private DefaultTableModel tableModel;
    private String calculateTotalAkhir;
    private ServicePrice ServicePrice;



    public CleanAndServ(){
        this.ServicePrice = new ServicePrice();
        this.initCompenent();
        calculateTotalAkhir = this.ServicePrice.calculateTotalAkhir();


        buatPesananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = textNama.getText();
                String barang = (String) comboBarang.getSelectedItem();
                String layanan = (String) comboLayanan.getSelectedItem();
                String alamat = textAlamat.getText();
                String nomor = textNomor.getText();
                String result = "Data tersimpan!\nNama Pelanggan : "+nama+" \nJenis Barang : "+barang+" \nOpsi Layanan : "+layanan+"\nAlamat : "+alamat+"\nNomor HP :"+nomor+"\n\n";
                try{
                    FileWriter myWriter=new FileWriter("data.txt",true);
                    myWriter.write(result);
                    myWriter.close();
                    System.out.println("successfully wrote to the file.");

                }catch(IOException eju){
                    System.out.println("An error occurred");
                    eju.printStackTrace();
                }
                if (textNama.getText().isBlank()){
                    JOptionPane.showMessageDialog(null, "Masukan Nama Terlebih Dahulu!");
                    return;
                } else if (comboBarang.getSelectedItem().toString().equals("-Pilih Barang-")){
                    JOptionPane.showMessageDialog(null, "Pilih Jenis Barang Terlebih Dahulu!");
                    return;
                } else if (comboLayanan.getSelectedItem().toString().equals("-Pilih Layanan-")){
                    JOptionPane.showMessageDialog(null, "Pilih Opsi Layanan Terlebih Dahulu!");
                    return;
                } else if (textAlamat.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Masukan Alamat Terlebih Dahulu!");
                    return;
                }else {
                    tableModel.addRow(new Object[]{nama, barang, layanan, alamat, nomor});
                   //clear textfields
                    textNama.setText("");
                    textAlamat.setText("");
                    comboBarang.getSelectedItem();
                    comboBarang.getSelectedItem();
                }}
            });
    }

    private void initCompenent(){
        Object[] tableColom = {
                "Nama Pelanggan",
                "Jenis Barang",
                "Opsi Layanan",
                "Alamat",
                "Nomor HP",
                "Total Harga"
        };
        Object[][] initData = {
        };
        tableModel = new DefaultTableModel(initData, tableColom);
        //set table model
        tableCAS.setModel(tableModel);
        //menampilkan sorting disetiap kolom
        tableCAS.setAutoCreateRowSorter(true);
        //enable single selection
        tableCAS.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public JPanel getRootPanel() {
        return rootPanel;}



}
