package tugas4;
import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        Connector connect = new Connector();
        new Menu();
    }
}

class Menu extends JFrame implements ActionListener{
    JLabel title = new JLabel ("Data Formulir Pendaftaran Pondok Winnie");
    JButton lihat = new JButton("Tampilkan Data");
    
    public Menu(){
        setTitle("formulir");
        setSize(400,200);
        setVisible(true);
        
        setLayout(null);
        add (title); 
        add(lihat);
        
        title.setBounds(150,10,120,20);
        lihat.setBounds(140,40,100,20);
        lihat.addActionListener(this);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if (e.getSource() == lihat){
            new Preview(); 
            dispose();
        }
    }
}
