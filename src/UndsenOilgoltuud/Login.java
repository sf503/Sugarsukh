package UndsenOilgoltuud;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends Frame implements ActionListener
{
    String username = "root";
    String password = "";
    TextField t1,t2;
    Label l1,l2,l3,l4,l5,l6;
    Button b2,b3,b4;
    GridBagLayout gbl;
    GridBagConstraints gbc;
    Font f1,f2;
    public Login()
    {
        setBackground(Color.cyan);
        gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
        setLayout(gbl);
        l1 = new Label("Username",Label.CENTER);
        l2 = new Label("Password",Label.CENTER);
        t1 = new TextField(15);
        t2 = new TextField(15);
        t2.setEchoChar('*');
        b3 = new Button("Submit");
        b4 = new Button("Close");
        gbc.gridx=0;
        gbc.gridy=0;
        gbl.setConstraints(l1,gbc);
        add(l1);
        gbc.gridx=2;
        gbc.gridy=0;
        gbl.setConstraints(t1,gbc);
        add(t1);

        gbc.gridx=0;
        gbc.gridy=2;
        gbl.setConstraints(l2,gbc);
        add(l2);

        gbc.gridx=2;
        gbc.gridy=2;
        gbl.setConstraints(t2,gbc);
        add(t2);

        gbc.gridx=0;
        gbc.gridy=3;
        gbl.setConstraints(b3,gbc);
        add(b3);

        gbc.gridx=2;
        gbc.gridy=3;
        gbl.setConstraints(b4,gbc);
        add(b4);

        b3.addActionListener(this);
        b4.addActionListener(this);
    }


    public void actionPerformed(ActionEvent ae)
    {

        if(ae.getSource()==b4)
        {
            System.exit(0);
        }
        if(ae.getSource()==b3)
        {
            try {
                Connection conn;
                String dbuser = "root";
                String dbpassw = "123";
                                String databasename = "registration";
                String url = "jdbc:mysql://localhost/" + databasename;
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection (url, dbuser, dbpassw);
                Statement st = conn.createStatement();
                                String uid=t1.getText().toString();
                                String passw=t2.getText().toString();
                ResultSet res = st.executeQuery("SELECT * FROM user where userName='" + uid + "' and userPass='" + passw + "'");
                if (res.next()) {
                    JOptionPane.showMessageDialog(this,"Login Sucessfull.");
                } else{
                                        JOptionPane.showMessageDialog(this,"Invalid User Name/Passw");
                                }

                if((t1.getText().equals(username))&&(t2.getText().equals(password)))
                {

                }
                else
                {

                }
            }
            catch ( ClassNotFoundException e ) {
                JOptionPane.showMessageDialog(this,e.getMessage());
                }
            catch(SQLException e) {
                JOptionPane.showMessageDialog(this,"Sql Error");
            }

        }
    }

    public static void main(String arg[]){
    Login l1= new Login();
    l1.setVisible(true);
    l1.setSize(500,500);

    }
}