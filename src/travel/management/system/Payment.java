
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Payment extends JFrame implements ActionListener{
    JButton pay,back;
    
    Payment(){
        setBounds(240,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,800,520);
        add(image);
        
        pay = new JButton("Pay");
        pay.setBounds(100,20,150,25);
        pay.addActionListener(this);
        image.add(pay);
        
        back = new JButton("Back");
        back.setBounds(530,20,150,25);
        back.addActionListener(this);
        image.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == pay){
            new Paytm();
            setVisible(false);
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String [] args){
        new Payment();
    }

    
    
}
