/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalkulator;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author GF63-9SC-621ID
 */
public class kalkulator {
    public static void main(String[] args) {
        new GUI();
    }
}

class GUI extends JFrame implements ActionListener{
    String symbol;
    Float temp,input,output;
    
    final JTextField result = new JTextField(10);
    JButton btn0 = new JButton("0");
    JButton btn1 = new JButton("1");
    JButton btn2 = new JButton("2");
    JButton btn3 = new JButton("3");
    JButton btn4 = new JButton("4");
    JButton btn5 = new JButton("5");
    JButton btn6 = new JButton("6");
    JButton btn7 = new JButton("7");
    JButton btn8 = new JButton("8");
    JButton btn9 = new JButton("9");
    JButton btnPlus = new JButton("+");
    JButton btnMin = new JButton("-");
    JButton btnMulti = new JButton("*");
    JButton btnDiv = new JButton(":");
    JButton btnEqual = new JButton("=");
    
    public GUI(){
        setTitle("Kalkulator");
        setSize(300,450);
        setLayout(null);
        add(btn0);
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        add(btn5);
        add(btn6);
        add(btn7);
        add(btn8);
        add(btn9);
        add(btnPlus);
        add(btnMin);
        add(btnMulti);
        add(btnDiv);
        add(btnEqual);
        add(result);
        
        result.setBounds(30,10,205,40);
        btn0.setBounds(100,220,60,40);
        btn1.setBounds(30,70,60,40);
        btn2.setBounds(100,70,60,40);
        btn3.setBounds(170,70,60,40);
        btn4.setBounds(30,120,60,40);
        btn5.setBounds(100,120,60,40);
        btn6.setBounds(170,120,60,40);
        btn7.setBounds(30,170,60,40);
        btn8.setBounds(100,170,60,40);
        btn9.setBounds(170,170,60,40);
        btnPlus.setBounds(30,220,60,40);
        btnMin.setBounds(170,220,60,40);
        btnMulti.setBounds(30,270,60,40);
        btnDiv.setBounds(100,270,60,40);
        btnEqual.setBounds(170,270,60,40);
        setVisible(true);
        
        btn0.addActionListener(this);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);
        btn7.addActionListener(this);
        btn8.addActionListener(this);
        btn9.addActionListener(this);
        btnPlus.addActionListener(this);
        btnMin.addActionListener(this);
        btnMulti.addActionListener(this);
        btnDiv.addActionListener(this);
        btnEqual.addActionListener(this);
    }    
    
    public void actionPerformed(java.awt.event.ActionEvent x){
        if(x.getSource()==btn0) result.setText(result.getText()+"0");
        if(x.getSource()==btn1) result.setText(result.getText()+"1");
        if(x.getSource()==btn2) result.setText(result.getText()+"2");
        if(x.getSource()==btn3) result.setText(result.getText()+"3");
        if(x.getSource()==btn4) result.setText(result.getText()+"4");
        if(x.getSource()==btn5) result.setText(result.getText()+"5");
        if(x.getSource()==btn6) result.setText(result.getText()+"6");
        if(x.getSource()==btn7) result.setText(result.getText()+"7");
        if(x.getSource()==btn8) result.setText(result.getText()+"8");
        if(x.getSource()==btn9) result.setText(result.getText()+"9");
        
        if(x.getSource()==btnPlus){
            input = Float.parseFloat(result.getText());
            if(symbol=="plus") temp = temp + input;
            if(symbol=="minus") temp = temp - input;
            if(symbol=="multiple") temp = temp * input;
            if(symbol=="divine") temp = temp / input;
            if(symbol=="result") temp = null;
            if(temp==null) temp = input;
            symbol = "plus";
            result.setText("");
        }
        if(x.getSource()==btnMin){
            input = Float.parseFloat(result.getText());
            if(symbol=="plus") temp = temp + input;
            if(symbol=="minus") temp = temp - input;
            if(symbol=="multiple") temp = temp * input;
            if(symbol=="divine") temp = temp / input;
            if(symbol=="result") temp = null;
            if(temp==null) temp = input;
            symbol = "minus";
            result.setText("");
        }
        if(x.getSource()==btnMulti){
            input = Float.parseFloat(result.getText());
            if(symbol=="plus") temp = temp + input;
            if(symbol=="minus") temp = temp - input;
            if(symbol=="multiple") temp = temp * input;
            if(symbol=="divine") temp = temp / input;
            if(symbol=="result") temp = null;
            if(temp==null) temp = input;
            symbol = "multiple";
            result.setText("");
        }
        if(x.getSource()==btnDiv){
            input = Float.parseFloat(result.getText());
            if(symbol=="plus") temp = temp + input;
            if(symbol=="minus") temp = temp - input;
            if(symbol=="multiple") temp = temp * input;
            if(symbol=="divine") temp = temp / input;
            if(symbol=="result") temp = null;
            if(temp==null) temp = input;
            symbol = "divine";
            result.setText("");
        }
        if (x.getSource()==btnEqual){
            output=temp;
            if("plus".equals(symbol))
                result.setText(Float.toString(output + Float.parseFloat(result.getText())));   
            if("minus".equals(symbol))
                result.setText(Float.toString(output - Float.parseFloat(result.getText())));
            if("multiple".equals(symbol))
                result.setText(Float.toString(output * Float.parseFloat(result.getText())));
            if("divine".equals(symbol))
                result.setText(Float.toString(output / Float.parseFloat(result.getText())));
            
            symbol="result";
        }
    }
}
