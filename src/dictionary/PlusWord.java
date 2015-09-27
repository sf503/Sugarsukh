package dictionary;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlusWord extends JFrame implements CenterConstant{

    public PlusWord() {
        
        super("Үг нэмэх талбар");
        setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        
        JLabel english = new JLabel("Англи үг:");
        english.setPreferredSize(new Dimension(100,20));
        add(english);
          
        JTextField engtext=new JTextField();
        engtext.setPreferredSize(new Dimension(150,20));
        add(engtext);
          
        JLabel mongoltxt=new JLabel("Монгол үг:");
        mongoltxt.setPreferredSize(new Dimension(100,20));
        add(mongoltxt);
          
        JTextField montext=new JTextField();
        montext.setPreferredSize(new Dimension(150,20));
        add(montext);
          
          
        JButton addbtn=new JButton("Нэмэх");
        addbtn.setPreferredSize(new Dimension(100,20));
        addbtn.addActionListener(ae->{
            String engValue=engtext.getText();
            String monValue=montext.getText();
            
            String query = "insert into words(engword, monword)" 
                            + "values('"+engValue+"','"+monValue+"')";
            DatabaseTools.runQuery(query);
            JOptionPane.showMessageDialog(null, "Амжилттай нэмэгдлээ.");
            this.dispose();
        });
        
        add(addbtn);
          
        JButton backbtn=new JButton("Буцах");
        backbtn.setPreferredSize(new Dimension(100,20));
        backbtn.addActionListener(e->{
            this.dispose();
        });
        add(backbtn);
          
        setBounds((screen_width-300)/2, (screen_height-300)/2, 300, 180);
        setVisible(true);
        setResizable(false);
    }
    
}