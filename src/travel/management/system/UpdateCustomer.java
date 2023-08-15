
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateCustomer extends JFrame implements ActionListener {
    
    JLabel user,id,number,labeluser,name,labelname,gender,country,address,email,phone;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone,tfid,tfgender;
    JButton add,back;
    
    UpdateCustomer(String username){
        setBounds(240,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel text = new JLabel("Update Customer Details");
        text.setBounds(40,5,300,25);
        text.setFont(new Font("Tahoma", Font.PLAIN,20));
        add(text);
        
        
        user = new JLabel("UserName");
        user.setBounds(30,50,150,25);
        add(user);
        
        labeluser = new JLabel();
        labeluser.setBounds(220,50,150,25);
        add(labeluser);
        
        id = new JLabel("ID");
        id.setBounds(30,90,150,25);
        add(id);
        
        tfid = new JTextField();
        tfid.setBounds(200,90,150,25);
        add(tfid);
        
        number = new JLabel("Number");
        number.setBounds(30,130,150,25);
        add(number);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200,130,150,25);
        add(tfnumber);
        
        name = new JLabel("Name");
        name.setBounds(30,170,150,25);
        add(name);
        
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        gender = new JLabel("Gender");
        gender.setBounds(30,210,150,25);
        add(gender);
        
        tfgender = new JTextField();
        tfgender.setBounds(200,210,150,25);
        add(tfgender);
        
        country = new JLabel("Country");
        country.setBounds(30,250,150,25);
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200,250,150,25);
        add(tfcountry);
        
        address = new JLabel("Address");
        address.setBounds(30,290,150,25);
        add(address);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,290,150,25);
        add(tfaddress);
        
        email = new JLabel("Email ID");
        email.setBounds(30,330,150,25);
        add(email);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,330,150,25);
        add(tfemail);
        
        phone = new JLabel("Phone Number");
        phone.setBounds(30,370,150,25);
        add(phone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200,370,150,25);
        add(tfphone);
        
        add = new JButton("Update");
        add.setBounds(70,430,100,25);
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(200,430,100,25);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(280, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,400);
        add(image);
        
        try{
            Conn c= new Conn();
            ResultSet res = c.s.executeQuery("select * from customer where username='"+username+"'");
            while(res.next()){
                labeluser.setText(res.getString("username"));
                labelname.setText(res.getString("name"));
                tfid.setText(res.getString("id"));
                tfnumber.setText(res.getString("number"));
                tfgender.setText(res.getString("gender"));
                tfcountry.setText(res.getString("country"));
                tfaddress.setText(res.getString("address"));
                tfphone.setText(res.getString("phone"));
                tfemail.setText(res.getString("email"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == add){
            String username = labeluser.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender= tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query = "update customer set username ='"+username+"', id ='"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+gender+"', country = '"+country+"', address = '"+address+"',email = '"+email+"', phone = '"+phone+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args){
            new UpdateCustomer("Satpal123");
    }

    
}
