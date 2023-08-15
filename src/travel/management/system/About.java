
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JFrame implements ActionListener{
    JButton back;
    About(){
        setBounds(450,100,450,500);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("About Us");
        l1.setBounds(30,10,150,40);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        add(l1);
        
        TextArea area = new TextArea("Hello",10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(30,100,300,150);
        add(area);
        
        back = new JButton("Back");
        back.setBounds(150,300,100,25);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
             setVisible(false);
             
        }
    }
    public static void main(String [] args){
        new About();
    }

    
    
}
