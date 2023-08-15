 
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookPackage extends JFrame implements ActionListener{
    JLabel user,labeluser,number,labelnumber,labelid,labelname,name,labelphone,labelprice;
    Choice cpackage;
    JTextField tfperson;
    String username;
    JButton checkprice,bookpackage,back;
            
    BookPackage(String username){
        this.username=username;
        
        setBounds(240,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("BOOK PACKAGE");
        l1.setBounds(100,10,200,30);
        l1.setFont(new Font("Tahoma",Font.BOLD,20));
        add(l1);
        
        user = new JLabel("UserName");
        user.setBounds(30,50,150,25);
        user.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(user);
        
        labeluser = new JLabel();
        labeluser.setBounds(220,50,150,25);
        labeluser.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labeluser);
        
        JLabel lpackage = new JLabel("Select Package");
        lpackage.setBounds(30,100,150,25);
        lpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lpackage);
        
        cpackage = new Choice();
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        cpackage.setBounds(220,100,150,25);
        cpackage.setBackground(Color.white);
        add(cpackage);
        
        JLabel person = new JLabel("Total Person");
        person.setBounds(30,150,150,25);
        person.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(person);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(220,150,150,25);
        add(tfperson);
        
        name = new JLabel("Name");
        name.setBounds(30,200,150,25);
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(220,200,150,25);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        
        JLabel id = new JLabel("ID");
        id.setBounds(30,250,150,25);
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(id);
        
        labelid = new JLabel();
        labelid.setBounds(220,250,200,25);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);
        
        number = new JLabel("Number");
        number.setBounds(30,300,150,25);
        number.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(number);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220,300,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelnumber);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(30,350,200,25);
        phone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(phone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220,350,200,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelphone);
        
        JLabel price = new JLabel("Total Price");
        price.setBounds(30,400,200,25);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);
        
        labelprice = new JLabel();
        labelprice.setBounds(220,400,200,25);
        labelprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelprice);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet res = c.s.executeQuery(query);
            
            while(res.next()){
                labeluser.setText(res.getString("username"));
                labelid.setText(res.getString("id"));
                labelnumber.setText(res.getString("number"));
                labelname.setText(res.getString("name"));
                labelphone.setText(res.getString("phone"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        checkprice = new JButton("Check Price");
        checkprice.setBounds(30,450,120,25);
        checkprice.setBackground(Color.black);
        checkprice.setForeground(Color.white);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(165,450,120,25);
        bookpackage.setBackground(Color.black);
        bookpackage.setForeground(Color.white);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBounds(300,450,120,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkprice){
            String pack =cpackage.getSelectedItem();
            int cost=0;
            
            if(pack.equals("GOLD PACKAGE")){
                cost+=12000;
            }else if(pack.equals("SILVER PACKAGE")){
                cost+=24000;
            }else{
                cost+=32000;
            }
            
            int persons = Integer.parseInt(tfperson.getText());
            cost *=persons;
            labelprice.setText("Rs "+cost);
        }else if(ae.getSource() == bookpackage) {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labeluser.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Package Booked");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookPackage("Satpal123");
      }
}
