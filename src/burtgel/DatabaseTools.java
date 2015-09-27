package burtgel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DatabaseTools {
    
    public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public final static String DATABASE_URL = "jdbc:mysql://localhost/registration?useUnicode = yes&characterEncoding=UTF-8";
    
    public static Connection connect()
    {
        Connection connection = null;
        try
        {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DATABASE_URL,"root","123");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Амжилтгүй боллоо.");
        }
        return connection;
    }
    
    public static ResultSet runQuery(String query)
    {
        Connection con = connect();
        Statement st;
        ResultSet rs = null;
        try
        {
            st = con.createStatement();
            if( query.toLowerCase().startsWith("update") ||
                query.toLowerCase().startsWith("insert") ||
                query.toLowerCase().startsWith("delete"))
            {
                st.execute(query);
            }
            else
            {
                rs = st.executeQuery(query);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Таны мэдээлэл алдаатай байна.");
        }
        return rs;
    }
}
