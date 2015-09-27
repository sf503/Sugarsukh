package burtgel;

import PopUpMenuExample.SimpleTableDemo;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class UndsenTsonh extends JFrame implements BurtgelInterface{
    
    private boolean DEBUG = true;
    
    public UndsenTsonh()
    {
        super("Үндсэн цонх");
        Container con = getContentPane();
        con.setLayout(null);
        
        JButton nemeh = new JButton("Бүртгэл нэмэх");
        JButton hasah = new JButton("Бүртгэл хасах");
        JButton harah = new JButton("Бүртгэл харах");
        
        harah.setBounds(100,50,250,30);
        nemeh.setBounds(400,50,250,30);
        hasah.setBounds(700,50,250,30);

        con.add(harah);
        con.add(nemeh);
        con.add(hasah);
        
        nemeh.addActionListener(ae->{
            new BurtgehHuudas();
        });
        setBounds((screen_width-900)/2, (screen_height-700)/2, 1050, 700);
        setVisible(true);
        setResizable(false);
        
        harah.addActionListener(ae->{
            new SimpleTableDemo();
        });
        
        
    }
    
    public static void main(String[] args) {
        UndsenTsonh ts= new UndsenTsonh();
        ts.setDefaultCloseOperation(2);
    }
}
