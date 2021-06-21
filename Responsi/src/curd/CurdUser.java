package curd;

import window.WdUser;
import connection.Connector;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import function.*;

public class CurdUser implements FcUser{
    String email, password, id;
    String tempId, tempNama, tempEmail, tempPassword, tempRole;

    @Override
    public void save(WdUser daf) throws SQLException { //untuk menginput dan menyimpan cerita
        try{
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "insert into cerita values(NULL, '"+ daf.fJudul.getText() + "','"+daf.fIsi.getText()+"','"+daf.fId.getText()+"')";
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cerita Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            tempStatement.close();
        }catch(Exception ex){
            
        }
    }

    @Override
    public void edit(WdUser daf) throws SQLException { //untuk mengupdate data cerita
        try {
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "update cerita set "
                        + "cerid            = '" + daf.fCerid.getText() +"', "
                        + "judul            = '" + daf.fJudul.getText()+"', "
                        + "isi              = '" + daf.fIsi.getText()+"', "
                        + "id               = '" + daf.fId.getText() +"' "
                        + "where cerid      = '" + daf.fCerid.getText() + "'";
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cerita Berhasil di Ubah");
            tempStatement.close();

        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cerita Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(WdUser daf) throws SQLException { //untuk menghapus data cerita
        try{
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "delete from cerita where cerid=" +daf.fCerid.getText();
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Cerita Berhasil di Hapus");
            tempStatement.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Cerita Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void view(WdUser daf) throws SQLException { //untuk menampilkan data cerita
        try {
            try {
                File myObj = new File("data.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    if(email == null) email = data;
                    else if(password == null) password = data;
                }
                myReader.close();
            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement1 = tempConnect.createStatement();
            String sql1 = "select * from user where email='"+email+"' and password='"+password+"'";
            ResultSet temp = tempStatement1.executeQuery(sql1);
            while(temp.next()){
                id = temp.getString(1); //mengambil id
            } 
            daf.fId.setText(""+id);
            tempStatement1.close();
            
            Statement tempStatement2 = tempConnect.createStatement();
            String sql2 = "select * from cerita where id="+id; //mengambil seluruh data dari id yang dicantumkan
            ResultSet temp2 = tempStatement2.executeQuery(sql2);
            while(temp2.next())
            {
                Object[] ob= new Object[8];
                ob[0] = temp2.getString(1);
                ob[1] = temp2.getString(2);
                ob[2] = temp2.getString(3);
                ob[3] = temp2.getString(4);
                daf.tblmodel.addRow(ob);
            } 
            tempStatement2.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "gagal", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void onTable(WdUser daf) throws SQLException { //mengambil data dari tabel ke field
        try {
             int pilih = daf.tabel.getSelectedRow();
             daf.fCerid.setText(daf.tblmodel.getValueAt(pilih, 0).toString());
             daf.fJudul.setText(daf.tblmodel.getValueAt(pilih, 1).toString());
             daf.fIsi.setText(daf.tblmodel.getValueAt(pilih, 2).toString());
             daf.fId.setText(daf.tblmodel.getValueAt(pilih, 3).toString());           
        } catch (Exception e) {
        }
    }

    @Override
    public void updateAccount(WdUser daf) throws SQLException { //mengupdate akun user oleh user
        try{
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "update user set "
                        + "id           = '" + daf.fId.getText()            +"', "
                        + "nama         = '" + daf.fNama.getText()          +"', "
                        + "email        = '" + daf.fEmail.getText()         +"', "
                        + "password     = '" + daf.fPassword.getText()          +"', "
                        + "role         = '" + tempRole  +"' "
                        + "where id     = '" + daf.fId.getText()            + "'";
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Akun Berhasil di Ubah");
            tempStatement.close();
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Akun Gagal Diupdate", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void viewAccount(WdUser daf) throws SQLException { //menampilkan data akun user
        try{
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "select * from user where id="+id;
            ResultSet temp = tempStatement.executeQuery(sql);
            while(temp.next()){
                tempId = temp.getString(1);
                tempNama = temp.getString(2);
                tempEmail = temp.getString(3);
                tempPassword = temp.getString(4);
                tempRole = temp.getString(5);
            }
            daf.fNama.setText(tempNama);
            daf.fEmail.setText(tempEmail);
            daf.fPassword.setText(tempPassword);
            tempStatement.close();
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Akun Gagal Ditampilkan", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
