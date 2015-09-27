package burtgel;

import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainBurtgel extends JFrame implements BurtgelInterface{
    
    public MainBurtgel()
    {
        super("Нэвтрэх цонх");
        //setLayout(new FlowLayout(FlowLayout.CENTER,5,15));
        
        Container con = getContentPane();
        con.setLayout(null);
        
        JLabel lblUser = new JLabel("Хэрэглэгчийн нэр :");
        JLabel lblPass = new JLabel("Нууц үг :");
        
        JTextField txtUser = new JTextField();
        JPasswordField pass = new JPasswordField();
        
        JButton nevtreh = new JButton("Нэвтрэх");
        
        lblUser.setBounds(10,10,130,20);
        lblPass.setBounds(10,30,130,20);
        txtUser.setBounds(130,10,130,20);
        pass.setBounds(130,30,130,20);
        nevtreh.setBounds(130,60,130,20);
        
        con.add(lblUser);
        con.add(lblPass);
        con.add(txtUser);
        con.add(pass);
        con.add(nevtreh);
        
        nevtreh.addActionListener(ae->
        {
            String userName = txtUser.getText();
            char[] Pass  = pass.getPassword();
            String userPass = String.copyValueOf(Pass);
            
            try 
            {
                ResultSet rs = DatabaseTools.runQuery("SELECT * FROM user where userName='" + userName + "' and userPass='" + userPass + "'");
                if (rs.next()) 
                {
                    new UndsenTsonh();
                    this.dispose();
                } 
                else
                {
                    JOptionPane.showMessageDialog(this,"Invalid User Name/Passw");
                }
            }
            catch(SQLException e)
            {
            }
            
            
        });
            
        setSize(280, 120);
        setLocation((screen_width-300)/2,(screen_height-300)/2);
        setVisible(true);
        setResizable(false);
        
    }
    public static void main(String[] args) 
    {
        MainBurtgel a = new MainBurtgel();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}