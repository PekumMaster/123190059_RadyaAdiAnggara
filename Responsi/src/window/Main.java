package window;

import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import connection.Connector;


public class Main {
    public static void main(String[] args) {
        new Menu();
    }
}

class Menu extends JFrame implements ActionListener{
    //membuat label dan text field untuk mengisi email dan password, beserta login dan register
    
    int valid;
    
    JLabel lTitle = new JLabel ("Responsi Ceria");
    JLabel lEmail = new JLabel ("Email");
    JLabel lPassword = new JLabel ("Password");
    
    JTextField fEmail = new JTextField(30);
    JTextField fPassword = new JTextField(20);
    
    JButton regis = new JButton("Register");
    JButton login = new JButton("Login");
    
    public Menu(){
        //mengatur posisi atribut2
        setTitle("Responsi");
        setSize(450,300);
        setLocationRelativeTo(null);
        setVisible(true);
        
        setLayout(null);
        add(lTitle); 
        add(lEmail); 
        add(lPassword); 
        add(fEmail); 
        add(fPassword); 
        add(regis);
        add(login);
        
        lTitle.setBounds(175,10,120,30);
        lEmail.setBounds(95,60,120,30);
        lPassword.setBounds(95,110,120,30);
        fEmail.setBounds(190,60,170,30);
        fPassword.setBounds(190,110,170,30);
        regis.setBounds(100,200,100,20);
        login.setBounds(240,200,100,20);
        
        regis.addActionListener(this);
        login.addActionListener(this);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource()==login){
            try{
                Connection tempConnect = Connector.getConnect();
                Statement tempStatement1 = tempConnect.createStatement();
                //login admin
                String sql1 = "select * from user where email='"+fEmail.getText()+"' and password='"+fPassword.getText()+"' and role='admin'";
                ResultSet tempResult1 = tempStatement1.executeQuery(sql1);
                if (tempResult1.next()) {
                    JOptionPane.showMessageDialog(null, "Login Sukses! (Admin)");
                    new WdAdmin().setVisible(true);
                    dispose();
                }
                else { //login user
                    Statement tempStatement2 = tempConnect.createStatement();
                    String sql2 = "select * from user where email='"+fEmail.getText()+"' and password='"+fPassword.getText()+"' and role='user'";
                    ResultSet tempResult2 = tempStatement2.executeQuery(sql2);
                    if (tempResult2.next()) {
                        try {
                            FileWriter myWriter = new FileWriter("data.txt", false);
                            myWriter.write(""+fEmail.getText());
                            myWriter.write("\r\n");
                            myWriter.write(""+fPassword.getText());
                            myWriter.close();
                        } catch (IOException x) {
                            x.printStackTrace();
                        }
                        JOptionPane.showMessageDialog(null, "Login Sukses! (User)");
                        new WdUser().setVisible(true);
                        dispose();
                    }
                    else JOptionPane.showMessageDialog(null, "Login Gagal!");
                }
                
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error!", "Hasil", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            } 
        }
        if (e.getSource() == regis){
            //masuk regis
            new WdRegis().setVisible(true);
            dispose();
        }
    }
}
