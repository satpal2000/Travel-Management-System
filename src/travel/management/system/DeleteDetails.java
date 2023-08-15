
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class DeleteDetails extends JFrame implements ActionListener{
    
    JLabel user,labeluser,id,labelid,number,labelnumber,labelname,name,gender,labelgender,country,
            labelcountry,labeladdress,address,labelphone,labelemail;
    JButton back;
    String username;
    DeleteDetails(String username){
        setBounds(240,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        user = new JLabel("UserName");
        user.setBounds(30,50,150,25);
        add(user);
        
        labeluser = new JLabel();
        labeluser.setBounds(220,50,150,25);
        add(labeluser);
        
        id = new JLabel("ID");
        id.setBounds(30,90,150,25);
        add(id);
        
        labelid = new JLabel();
        labelid.setBounds(220,90,150,25);
        add(labelid);
        
        number = new JLabel("Number");
        number.setBounds(30,130,150,25);
        add(number);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220,130,150,25);
        add(labelnumber);
        
        name = new JLabel("Name");
        name.setBounds(30,170,150,25);
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);
        
        labelgender = new JLabel();
        labelgender.setBounds(220,210,150,25);
        add(labelgender);
        
        country = new JLabel("Country");
        country.setBounds(500,50,150,25);
        add(country);
        
        labelcountry = new JLabel();
        labelcountry.setBounds(700,50,150,25);
        add(labelcountry);
        
        address = new JLabel("Address");
        address.setBounds(500,90,150,25);
        add(address);
        
        labeladdress = new JLabel();
        labeladdress.setBounds(700,90,150,25);
        add(labeladdress);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(500,130,150,25);
        add(phone);
        
        labelphone = new JLabel();
        labelphone.setBounds(700,130,150,25);
        add(labelphone);
        
        JLabel email = new JLabel("Email ID");
        email.setBounds(500,170,150,25);
        add(email);
        
        labelemail = new JLabel();
        labelemail.setBounds(700,170,150,25);
        add(labelemail);
        
        back = new JButton("Delete");
        back.setBounds(300,250,100,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20,330,600,200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(600,330,600,200);
        add(image2);
        
        try{
            Conn c = new Conn();
            String query = "select * from customer where username = '"+username+"'";
            ResultSet res = c.s.executeQuery(query);
            
            while(res.next()){
                labeluser.setText(res.getString("username"));
                labelid.setText(res.getString("id"));
                labelnumber.setText(res.getString("number"));
                labelname.setText(res.getString("name"));
                labelgender.setText(res.getString("gender"));
                labelcountry.setText(res.getString("country"));
                labeladdress.setText(res.getString("address"));
                labelphone.setText(res.getString("phone"));
                labelemail.setText(res.getString("email"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
       try{
           Conn c = new Conn();
           c.s.executeUpdate("delete from account where username = '"+username+"' ");
           c.s.executeUpdate("delete from customer where username = '"+username+"' ");
           c.s.executeUpdate("delete from bookpackage where username = '"+username+"' ");
           c.s.executeUpdate("delete from bookhotel where username = '"+username+"' ");
           
           JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
           
           System.exit(0);
       }catch(Exception e){
           e.printStackTrace();
       }
        
        setVisible(false);
    }
    public static void main(String[] args){
        new DeleteDetails("Satpal3432");
    }

    
}
