
package travel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfuser,tfname,tfquestion,tfanswer,tfpssword;
    JButton search,retrieve,back;
    
    ForgetPassword(){
        setBounds(250,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,280);
        add(p1);
        
        JLabel user = new JLabel("Username");
        user.setBounds(20,20,200,20);
        user.setFont(new Font("SAN SERIF",Font.PLAIN,16));
        p1.add(user);
        
        tfuser = new JTextField();
        tfuser.setBounds(180,20,150,25);
        tfuser.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfuser);
        
        search = new JButton("Search");
        search.setBackground(Color.gray);
        search.setForeground(Color.white);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        p1.add(search);
        
        JLabel name = new JLabel("Name");
        name.setBounds(20,60,200,20);
        name.setFont(new Font("SAN SERIF",Font.PLAIN,16));
        p1.add(name);
        
        tfname = new JTextField();
        tfname.setBounds(180,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel question = new JLabel("Security Question");
        question.setBounds(20,100,150,20);
        question.setFont(new Font("SAN SERIF",Font.PLAIN,16));
        p1.add(question);
        
        tfquestion = new JTextField();
        tfquestion.setBounds(180,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfquestion);
        
        JLabel answer = new JLabel("Answer");
        answer.setBounds(20,140,150,20);
        answer.setFont(new Font("SAN SERIF",Font.PLAIN,16));
        p1.add(answer);
        
        tfanswer = new JTextField();
        tfanswer.setBounds(180,140,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.gray);
        retrieve.setForeground(Color.white);
        retrieve.setBounds(380,140,100,25);
        retrieve.addActionListener(this);
        p1.add(retrieve);
        
        JLabel password = new JLabel("Password");
        password.setBounds(20,180,150,20);
        password.setFont(new Font("SAN SERIF",Font.PLAIN,16));
        p1.add(password);
        
        tfpssword = new JTextField();
        tfpssword.setBounds(180,180,150,25);
        tfpssword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpssword);
        
        back = new JButton("Back");
        back.setBackground(Color.gray);
        back.setForeground(Color.white);
        back.setBounds(150,230,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == search){
            try{
                String query = "select * from account where username = '"+tfuser.getText()+"'";
                Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    tfname.setText(rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfuser.getText()+"'";
                Conn c = new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next()){
                    tfpssword.setText(rs.getString("password"));
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
    
   public static void main(String[] args){
       new ForgetPassword();
   }
   
}
