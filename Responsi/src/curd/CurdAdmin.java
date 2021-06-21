package curd;

import window.WdAdmin;
import connection.Connector;
import java.sql.*;
import javax.swing.*;
import function.FcAdmin;

public class CurdAdmin implements FcAdmin{

    @Override
    public void edit(WdAdmin adm) throws SQLException { //mengubah data admin
        try {
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "update user set "
                        + "id           = '" + adm.fId.getText()            +"', "
                        + "nama         = '" + adm.fNama.getText()          +"', "
                        + "email        = '" + adm.fEmail.getText()         +"', "
                        + "password     = '" + adm.fPassword.getText()          +"', "
                        + "role         = '" + adm.fRole.getSelectedItem()  +"' "
                        + "where id     = '" + adm.fId.getText()            + "'";
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Ubah");
            tempStatement.close();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        finally{
            adm.setLebarKolom();
        }
    }

    @Override
    public void view(WdAdmin adm) throws SQLException { //menampilkan data admin
        try {
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "select * from user";
            ResultSet temp = tempStatement.executeQuery(sql);
            while(temp.next())
            {
                Object[] ob= new Object[8];
                ob[0] = temp.getString(1);
                ob[1] = temp.getString(2);
                ob[2] = temp.getString(3);
                ob[3] = temp.getString(4);
                ob[4] = temp.getString(5);
                adm.tblmodel.addRow(ob);
            } 
            tempStatement.close();
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal!", "Hasil", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    @Override
    public void delete(WdAdmin adm) throws SQLException { //menghapus data admin
        try{
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "delete from user where id=" +adm.fId.getText();
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");
            tempStatement.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void onTable(WdAdmin adm) throws SQLException { //menampilkan data admin saat mengklik pada tabel
        String role = null;
        try {
             int pilih = adm.tabel.getSelectedRow();
             adm.fId.setText(adm.tblmodel.getValueAt(pilih, 0).toString());
             adm.fNama.setText(adm.tblmodel.getValueAt(pilih, 1).toString());
             adm.fEmail.setText(adm.tblmodel.getValueAt(pilih, 2).toString());
             adm.fPassword.setText(adm.tblmodel.getValueAt(pilih, 3).toString());
             role = String.valueOf(adm.tblmodel.getValueAt(pilih, 4).toString());
             adm.fRole.setSelectedItem(adm.tblmodel.getValueAt(pilih, 4).toString());
             
                   
        } 
        catch (Exception e) {
        }
    }   
}
