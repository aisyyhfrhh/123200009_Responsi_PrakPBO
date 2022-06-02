/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class Tranvsiew extends JFrame{
    JLabel labelID = new JLabel("ID Transaksi");
    JLabel labelBarang = new JLabel("Nama Barang");
    JLabel labelKasir = new JLabel("Nama Kasir");
    JLabel labelQuantity = new JLabel("Quantity");
    JLabel labelHarga = new JLabel("Harga Per Pcs");
    JLabel labelDiskon = new JLabel("Discount (%)");
    JLabel labelTotal = new JLabel("Harga Total");
    
    public JTextField textID = new JTextField();
    public JTextField textBarang = new JTextField();
    public JTextField textKasir = new JTextField();
    public JTextField textQuantity = new JTextField();
    public JTextField textHarga = new JTextField();
    public JTextField textDiskon = new JTextField();
    public JTextField textTotal = new JTextField();
    
    public JButton btnTambah = new JButton("Insert");
    public JButton btnUpdate = new JButton("Update");
    public JButton btnDelete = new JButton("Delete");
    public JButton btnReset = new JButton("Reset");
    
    public JTable tabelData;
    DefaultTableModel TableModel;
    JScrollPane scrollPane;
    public Object namaKolom[] = {"ID Transaksi", "Nama Barang", "Nama Kasir", "Quantity", "Harga Per Pcs", "Discount (%)", "Harga Total"};
    int baris = -1;

    public Tranvsiew() {
        TableModel = new DefaultTableModel(namaKolom, 0);
        tabelData = new JTable(TableModel);
        scrollPane = new JScrollPane(tabelData);
        
        setTitle("Data Catatan Transaksi");
        setVisible(true);
        setSize(850, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(labelID); labelID.setBounds(60,400,100,20);
        add(labelBarang); labelBarang.setBounds(60,430,100,20);
        add(labelKasir); labelKasir.setBounds(60,460,100,20);
        add(labelQuantity); labelQuantity.setBounds(60,490,100,20);
        add(labelHarga); labelHarga.setBounds(60,520,100,20);
        add(labelDiskon); labelDiskon.setBounds(60,550,100,20);
        
        add(textID); textID.setBounds(180,400,250,20);
        add(textBarang); textBarang.setBounds(180,430,250,20);
        add(textKasir); textKasir.setBounds(180,460,250,20);
        add(textQuantity); textQuantity.setBounds(180,490,250,20);
        add(textHarga); textHarga.setBounds(180,520,250,20);
        add(textDiskon); textDiskon.setBounds(180,550,250,20);
        
        add(btnTambah); btnTambah.setBounds(600, 410, 200, 30);
        add(btnUpdate); btnUpdate.setBounds(600, 450, 200, 30);
        add(btnDelete); btnDelete.setBounds(600, 490, 200, 30);
        add(btnReset); btnReset.setBounds(600, 530, 200, 30);
        add(scrollPane); 
        scrollPane.setBounds(40,50,425,400);
        scrollPane.setSize(770, 325);
    }
    
    public int getBaris(){
        return baris;
    }

    public String getID(){
        return textID.getText();
    }
    
    public String getBarang(){
        return textBarang.getText();
    }
    
    public String getKasir(){
        return textKasir.getText();
    }
    
    public String getQuantity(){
        return textQuantity.getText();
    }

    public String getHarga(){
        return textHarga.getText();
    }

    public String getDiskon(){
        return textDiskon.getText();
    }
}