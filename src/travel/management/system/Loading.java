
package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
     Thread t;
     JProgressBar bar;
     String username;
     
     public void run() {
        try{
            for(int i=1;i<=101;i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();
                
                if(value<max){  //101<100
                    bar.setValue(bar.getValue() +1);
                }else{
                    new Deshboard(username);
                    
                    setVisible(false);
                    
                }
                Thread.sleep(40);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username=username;
        t = new Thread(this);
        
        setBounds(350,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Travel And Tourism Application");
        text.setBounds(50,20,600,40);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        text.setForeground(Color.blue);
        add(text);
        
        bar = new JProgressBar();
        bar.setBounds(150,100,300,35);
        bar.setStringPainted(true);
        add(bar);
        
        JLabel loading = new JLabel("Loading,Please Wait");
        loading.setBounds(230,130,150,30);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        loading.setForeground(Color.red);
        add(loading);
        
        JLabel user = new JLabel("Welcome "+username);
        user.setBounds(20,330,400,30);
        user.setFont(new Font("Raleway",Font.BOLD,16));
        user.setForeground(Color.red);
        add(user);
        
        t.start();
        setVisible(true);
    }
    public static void main(String[] args){
        new Loading("");
        
    }

}
