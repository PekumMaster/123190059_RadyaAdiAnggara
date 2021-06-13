package tugas4;
import java.awt.FlowLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TampilData {
        public static void main(String[] args) {
        new Preview();
    }  
}

class Preview extends JFrame implements ActionListener{
    String no, email, username, password, nama, tmplahir, tgllahir, kelamin, domisili, deskripsi;
    JLabel lno = new JLabel ("no");
    JTextField fno = new JTextField(5);
    
    JButton adds = new JButton("Tambah Data");
    JButton edit = new JButton("Edit Data");
    JButton delete = new JButton("Hapus Data");
    
    String[][] data = new String[500][10];
    String[] atributte = {"no","email", "username","password","nama","tmplahir","tgllahir","kelamin","domisili","deskripsi"};
    JTable table;
    JScrollPane scrollPane;
    
    Connector connector = new Connector();
    
    public Preview(){
       try{
            int x = 0;
            
            String query = "Select * from `data`";
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query);
            
            while(resultSet.next()){
                data[x][0] = resultSet.getString("no");
                data[x][1] = resultSet.getString("email");
                data[x][2] = resultSet.getString("username");
                data[x][3] = resultSet.getString("password");
                data[x][4] = resultSet.getString("nama");
                data[x][5] = resultSet.getString("tmplahir");
                data[x][6] = resultSet.getString("tgllahir");
                data[x][7] = resultSet.getString("kelamin");
                data[x][8] = resultSet.getString("domisili");
                data[x][9] = resultSet.getString("deskripsi");
                x++;
            }
            connector.statement.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
                System.out.println("SQL Error");
            }
        
        table = new JTable(data, atributte);
        scrollPane = new JScrollPane(table);
        
        setTitle("Data Pendaftar Pondok Winnie");
        setVisible(true);
        
        setLayout(null);
        add(adds);
        add(edit);
        add(delete);
        
        adds.setBounds(30,10,120,20);
        edit.setBounds(170,10,120,20);
        delete.setBounds(310,10,120,20);
        setLayout(new FlowLayout());
        add(lno);
        add(fno);
        add(scrollPane);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        
        adds.addActionListener(this);
        edit.addActionListener(this);
        delete.addActionListener(this);
    }
    
    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == adds){
            new Tambah();
            dispose();
        }
        if (e.getSource() == edit){
            no = fno.getText();
            if (no.isEmpty() ) {
                JOptionPane.showMessageDialog(null,"no tidak boleh kosong");
                fno.requestFocus();
            }
            else{
                try {
                    String sql = "select * from data where no='" + no + "'";
                    connector.statement = connector.koneksi.createStatement();
                    ResultSet resultSet = connector.statement.executeQuery(sql);
                    if(resultSet.next()){
                        no = resultSet.getString("no");
                        email = resultSet.getString("email");
                        username = resultSet.getString("username");
                        password = resultSet.getString("password");
                        nama = resultSet.getString("nama");
                        tmplahir = resultSet.getString("tmplahir");
                        tgllahir = resultSet.getString("tgllahir");
                        kelamin = resultSet.getString("kelamin");
                        domisili = resultSet.getString("domisili");
                        deskripsi = resultSet.getString("deskripsi");
                    } 
                    connector.statement.close();
                    connector.koneksi.close();
                } 
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data Gagal Dicari!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } 
                try {
                    FileWriter myWriter = new FileWriter("data.txt", false);
                    myWriter.write(""+no);
                    myWriter.write("\r\n");
                    myWriter.write(""+email);
                    myWriter.write("\r\n");   
                    myWriter.write(""+username);
                    myWriter.write("\r\n");   
                    myWriter.write(""+password);
                    myWriter.write("\r\n");   
                    myWriter.write(""+nama);
                    myWriter.write("\r\n");   
                    myWriter.write(""+tmplahir);
                    myWriter.write("\r\n");   
                    myWriter.write(""+tgllahir);
                    myWriter.write("\r\n");  
                    myWriter.write(""+kelamin);
                    myWriter.write("\r\n");   
                    myWriter.write(""+domisili);
                    myWriter.write("\r\n");  
                    myWriter.write(""+deskripsi);
                    myWriter.close();
                } catch (IOException x) {
                    x.printStackTrace();
                }
                new Edit();
                dispose();
            }
        }
        if (e.getSource() == delete){
            no = fno.getText();
            if (no.isEmpty() ) {
                JOptionPane.showMessageDialog(null,"no tidak boleh kosong");
                fno.requestFocus();
            }
            else{
                try {
                    connector.statement = connector.koneksi.createStatement();
                    String sql = "delete from data where no=" + no;
                    connector.statement.executeUpdate(sql);
                        JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!", "Hasil",JOptionPane.INFORMATION_MESSAGE); 
                    connector.statement.close();
                    connector.koneksi.close();
                } 
                catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }
                new Preview();
                dispose();
            }
        }
    }
}

