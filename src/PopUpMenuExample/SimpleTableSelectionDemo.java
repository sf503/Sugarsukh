package PopUpMenuExample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SimpleTableSelectionDemo extends JFrame{
    
    private Boolean DEBUG = false;
    private Boolean ALLOW_COLUMN_SELECTION = true;
    private Boolean ALLOW_ROW_SELECTION = true;
    
    public SimpleTableSelectionDemo()
    {
        super("SimpleTableSelectionDemo");
        Object[][] data=
        {
            {"Mary","Compione","Showboarding",      new Integer(5), new Boolean(false)},
            {"Alison","Huml","Rowing",              new Integer(3), new Boolean(true)},
            {"Kathy","Walrath","Chasing toddlers",  new Integer(2), new Boolean(false)},
            {"Mark","Andrews","Speed reading",      new Integer(20),new Boolean(true)},
            {"Angela","Lih","Teaching high school", new Integer(4), new Boolean(false)}
        };
        String[] columnNames={"First Name","Last Name","Sport","# of Years","Vegetarian"};
        final JTable table = new JTable(data, columnNames);
        JScrollPane pane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(500,70));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        if(ALLOW_ROW_SELECTION)
        {
            ListSelectionModel rowSH = table.getSelectionModel();
            rowSH.addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    
                    if(e.getValueIsAdjusting())
                        return;
                    ListSelectionModel lsm = ( ListSelectionModel) 
                        e.getSource();
                    if(lsm.isSelectionEmpty())
                    {
                        System.out.println("No rows are selected");
                    }
                    else
                    {
                        int selectedRow = lsm.getMinSelectionIndex();
                        System.out.println("Row "+selectedRow+" is now selected");
                    }
                }
            });
        }
        else
        {
            table.setRowSelectionAllowed(false);
        }
        if(ALLOW_COLUMN_SELECTION)
        {
            if(ALLOW_ROW_SELECTION)
            {
                table.setCellSelectionEnabled(true);
            }
            table.setColumnSelectionAllowed(true);
            ListSelectionModel colSN = table.getColumnModel().getSelectionModel();
            colSN.addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if(e.getValueIsAdjusting())
                        return;
                    ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                    if(lsm.isSelectionEmpty())
                    {
                        System.out.println("No columns are selected.");
                    }
                    else
                    {
                        int selectedCol = lsm.getMinSelectionIndex();
                        System.out.println("Column "+selectedCol+ " is now selected");
                    }
                }
            });
        }
        if(DEBUG)
        {
            table.addMouseListener(new MouseAdapter() 
            {
                public void mouseClicked( MouseEvent e)
                {
                    printDebugData(table);
                }
            });
        }
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() 
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
            
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
            System.out.println("-----------------------");
        }
        
    public static void main(String[] args) 
    {
        SimpleTableSelectionDemo framea = new SimpleTableSelectionDemo();
        framea.pack();
        framea.setVisible(true);
    }
}
