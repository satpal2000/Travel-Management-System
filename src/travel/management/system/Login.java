package travel.management.system;
    
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField tfuser,tfpassword;
    JButton login,signup,fpassword;
    
    Login(){
        setSize(900,400);           
        setLocation(280,200);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100,120,200,200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        
        JLabel user = new JLabel("Username");
        user.setBounds(60,20,100,25);
        user.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        p2.add(user);
        
        tfuser = new JTextField();
        tfuser.setBounds(60,60,300,30);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfuser);
        
        JLabel password = new JLabel("Password");
        password.setBounds(60,100,100,25);
        password.setFont(new Font("SAN SERIF",Font.PLAIN,20));
        p2.add(password);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(60,140,300,30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);
        
        login = new JButton("Login");
        login.setBounds(60,200,150,25);
        login.setBackground(new Color(131,193,233));
        login.setForeground(Color.white);
        login.setBorder(new LineBorder(new Color(131,193,233)));
        login.addActionListener(this);
        p2.add(login);
        
        signup = new JButton("SignUp");
        signup.setBounds(230,200,150,25);
        signup.setBackground(new Color(131,193,233));
        signup.setForeground(Color.white);
        signup.setBorder(new LineBorder(new Color(131,193,233)));
        signup.addActionListener(this);
        p2.add(signup);
        
        fpassword = new JButton("Forget Password");
        fpassword.setBounds(130,250,150,25);
        fpassword.setBackground(new Color(131,193,233));
        fpassword.setForeground(Color.white);
        fpassword.setBorder(new LineBorder(new Color(131,193,233)));
        fpassword.addActionListener(this);
        p2.add(fpassword);
        
        JLabel text = new JLabel("Trouble in Login..");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.red);
        p2.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() == login){
                try{
                    String username = tfuser.getText();
                    String password = tfpassword.getText();
                    
                    String query = "select * from account where username = '"+username+"' AND password = '"+password+"' ";
                    Conn c = new Conn();
                    ResultSet rs= c.s.executeQuery(query);
                    if(rs.next())
                    {
                        setVisible(false);
                        new Loading(username);
                    }else {
                        JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource() == signup){
                setVisible(false);
                new SignUp();
            }else {
                setVisible(false);
                new ForgetPassword();
            }
    }
    
    
    public static void main(String[] args)
    {
        new Login();
        
    }
    
}
