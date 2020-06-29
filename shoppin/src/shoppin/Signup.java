/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppin;

/**
 *
 * @author NORTH KOREAN HOMIE
	// change package names and other editable stuffs, :) 
 */
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Signup extends JFrame implements ActionListener{
 JLabel l1, user, pswd, name, email, phoneno, address;
 JTextField namef,userf,emailf, phonef, addressf;
 JButton btn1, btn2;
 JPasswordField pswf;
 Signup() {
  JFrame frame = new JFrame(" Signup ");
  l1 = new JLabel("Signup Form");
  l1.setForeground(Color.blue);
  l1.setFont(new Font("Arial", Font.BOLD, 28));
  name = new JLabel("Name : ");
  user = new JLabel("Username : ");
  pswd = new JLabel("Password : ");
  email= new JLabel("E-mail : ");
  phoneno = new JLabel("Phone no : ");
  address = new JLabel("Address : ");
  namef = new JTextField();
  userf = new JTextField();
  pswf = new JPasswordField();
  emailf = new JTextField();
  phonef = new JTextField();
  addressf = new JTextField();
  
  btn1=new JButton("Sign Up");
  btn2=new JButton("Back");
  l1.setBounds(300, 30, 400, 30);
  name.setBounds(80, 70, 200, 30);
  user.setBounds(80, 110, 200, 30);
  pswd.setBounds(80, 150, 200, 30);
  email.setBounds(80, 190, 200, 30);
  phoneno.setBounds(80, 230, 200, 30);
  address.setBounds(80, 270, 200, 30);
  namef.setBounds(300, 70, 200, 30);
  userf.setBounds(300, 110, 200, 30);
  pswf.setBounds(300, 150, 200, 30);
  emailf.setBounds(300,190,200,30);
  phonef.setBounds(300,230,200,30);
  addressf.setBounds(300,270,200,30);
  btn1.setBounds(350, 340, 100, 30);
  btn2.setBounds(350, 400, 100, 30);
  
   
  
  frame.add(l1);
  frame.add(name);
  frame.add(user);
  frame.add(email);
  frame.add(phoneno);
  frame.add(address);
  frame.add(namef);

  frame.add(pswd);
  frame.add(userf);
  frame.add(pswf);
  frame.add(emailf);
  frame.add(phonef);
  frame.add(addressf);
  frame.add(btn1);
  frame.add(btn2);

  frame.setSize(800, 800);
  frame.setLayout(null);
  frame.setBackground(Color.yellow);
  frame.setVisible(true);
  btn1.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent Ae){
         try
    {
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/shopping";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
    
      // create a sql date object so we can use it in our INSERT statement
  
      String chkquery=" SELECT * FROM users WHERE Name=?";
      PreparedStatement chkstate= conn.prepareStatement(chkquery);
      chkstate.setString(1,userf.getText());
      ResultSet rs=chkstate.executeQuery();
      if(rs.next()){
           
      
      // the mysql insert statement
      String query = " INSERT INTO users (Name, Username, Password, Email, Address, Phone)"
        + " values (?, ?, ?, ?, ?, ?)";

      // create the mysql insert preparedstatement
      PreparedStatement preparedStmt = conn.prepareStatement(query);
      preparedStmt.setString(1, namef.getText());
      preparedStmt.setString(2, userf.getText());
      preparedStmt.setString(3, new String(pswf.getPassword()));
      preparedStmt.setString(4, emailf.getText());
      preparedStmt.setString(5, addressf.getText());
      preparedStmt.setInt(6, Integer.parseInt(phonef.getText()));

      // execute the preparedstatement
      preparedStmt.execute();
      
      conn.close();
        }
      else{
          new ErrorSign();
      }
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
      }
  });
  btn2.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            frame.setVisible(false);
            dispose();
            new Login();
        }  
    });  
 }

 public static void main(String[] args) {
  new Signup();
 }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}