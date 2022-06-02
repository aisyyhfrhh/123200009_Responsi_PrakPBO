/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Lenovo
 */
public class Transaksi {
    static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    static final String url = "jdbc:mysql://localhost/trans_db";
    static final String username = "root";
    static final String password = "";
    
    Connection koneksi;
    Statement statement;

    public Transaksi() {
        try{
            Class.forName(jdbc_driver);
            koneksi = (Connection) DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String[][] readContact(){
        try{
            int jmlData = 0;
            
            String data[][] = new String[getBanyakData()][7]; 
            
            String query = "SELECT * FROM transactions"; 
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = resultSet.getString("id_trans"); 
                data[jmlData][1] = resultSet.getString("nama_barang");
                data[jmlData][2] = resultSet.getString("nama_kasir");
                data[jmlData][3] = String.valueOf(resultSet.getInt("qty"));
                data[jmlData][4] = String.valueOf(resultSet.getDouble("price_per_qty"));
                data[jmlData][5] = String.valueOf(resultSet.getDouble("discount"));
                data[jmlData][6] = String.valueOf(resultSet.getDouble("price_total"));
                jmlData++;
            }
            return data;
               
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    
    public void insertData(String id, String nama, String kasir, int jumlah, double harga, double diskon, double total){
        try {
            String query = "INSERT INTO transactions VALUES('" + id + "','" + nama + "','" + kasir + "','" + jumlah + "','" + harga + "','" + diskon + "','" + total + "')";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil ditambahkan");
            JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateData(String ID, String Barang, String Kasir, int Quantity, double Harga, double Diskon, double Total){
         try {
            String query = "UPDATE transactions SET id_trans='" + ID + "', nama_barang='" + Barang + "', nama_kasir='"+ Kasir+"', qty='"+ Quantity+"', price_per_qty='"+ Harga+"', discount='"+ Diskon+"', price_total='"+ Total+"' WHERE id_trans='" + ID+"'"; 
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            System.out.println("Berhasil diupdate");
            JOptionPane.showMessageDialog(null, "Data Berhasil diupdate");
        } catch (Exception sql) {
            System.out.println(sql.getMessage());   
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void deleteContact (String data) {
        try{
            String query = "DELETE FROM transactions WHERE id_trans = '"+data+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            
        }catch(SQLException sql) {
            System.out.println(sql.getMessage());
        }
    }

    public int getBanyakData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM transactions";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){ 
                jmlData++;
            }
            return jmlData;
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0; 
        }
    }
}