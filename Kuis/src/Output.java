import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Output {
    public static void main(String[] args) {
        new OUT();
    }
}

class OUT extends JFrame{
    String tempEmail, tempUsername, tempPassword, tempNama, tempT4Lahir;
    String tempTglLahir, tempKelamin, tempDomisili, tempDeskripsi;
    
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

    
    public OUT(){
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
       
        setVisible(true);
        
        try{
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
                if(tempEmail == null) 
                    tempEmail = data;
                else if(tempUsername == null) 
                    tempUsername = data;
                else if(tempPassword == null) 
                    tempPassword = data;
                else if(tempNama == null) 
                    tempNama = data;
                else if(tempT4Lahir == null) 
                    tempT4Lahir = data;
                else if(tempTglLahir == null) 
                    tempTglLahir = data;
                else if(tempKelamin == null) 
                    tempKelamin = data;
                else if(tempDomisili == null) 
                    tempDomisili = data;
                else if(tempDeskripsi == null) 
                    tempDeskripsi = data;
            }
            myReader.close();
        }
        catch(FileNotFoundException y){
            System.out.println("An error occurred.");
            y.printStackTrace();
        }
        email.setText(""+tempEmail);
        username.setText(""+tempUsername);
        password.setText(""+tempPassword);
        nama.setText(""+tempNama);
        t4Lahir.setText(""+tempT4Lahir);
        tglLahir.setText(""+tempTglLahir);
        kelamin.setText(""+tempKelamin);
        domisili.setText(""+tempDomisili);
        deskripsi.setText(""+tempDeskripsi);
    } 
}