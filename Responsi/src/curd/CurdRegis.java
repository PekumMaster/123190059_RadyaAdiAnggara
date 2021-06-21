package curd;

import window.WdRegis;
import connection.Connector;
import java.sql.*;
import javax.swing.*;
import function.FcRegis;

public class CurdRegis implements FcRegis{

    @Override
    public void save(WdRegis daf) throws SQLException { //menyimpan data baru
        try{
            Connection tempConnect = Connector.getConnect();
            Statement tempStatement = tempConnect.createStatement();
            String sql = "insert into user values(NULL, '"+ daf.fNama.getText() + "','"+daf.fEmail.getText()+"','"+daf.fPassword.getText()+"','"+daf.fRole.getSelectedItem()+"')";
            tempStatement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Akun Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
            tempStatement.close();
        }catch(Exception ex){
            
        }
    }
    
}
