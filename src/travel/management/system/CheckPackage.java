
package travel.management.system;

import java.awt.*;
import javax.swing.*;


public class CheckPackage extends JFrame{
    CheckPackage(){
        setBounds(240,100,850,550);
        
        String[] package1 = {"GOLD PACKAGE","6 Days and 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft Drink Free","Full Day 4 Island Cruise","English Speaking Guide","Book Package","SUMMER SPECIAL","40000/-","package1.jpg"};
        String[] package2 = {"SILVER PACKAGE","5 Days and 6 Nights","Bus Service","Rafting","Camping","ParaGliding","Lunck and Dineer","Welcome Drink on Arrival","Book Now","Winter Package","25000/-","Package2.jpg"};
        String[] package3 = {"BRONZE PACKAGE","3 Days and 4 Night","Return Affairs","Horse Riding & other Games","Hard Drink Free","Only Dinner","Cruise with Dinner","Clubbing","Book Your Package","Summer Package","20000/-","package3.jpg"};
        
        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = CreatePackage(package1);
        tab.addTab("Package 1", null, p1);
        add(tab);
        
        JPanel p2 = CreatePackage(package2);
        tab.addTab("Package 2", null, p2);
        add(tab);
        
        JPanel p3 = CreatePackage(package3);
        tab.addTab("Package 3", null, p3);
        add(tab);
        
        setVisible(true);
    }
    
    public JPanel CreatePackage(String[] pack){
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.white);
        
        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(30,10,300,25);
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Raleway",Font.BOLD,30));
        p1.add(l1);
        
        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,50,300,50);
        l2.setForeground(Color.red);
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        p1.add(l2);
        
        JLabel l3 = new JLabel(pack[2]);
        l3.setBounds(30,90,300,50);
        l3.setForeground(Color.blue);
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        p1.add(l3);
        
        JLabel l4 = new JLabel(pack[3]);
        l4.setBounds(30,130,300,50);
        l4.setForeground(Color.red);
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l4);
        
        JLabel l5 = new JLabel(pack[4]);
        l5.setBounds(30,170,300,50);
        l5.setForeground(Color.green);
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l5);
        
        JLabel l6 = new JLabel(pack[5]);
        l6.setBounds(30,210,300,50);
        l6.setForeground(Color.blue);
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l6);
        
        JLabel l7 = new JLabel(pack[6]);
        l7.setBounds(30,260,350,50);
        l7.setForeground(Color.red);
        l7.setFont(new Font("Tahoma",Font.BOLD,25));
        p1.add(l7);
        
        JLabel l8 = new JLabel(pack[7]);
        l8.setBounds(30,310,350,50);
        l8.setForeground(Color.blue);
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        p1.add(l8);
        
        JLabel l9 = new JLabel(pack[8]);
        l9.setBounds(30,350,350,50);
        l9.setForeground(Color.black);
        l9.setFont(new Font("Tahoma",Font.BOLD,28));
        p1.add(l9);
        
        JLabel l10 = new JLabel(pack[9]);
        l10.setBounds(30,400,350,50);
        l10.setForeground(Color.ORANGE);
        l10.setFont(new Font("Tahoma",Font.BOLD,32));
        p1.add(l10);
        
        JLabel l11 = new JLabel(pack[10]);
        l11.setBounds(500,400,350,50);
        l11.setForeground(Color.green);
        l11.setFont(new Font("Tahoma",Font.BOLD,32));
        p1.add(l11);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(480, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(330,20,500,300);
        p1.add(image);
        
        return p1;
    }
    
    public static void main(String[] args){
        new CheckPackage();
    }
}
