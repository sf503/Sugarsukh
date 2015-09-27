import java.awt.Container;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*; 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Test extends JFrame{ 
    JComboBox jc = new JComboBox(); 
    JPanel panel = new JPanel(); 
    Connection con; 
    Statement st; 
    ResultSet rs; 
    public Test() { 
        this.setSize(400, 400); 
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        try
        { 
            con = DriverManager.getConnection("jdbc:mysql://localhost/registration","root","123"); 
            st = con.createStatement(); 
            String s = "SELECT * FROM tenhim"; 
            rs = st.executeQuery(s); 
            while(rs.next()) 
            { 
                jc.addItem(rs.getString(2)); 
            } 
        }
        catch(Exception e)
        { 
            JOptionPane.showMessageDialog(null, "ERROR"); 
        }
        finally
        { 
            try
            { 
                st.close(); 
                rs.close(); 
                con.close(); 
            }
            catch(Exception e)
            { 
                JOptionPane.showMessageDialog(null, "ERROR CLOSE"); 
            } 
        } 
        panel.add(jc); 
        this.getContentPane().add(panel); 
        this.setVisible(true); 
    }
    public static void main(String[] args)
    { 
        new Test(); 
    } 
}