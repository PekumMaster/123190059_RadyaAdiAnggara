package tugas4;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.lang.String;

public class EditData {
    public static void main(String[] args) {
        new Edit();
    }
}

class Edit extends JFrame implements ActionListener{
    Connector connector = new Connector();
    
    String tempEmail, tempUsername, tempPassword, tempNama, tempT4Lahir;
    String tempTglLahir, tempKelamin, tempDomisili, tempDeskripsi;
    
    String no;
    
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
    
    JTextField femail = new JTextField(30);
    JTextField fusername = new JTextField(30);
    JTextField fpassword = new JTextField(20);
    JTextField fnama = new JTextField(30);
    JTextField ftmpLahir = new JTextField(30);
    JTextField ftglLahir = new JTextField(18);
    JTextField fkelamin = new JTextField(18);
    JTextField fdomisili = new JTextField(25);
    JTextField fdeskripsi = new JTextField(100);
    JTextField fvalidation = new JTextField(100);
    
    JLabel fno = new JLabel ("");
    
    JButton btnCheck = new JButton("Check");
    JButton btnSubmit = new JButton("Submit");
    JButton btnData = new JButton("Show Data");
    
    public Edit(){
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
        
        add(femail);
        add(fusername);
        add(fpassword);
        add(fnama);
        add(ftmpLahir);
        add(ftglLahir);
        add(fkelamin);
        add(fdomisili);
        add(fdeskripsi);
        add(fvalidation);
        
        add(fno);
        
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
        
        femail.setBounds(120, 15, 200, 20);
        fusername.setBounds(120, 45, 200, 20);
        fpassword.setBounds(120, 75, 200, 20);
        fnama.setBounds(120, 105, 200, 20);
        ftmpLahir.setBounds(120, 135, 200, 20);
        ftglLahir.setBounds(120, 165, 200, 20);
        fkelamin.setBounds(120, 195, 200, 20);
        fdomisili.setBounds(120, 225, 200, 20);
        fdeskripsi.setBounds(120, 255, 200, 20);
        fvalidation.setBounds(160, 350, 150, 20);
        
        btnCheck.setBounds(10, 300, 130, 20);
        btnSubmit.setBounds(174, 300, 130, 20);
        btnData.setBounds(340, 300, 130, 20);
        setVisible(true);
        
        btnCheck.addActionListener(this);
        btnSubmit.addActionListener(this);
        btnData.addActionListener(this);
        
        try {
            File myObj = new File("data.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(no == null) no = data;
                else if(tempEmail == null) tempEmail = data;
                else if(tempUsername== null) tempUsername = data;
                else if(tempPassword == null) tempPassword = data;
                else if(tempNama == null) tempNama = data;
                else if(tempT4Lahir == null) tempT4Lahir = data;
                else if(tempTglLahir == null) tempTglLahir = data;
                else if(tempKelamin == null) tempKelamin = data;
                else if(tempDomisili == null) tempDomisili = data;
                else if(tempDeskripsi == null) tempDeskripsi = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        fno.setText(""+no);    
        femail.setText(""+tempEmail);
        fusername.setText(""+tempUsername);
        fpassword.setText(""+tempPassword);
        fnama.setText(""+tempNama);
        ftmpLahir.setText(""+tempT4Lahir);
        ftglLahir.setText(""+tempTglLahir);
        fkelamin.setText(""+tempKelamin);
        fdomisili.setText(""+tempDomisili);
        fdeskripsi.setText(""+tempDeskripsi);          
    }
    
    public void actionPerformed(java.awt.event.ActionEvent x){
        if(x.getSource() == btnCheck){
            valid = 0;
            tempEmail = femail.getText();
            String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if (tempEmail.matches(regex));
            else { 
                femail.setText("Harus sesuai format");
                valid = 1;
            }
            
            tempUsername = fusername.getText();
            Pattern form = Pattern.compile("[^a-zA-Z0-9]");
            Matcher equal = form.matcher(tempUsername);
            boolean id = equal.find();
            if(id){ 
                fusername.setText("hanya boleh menggunakan huruf dan angka");
                valid = 1;
            }
            
            tempPassword = fpassword.getText();
            Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
            Matcher matcher = pattern.matcher(tempPassword);
            boolean pass = matcher.find();
            if(pass);
            else{
                fpassword.setText("harus mengandung huruf, angka, dan simbol");
                valid = 1;
            }
    
            tempNama = fnama.getText();
            tempT4Lahir = ftmpLahir.getText();
            tempTglLahir = ftglLahir.getText();
            tempKelamin = fkelamin.getText();
            tempDomisili = fdomisili.getText();
            tempDeskripsi = fdeskripsi.getText();
            count = tempDeskripsi.length();
            if(count > 200){ 
                fdeskripsi.setText("max 200 character");
                valid = 1;
            }
        }
        
        if (x.getSource()==btnSubmit){
            if (valid > 0) JOptionPane.showMessageDialog(null,"masih ada kesalahan");
            
            else {
                try {
                    connector.statement = connector.koneksi.createStatement();
                    String sql = "update data set "
                                    + "no = '"+fno.getText()+"', "
                                    + "email = '"+femail.getText()+"', "
                                    + "username = '"+fusername.getText()+"', "
                                    + "password = '"+fpassword.getText()+"', "
                                    + "nama = '"+fnama.getText()+"', "
                                    + "tmplahir = '"+ftmpLahir.getText()+"', "
                                    + "tgllahir = '"+ftglLahir.getText()+"', "
                                    + "kelamin = '"+fkelamin.getText()+"', "
                                    + "domisili = '"+fdomisili.getText()+"', "
                                    + "deskripsi = '"+fdeskripsi.getText()+"' "
                                    + "where no = '" + fno.getText() + "'";
                    connector.statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan!", "Hasil",JOptionPane.INFORMATION_MESSAGE);            
                    connector.statement.close();
                    connector.koneksi.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Disimpan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } 
            }
        }
        if (x.getSource()==btnData){
            new Preview();
            dispose();
        }
    }
}
    

