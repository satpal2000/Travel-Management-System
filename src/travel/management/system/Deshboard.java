
package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Deshboard extends JFrame implements ActionListener{
    
    String username;
    JButton addPersonalDetails,viewPersonalDetails,updatePersonalDetails,checkpackages,
            bookpackages,viewpackages,viewhotels,destinations,bookhotel,viewbookedhotel,
            payments,calculator,notepad,about;
    
    Deshboard(String username){
        this.username=username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBounds(0,0,1600,65);
        p1.setBackground(new Color(0,0,102));
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);
        
        JLabel heading = new JLabel("DashBoard");
        heading.setBounds(80,10,300,30);
        heading.setForeground(Color.white);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);
        
        JPanel p2 = new JPanel();
        p2.setBounds(0,65,280,900);
        p2.setBackground(new Color(0,0,102));
        p2.setLayout(null);
        add(p2);
        
        addPersonalDetails = new JButton("Add Personal Details");
        addPersonalDetails.setBounds(0,0,300,40);
        addPersonalDetails.setBackground(new Color(0,0,102));
        addPersonalDetails.setForeground(Color.white);
        addPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addPersonalDetails.setMargin(new Insets(0,0,0,60));
        addPersonalDetails.addActionListener(this);
        p2.add(addPersonalDetails);
        
        updatePersonalDetails = new JButton("Update Personal Details");
        updatePersonalDetails.setBounds(0,39,300,40);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.white);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        p2.add(updatePersonalDetails);
        
        viewPersonalDetails = new JButton("View Details");
        viewPersonalDetails.setBounds(0,78,300,40);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.white);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,130));
        viewPersonalDetails.addActionListener(this);
        p2.add(viewPersonalDetails);
        
        JButton deletePersonalDetails = new JButton("Delete Personal Details");
        deletePersonalDetails.setBounds(0,117,300,40);
        deletePersonalDetails.setBackground(new Color(0,0,102));
        deletePersonalDetails.setForeground(Color.white);
        deletePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletePersonalDetails.setMargin(new Insets(0,0,0,40));
        p2.add(deletePersonalDetails);
        
        checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0,156,300,40);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);
        
        bookpackages = new JButton("Book Package");
        bookpackages.setBounds(0,195,300,40);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,110));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);
        
        viewpackages = new JButton("View Package");
        viewpackages.setBounds(0,234,300,40);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.white);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,110));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);
        
        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,273,300,40);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);
        
        bookhotel = new JButton("Book Hotel");
        bookhotel.setBounds(0,312,300,40);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.white);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,140));
        bookhotel.addActionListener(this);
        p2.add(bookhotel);
        
        viewbookedhotel = new JButton("View Booked Hotel");
        viewbookedhotel.setBounds(0,351,300,40);
        viewbookedhotel.setBackground(new Color(0,0,102));
        viewbookedhotel.setForeground(Color.white);
        viewbookedhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookedhotel.setMargin(new Insets(0,0,0,70));
        viewbookedhotel.addActionListener(this);
        p2.add(viewbookedhotel);
        
        destinations = new JButton("Destinations");
        destinations.setBounds(0,390,300,40);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,130));
        destinations.addActionListener(this);
        p2.add(destinations);
        
        payments = new JButton("Payments");
        payments.setBounds(0,429,300,40);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,160));
        payments.addActionListener(this);
        p2.add(payments);
        
        calculator = new JButton("Calculator");
        calculator.setBounds(0,468,300,40);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,160));
        calculator.addActionListener(this);
        p2.add(calculator);
        
        notepad = new JButton("NotePad");
        notepad.setBounds(0,507,300,40);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,170));
        notepad.addActionListener(this);
        p2.add(notepad);
        
        about = new JButton("About");
        about.setBounds(0,546,300,40);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.white);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,190));
        about.addActionListener(this);
        p2.add(about);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);
        
        JLabel text = new JLabel("Travel And Tourism Management System");
        text.setBounds(400,70,1000,70);
        text.setFont(new Font("Raleway",Font.BOLD,40));
        text.setForeground(Color.white);
        image.add(text);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == addPersonalDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == viewPersonalDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == updatePersonalDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == checkpackages){
            new CheckPackage();
        }else if(ae.getSource() == bookpackages) {
            new BookPackage(username);
        }else if(ae.getSource() == viewpackages) {
            new ViewPackage(username);
        }else if(ae.getSource() == viewhotels) {
            new CheckHotel();
        }else if(ae.getSource() == destinations) {
            new Destinations();
        }else if(ae.getSource() == bookhotel) {
            new BookHotel("username");
        }else if(ae.getSource() == viewbookedhotel) {
            new ViewBookedHotel("username");
        }else if(ae.getSource() == payments) {
            new Payment();
        }else if(ae.getSource() == calculator) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == notepad) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == about) {
            new About();
        }
        
    }
    public static void main(String [] args){
        new Deshboard("");
    }

    
    
}
