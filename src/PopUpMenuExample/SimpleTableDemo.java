package PopUpMenuExample;

import burtgel.DatabaseTools;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTableDemo extends JFrame{
    
    private boolean DEBUG = true;
    
    public SimpleTableDemo(){
        super("SIMPLE TABLE DEMO");
        
        ResultSet rs = DatabaseTools.runQuery("SELECT * FROM user");
        
        Object[][] data;
        String[] columnNames={"Id","Name","Password"};
        int rowSize = 0;
        try {
            rs.last();
            rowSize = rs.getRow();
            rs.beforeFirst();
        }
        catch(Exception ex) {

        }
        
        try
        {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnSize = rsmd.getColumnCount();
            /////////////////////////////////////

            data = new Object[rowSize][columnSize];

            int i =0;
            while(rs.next() && i < rowSize)
            {
                data[i][0] = rs.getInt("user_id");  
                data[i][1] = rs.getString("userName");  
                data[i][2] = rs.getString("userPass");
                i++;
            }
            
            final JTable table = new JTable(data, columnNames);
            JScrollPane pane = new JScrollPane(table);
            table.setPreferredScrollableViewportSize(new Dimension(500,70));
            if(DEBUG)
            {
                table.addMouseListener(new MouseAdapter() 
                {
                    public void mouseClicked(MouseEvent e)
                    {
                        printDebugData(table);
                    }
                });
            }
            add(pane);
        
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        
    }
            
    private void printDebugData(JTable table)
        {
            int numRows = table.getRowCount();
            int numCols = table.getColumnCount();
            
            javax.swing.table.TableModel model = table.getModel();
            System.out.println("Value of data: " );
            for(int i=0; i<numRows; i++)
            {
                System.out.println("row "+i+":");
                for(int j=0; j<numCols; j++)
                {
                    System.out.println(" "+model.getValueAt(i, j));
                }
                System.out.println();
            }
            System.out.println("----------------------");
        }
        
    public static void main(String[] args) 
    {
        SimpleTableDemo frame = new SimpleTableDemo();
        frame.pack();
        frame.setVisible(true);
    }
}
