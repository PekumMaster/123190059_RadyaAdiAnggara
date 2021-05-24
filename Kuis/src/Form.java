/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author GF63-9SC-621ID
 */

import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Form {
    public static void main(String[] args) {
        new GUI();
    }
}

class GUI extends JFrame implements ActionListener{
    String tempEmail, tempUsername, tempPassword, tempNama, tempT4Lahir;
    String tempTglLahir, tempKelamin, tempDomisili, tempDeskripsi;
    
    int valid, count;
    
    JLabel lbEmail = new JLabel("Email");
    JLabel lbUsername = new JLabel("Username");
    JLabel lbPassword = new JLabel("Password");
    JLabel lbNama = new JLabel("Nama Lengkap");
    JLabel lbT4Lahir = new JLabel("Tempat Lahir");
    JLabel lbTglLahir = new JLabel("Tanggal Lahir");
    JLabel lbKelamin = new JLabel("Jenis Kelamin");
    JLabel lbDomisili = new JLabel("Domisili");
    JLabel lbDeskripsi = new JLabel("Deskripsi singkat");
    
    JTextField email = new JTextField(30);
    JTextField username = new JTextField(30);
    JTextField password = new JTextField(20);
    JTextField nama = new JTextField(30);
    JTextField t4Lahir = new JTextField(30);
    JTextField tglLahir = new JTextField(18);
    JTextField kelamin = new JTextField(18);
    JTextField domisili = new JTextField(25);
    JTextField deskripsi = new JTextField(100);
    JTextField validation = new JTextField(100);
    
    JButton btnCheck = new JButton("Check");
    JButton btnSubmit = new JButton("Submit");
    JButton btnData = new JButton("Show Data");
    
    public GUI(){
        setTitle("Formulir Pendaftaran Pondok Winnie");
        setSize(500,450);

        
        setLayout(null);
        
        add(lbEmail);
        add(lbUsername);
        add(lbPassword);
        add(lbNama);
        add(lbT4Lahir);
        add(lbTglLahir);
        add(lbKelamin);
        add(lbDomisili);
        add(lbDeskripsi);
        
        add(email);
        add(username);
        add(password);
        add(nama);
        add(t4Lahir);
        add(tglLahir);
        add(kelamin);
        add(domisili);
        add(deskripsi);
        add(validation);
        
        add(btnCheck);
        add(btnSubmit);
        add(btnData);
        
        //------------------------------------------------------
        
        lbEmail.setBounds(10, 15, 200, 20);
        lbUsername.setBounds(10, 45, 200, 20);
        lbPassword.setBounds(10, 75, 200, 20);
        lbNama.setBounds(10, 105, 200, 20);
        lbT4Lahir.setBounds(10, 135, 200, 20);
        lbTglLahir.setBounds(10, 165, 200, 20);
        lbKelamin.setBounds(10, 195, 200, 20);
        lbDomisili.setBounds(10, 225, 200, 20);
        lbDeskripsi.setBounds(10, 255, 200, 20);
        
        email.setBounds(120, 15, 200, 20);
        username.setBounds(120, 45, 200, 20);
        password.setBounds(120, 75, 200, 20);
        nama.setBounds(120, 105, 200, 20);
        t4Lahir.setBounds(120, 135, 200, 20);
        tglLahir.setBounds(120, 165, 200, 20);
        kelamin.setBounds(120, 195, 200, 20);
        domisili.setBounds(120, 225, 200, 20);
        deskripsi.setBounds(120, 255, 200, 20);
        validation.setBounds(160, 350, 150, 20);
        
        btnCheck.setBounds(10, 300, 130, 20);
        btnSubmit.setBounds(174, 300, 130, 20);
        btnData.setBounds(340, 300, 130, 20);
        setVisible(true);
        
        btnCheck.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnData.addActionListener(this);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent x){
        if(x.getSource() == btnCheck){
            valid = 0;
            tempEmail = email.getText();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (tempEmail.matches(regex));
            else { 
                email.setText("Harus sesuai format");
                valid = 1;
            }
            
            tempUsername = username.getText();
            Pattern form = Pattern.compile("[^a-zA-Z0-9]");
            Matcher equal = form.matcher(tempUsername);
            boolean id = equal.find();
            if(id){ 
                username.setText("hanya boleh menggunakan huruf dan angka");
                valid = 1;
            }
            
            tempPassword = password.getText();
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(tempPassword);
            boolean pass = matcher.find();
            if(pass);
            else{
                password.setText("harus mengandung huruf, angka, dan simbol");
                valid = 1;
            }
    
            tempNama = nama.getText();
            tempT4Lahir = t4Lahir.getText();
            tempTglLahir = tglLahir.getText();
            tempKelamin = kelamin.getText();
            tempDomisili = domisili.getText();
            tempDeskripsi = deskripsi.getText();
            count = tempDeskripsi.length();
            if(count > 200){ 
                deskripsi.setText("max 200 character");
                valid = 1;
            }
        }
        
        if (x.getSource()==btnSubmit){
            if (valid == 1) validation.setText("Isi data dengan benar !");
            else{
                try{
                    FileWriter myWriter = new FileWriter("data.txt", true);
                    myWriter.write(""+tempEmail);
                    myWriter.write("\r\n");
                    myWriter.write(""+tempUsername);
                    myWriter.write("\r\n");   
                    myWriter.write(""+tempPassword);
                    myWriter.write("\r\n");  
                    myWriter.write(""+tempNama);
                    myWriter.write("\r\n");   
                    myWriter.write(""+tempT4Lahir);
                    myWriter.write("\r\n");   
                    myWriter.write(""+tempTglLahir);
                    myWriter.write("\r\n");  
                    myWriter.write(""+tempKelamin);
                    myWriter.write("\r\n");   
                    myWriter.write(""+tempDomisili);
                    myWriter.write("\r\n");  
                    myWriter.write(""+tempDeskripsi);
                    myWriter.close();
                    validation.setText("Data telah dikirim");
                }catch(IOException y){
                    System.out.println("An error occurred.");
                    y.printStackTrace();
                }
            }
        }
        if (x.getSource()==btnData){
            new OUT();
            dispose();
        }
    }
}
