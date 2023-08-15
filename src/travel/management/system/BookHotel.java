 
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BookHotel extends JFrame implements ActionListener{
    JLabel user,labeluser,number,labelnumber,labelid,labelphone,labelprice;
    Choice chotel,cac,cfood;
    JTextField tfperson,tfdays;
    String username;
    JButton checkprice,bookpackage,back;
            
    BookHotel(String username){
        this.username=username;
        
        setBounds(240,100,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel l1 = new JLabel("BOOK Hotel");
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
        
        JLabel lpackage = new JLabel("Select Hotel");
        lpackage.setBounds(30,90,150,25);
        lpackage.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lpackage);
        
        chotel = new Choice();
        chotel.setBackground(Color.white);
        chotel.setBounds(220,90,150,30);
        add(chotel);
        
        try{
            Conn c =new Conn();
            ResultSet rs  = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel person = new JLabel("Total Person");
        person.setBounds(30,130,150,25);
        person.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(person);
        
        tfperson = new JTextField("1");
        tfperson.setBounds(220,130,150,25);
        add(tfperson);
        
        JLabel days = new JLabel("No. of Days: ");
        days.setBounds(30,170,150,25);
        days.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(days);
        
        tfdays = new JTextField();
        tfdays.setBounds(220,170,150,25);
        tfdays.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(tfdays);
        
        JLabel id = new JLabel("ID");
        id.setBounds(30,210,150,25);
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(id);
        
        labelid = new JLabel();
        labelid.setBounds(220,210,200,25);
        labelid.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelid);
        
        number = new JLabel("Number");
        number.setBounds(30,250,150,25);
        number.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(number);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(220,250,150,25);
        labelnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelnumber);
        
        JLabel phone = new JLabel("Phone Number");
        phone.setBounds(30,290,200,25);
        phone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(phone);
        
        labelphone = new JLabel();
        labelphone.setBounds(220,290,200,25);
        labelphone.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelphone);
        
        JLabel ac = new JLabel("AC/Non-AC: ");
        ac.setBounds(30,330,150,25);
        ac.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(ac);
        
        cac = new Choice();
        cac.setBounds(220,330,150,25);
        cac.add("AC");
        cac.add("Non-AC");
        add(cac);
        
        JLabel food = new JLabel("Food Included: ");
        food.setBounds(30,370,150,25);
        food.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(food);
        
        cfood = new Choice();
        cfood.setBounds(220,370,150,25);
        cfood.add("Yes");
        cfood.add("No");
        add(cfood);
        
        JLabel price = new JLabel("Total Price");
        price.setBounds(30,410,200,25);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);
        
        labelprice = new JLabel();
        labelprice.setBounds(220,410,200,25);
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
        
        bookpackage = new JButton("Book Hotel");
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,500,300);
        add(image);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == checkprice){
            try{    
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '"+chotel.getSelectedItem()+"'");
                while(rs.next()){
                    int cost = Integer.parseInt(rs.getString("costperperson"));
                    int food = Integer.parseInt(rs.getString("foodincluded"));
                    int ac = Integer.parseInt(rs.getString("acroom"));
                    
                    int persons = Integer.parseInt(tfperson.getText());
                    int days = Integer.parseInt(tfdays.getText());
                    
                    String acselected = cac.getSelectedItem();
                    String foodselected = cfood.getSelectedItem();
                    
                    if(persons * days > 0) {
                        int total = 0;
                        total += acselected.equals("AC") ? ac : 0;
                        total += foodselected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelprice.setText("Rs"+total);
                    }else{
                        JOptionPane.showMessageDialog(null,"Please Enter a valid number");
                    }
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }    
                
        }else if(ae.getSource() == bookpackage) {
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labeluser.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelprice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Hotel Booked");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new BookHotel("");
      }
}
