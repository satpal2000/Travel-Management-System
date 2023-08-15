
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class ViewBookedHotel extends JFrame implements ActionListener{
    
    JLabel user,labeluser,id,labelid,number,labelnumber,labelname,
            labelphone,labelperson,labelprice,labeldays,labelac,labelfood;
    JButton back;
    ViewBookedHotel(String username){
        setBounds(240,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setBounds(30,10,350,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
        
        user = new JLabel("UserName");
        user.setBounds(30,50,150,25);
        add(user);
        
        labeluser = new JLabel();
        labeluser.setBounds(220,50,150,25);
        add(labeluser);
        
        JLabel name = new JLabel("Hotel Name: ");
        name.setBounds(30,90,150,25);
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(220,90,150,25);
        add(labelname);
        
        JLabel person = new JLabel("Total Person");
        person.setBounds(30,130,150,25);
        add(person);
        
        labelperson = new JLabel();
        labelperson.setBounds(220,130,150,25);
        add(labelperson);
        
        id = new JLabel("ID");
        id.setBounds(30,170,150,25);
        add(id);
        
        labelid = new JLabel();
        labelid.setBounds(220,170,150,25);
        add(labelid);
        
        number = new JLabel("Number");
        number.setBounds(30,210,150,25);
        add(number);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220,210,150,25);
        add(labelnumber);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(30,250,150,25);
        add(phone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220,250,150,25);
        add(labelphone);
        
        JLabel days = new JLabel("Total Days:");
        days.setBounds(30,290,150,25);
        add(days);
        
        labeldays = new JLabel();
        labeldays.setBounds(220,290,150,25);
        add(labeldays);
        
        JLabel ac = new JLabel("AC Included?");
        ac.setBounds(30,330,150,25);
        add(ac);
        
        labelac = new JLabel();
        labelac.setBounds(220,330,150,25);
        add(labelac);
        
        JLabel food = new JLabel("Food Included?");
        food.setBounds(30,370,150,25);
        add(food);
        
        labelfood = new JLabel();
        labelfood.setBounds(220,370,150,25);
        add(labelfood);
        
        JLabel price = new JLabel("Price");
        price.setBounds(30,410,150,25);
        add(price);
        
        labelprice = new JLabel();
        labelprice.setBounds(220,410,150,25);
        add(labelprice);
        
        back = new JButton("Back");
        back.setBounds(100,450,100,25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,20,400,500);
        add(image);
        
        try{
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '"+username+"'";
            ResultSet res = c.s.executeQuery(query);
            
            while(res.next()){
                labeluser.setText(res.getString("username"));
                labelname.setText(res.getString("name"));
                labelid.setText(res.getString("id"));
                labelnumber.setText(res.getString("number"));
                labelphone.setText(res.getString("phone"));
                labelperson.setText(res.getString("persons"));
                labelprice.setText(res.getString("price"));
                labelac.setText(res.getString("ac"));
                labelfood.setText(res.getString("food"));
                labeldays.setText(res.getString("days"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
       setVisible(false);
    }
    public static void main(String[] args){
        new ViewBookedHotel("satpal123");
    }

    
}
