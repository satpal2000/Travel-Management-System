
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    JButton back;
    
    Paytm(){
        setBounds(240,100,850,550);
        
        JEditorPane pane = new JEditorPane();
        pane.setEditable(false);
        
        try{
            pane.setPage("http://paytm.com/rent-payment");
        }catch(Exception e){
            pane.setContentType("text/html");
            pane.setText("<html>Could Not Load Error...</html>");
        }
        
        JScrollPane sp = new JScrollPane(pane);
        getContentPane().add(sp);
        
        back = new JButton("Back");
        back.setBounds(600,30,100,25);
        back.addActionListener(this);
        pane.add(back);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back){
            setVisible(false);
            new Payment();
            
        }
    }
    public static void main(String[] args){
        new Paytm();
    }   
    
}
