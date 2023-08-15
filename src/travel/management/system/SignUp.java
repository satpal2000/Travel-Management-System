package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener{
    
    JButton create,back;
    JTextField tfuser,tfname,tfpassword,tfanswer;
    Choice csecurity;
    SignUp(){
        setBounds(200,200,900,360);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel user = new JLabel("Username");
        user.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        user.setBounds(50,20,125,25);
        p1.add(user);
        
        tfuser = new JTextField();
        tfuser.setBounds(190,20,180,25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuser);
        
        JLabel name = new JLabel("Name");
        name.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        name.setBounds(50,60,125,25);
        p1.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel password = new JLabel("Password");
        password.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        password.setBounds(50,100,125,25);
        p1.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel security = new JLabel("Security Questions");
        security.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        security.setBounds(50,140,125,25);
        p1.add(security);
        
        csecurity = new Choice();
        csecurity.add("Fav. Car ");
        csecurity.add("Your Lucky number");
        csecurity.add("Fav. Super Bike");
        csecurity.add("Your SuperHero");
        csecurity.setBounds(190,140,180,30);
        p1.add(csecurity);
        
        JLabel answer = new JLabel("Answer");
        answer.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        answer.setBounds(50,180,125,25);
        p1.add(answer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        create = new JButton("create");
        create.setBackground(Color.white);
        create.setForeground(new Color(131,193,233));
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.setBounds(80,250,100,30);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(new Color(131,193,233));
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setBounds(250,250,100,30);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource() == create){
             String username= tfuser.getText();
             String name= tfname.getText();
             String password= tfpassword.getText();
             String question = csecurity.getSelectedItem();
             String answer = tfanswer.getText();
             
             String query ="insert into account values('"+username+"', '"+name+"', '"+password+"','"+question+"', '"+answer+"')";
             try{
                 Conn c = new Conn();
                 c.s.executeUpdate(query);
                 
                 JOptionPane.showMessageDialog(null,"Account Created Succesfully");
                 
                 setVisible(false);
                 new Login();
             }catch(Exception e){
                 e.printStackTrace();
             }
         }else if(ae.getSource() == back){
             setVisible(false);
             new Login();
         }
    }
     
    public static void main(String[] args){
        new SignUp();
    }

    
}
