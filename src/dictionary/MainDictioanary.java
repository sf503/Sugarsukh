package dictionary;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MainDictioanary extends JFrame implements CenterConstant{
    
    JMenuItem edit, delete;
    JPopupMenu popUp;
    int dugaar;
    
    public MainDictioanary(){
        
        
        super("Толь бичиг");
        setLayout(new FlowLayout(FlowLayout.CENTER,5,15));
        JTextArea a=new JTextArea();
        a.setEditable(false);
        
        edit = new JMenuItem("Засах", new ImageIcon("zasah.png"));
        edit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        edit.addActionListener(e->{
            new EditWord(dugaar);
        });
        
        delete = new JMenuItem("Устгах", new ImageIcon("delete.png"));
        delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, InputEvent.CTRL_MASK));
        delete.addActionListener(e->{
            
            String ustgah="delete from words where word_id="+dugaar+"";
            DatabaseTools.runQuery(ustgah);
            JOptionPane.showMessageDialog(null, "Амжилттай устлаа.");
        });
        
        popUp = new JPopupMenu();
        popUp.add(edit);
        popUp.add(delete);
        
        a.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                if(e.isPopupTrigger())
                {
                    popUp.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
        
        
        JRadioButton english =new JRadioButton("English-Mongolia");
        english.setPreferredSize(new Dimension(120,20));
        english.setSelected(true);
        add(english);
        
        JRadioButton mongolia=new JRadioButton("Mongolia-English");
        english.setPreferredSize(new Dimension(160,20));
        add(mongolia);
        
        ButtonGroup group = new ButtonGroup();
        group.add(english);
        group.add(mongolia);
        
        JLabel searchlbl=new JLabel("Хайх үг:");
        searchlbl.setPreferredSize(new Dimension(50,20));
        add(searchlbl);
        
        JTextField field=new JTextField();
        field.setPreferredSize(new Dimension(150,20));
        add(field);
         
        JButton searchbtn=new JButton("хайх");
        searchbtn.setPreferredSize(new Dimension(80,20));
        
        searchbtn.addActionListener(e->{
        String searchWord,searchField;
         
        int colum1,colum2;
        searchWord=field.getText();
        if(english.isSelected())
        {  
            searchField="engword";
            colum1=2;
            colum2=3;
        }
        else
        {
            searchField="monword";
            colum1=3;
            colum2=2;
        }
        String query="select * from words where "+searchField+" like '%"+searchWord+"%'";
        ResultSet result=DatabaseTools.runQuery(query);
        String exactWord="";
        try 
        {
            while(result.next())
            {
                if(searchWord.equalsIgnoreCase(result.getString(colum1)))
                {   
                    dugaar=result.getInt(1);
                    exactWord=result.getString(colum2);
                    System.out.println(exactWord);
                }
                else
                {
                    exactWord="Тийи үг олдсонгүй";
                }
            }
        } 
        catch (SQLException ex) 
        {
        }
        a.setText(exactWord);
        });
        add(searchbtn);
        
        JScrollPane scroll=new JScrollPane(a);
        scroll.setPreferredSize(new Dimension(300,150));
        add(scroll);
         
        JButton addbtn=new JButton("Шинэ үг нэмэх");
        addbtn.setPreferredSize(new Dimension(120,20));
        addbtn.addActionListener(e-> {
            new PlusWord();
        });
        add(addbtn);
         
        setSize(350,350);
        setLocation(200,200);
        setResizable(false);
        setVisible(true);
    }
    
    public static void main(String[] args) {
         MainDictioanary ap=new MainDictioanary();
         ap.setDefaultCloseOperation(2);
    }
}