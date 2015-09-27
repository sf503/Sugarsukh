package burtgel;

import java.awt.Color;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.security.sasl.Sasl;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;


public class BurtgehHuudas extends JFrame {
    
    
    
    public BurtgehHuudas(){
    
        super("Бүртгэл хуудас");
        
        Container con= getContentPane();
        con.setLayout(null);
        
        //haryalagdah tenhim
        JLabel lbl1= new JLabel("Харъяалагдах тэнхим:");
        lbl1.setLocation(30, 30);
        lbl1.setSize(200, 30);
        con.add(lbl1);
        
        JComboBox combo1=new JComboBox();
        try
        { 
            String s = "SELECT * FROM tenhim"; 
            ResultSet rs = DatabaseTools.runQuery(s); 
            while(rs.next()) 
            { 
                combo1.addItem(rs.getString(2)); 
            } 
        }
        catch(Exception e)
        { 
        }
        
        combo1.setLocation(200, 30);
        combo1.setSize(200, 30);
        con.add(combo1);
        
        JLabel lb1= new JLabel("Сонгоно уу?");
        lb1.setLocation(450, 30);
        lb1.setSize(200, 30);
        con.add(lb1);
        
        
        //oyutanii code
        JLabel lbl2=new JLabel("Код:");
        lbl2.setLocation(30,70);
        lbl2.setSize(200,30);
        con.add(lbl2);
        
        JTextField txt1 = new JTextField();
        txt1.setLocation(200, 70);
        txt1.setSize(200, 30);
        
        
        con.add(txt1);
        
        JLabel lb2=new JLabel("Жишээ нь:SW001");
        lb2.setLocation(450,70);
        lb2.setSize(200,30);
        con.add(lb2);
        
        //oyutanii ovog
        JLabel lbl3=new JLabel("Овог:");
        lbl3.setLocation(30, 110);
        lbl3.setSize(200,30);
        con.add(lbl3);
        
        JTextField txt2 = new JTextField();
        txt2.setLocation(200, 110);
        txt2.setSize(200, 30);
        con.add(txt2);
        
        JLabel lb3=new JLabel("18 тэмдэгт");
        lb3.setLocation(450, 110);
        lb3.setSize(200,30);
        con.add(lb3);
        
        //oyutanii ner
        JLabel lbl4=new JLabel("Нэр:");
        lbl4.setLocation(30, 150);
        lbl4.setSize(200,30);
        con.add(lbl4);
        
        JTextField txt3 = new JTextField();
        txt3.setLocation(200, 150);
        txt3.setSize(200, 30);
        con.add(txt3);
        
        JLabel lb4=new JLabel("18 тэмдэгт");
        lb4.setLocation(450, 150);
        lb4.setSize(200,30);
        con.add(lb4);
        
        //nuuts ug
        JLabel lbl5=new JLabel("Нууц үг:");
        lbl5.setLocation(30, 190);
        lbl5.setSize(200,30);
        con.add(lbl5);
        
        JPasswordField pass1=new JPasswordField();
        pass1.setLocation(200, 190);
        pass1.setSize(200,30);
        con.add(pass1);
        
        JLabel lb5=new JLabel("Ихдээ 10 тэмдэгт");
        lb5.setLocation(450, 190);
        lb5.setSize(200,30);
        con.add(lb5);
        
        //nuuts ug davtalt
        JLabel lbl6=new JLabel("Нууц үг давталт:");
        lbl6.setLocation(30, 230);
        lbl6.setSize(200,30);
        con.add(lbl6);
        
        JPasswordField pass2=new JPasswordField();
        pass2.setLocation(200, 230);
        pass2.setSize(200,30);
        con.add(pass2);
        
        //huis
        JLabel lbl7=new JLabel("Хүйс:");
        lbl7.setLocation(30, 270);
        lbl7.setSize(200,30);
        con.add(lbl7);
        
        JRadioButton rd1=new JRadioButton("Эр");
        rd1.setLocation(200, 270);
        rd1.setSize(50, 30);
        con.add(rd1);
        
        JRadioButton rd2=new JRadioButton("Эм");
        rd2.setLocation(260, 270);
        rd2.setSize(50, 30);
        con.add(rd2);
        
        ButtonGroup huisGroup = new ButtonGroup();
        huisGroup.add(rd1);
        huisGroup.add(rd2);
        
        
        JLabel lb7=new JLabel("Сонгодог байх");
        lb7.setLocation(450, 270);
        lb7.setSize(200,30);
        con.add(lb7);
        
        //elssen on
        JLabel lbl8=new JLabel("Элссэн он:");
        lbl8.setLocation(30, 310);
        lbl8.setSize(200,30);
        con.add(lbl8);
        
        JTextField txt5 = new JTextField();
        txt5.setLocation(200, 310);
        txt5.setSize(200, 30);
        con.add(txt5);
        
        JLabel lb8=new JLabel("Жишээ:2011");
        lb8.setLocation(450, 310);
        lb8.setSize(200,30);
        con.add(lb8);
        
        //tsagiin/undsen
        JLabel lbl9=new JLabel("Цагийн/Үндсэн:");
        lbl9.setLocation(30, 350);
        lbl9.setSize(200,30);
        con.add(lbl9);
        
        JCheckBox ch1=new JCheckBox("Цаг");
        ch1.setLocation(200, 340);
        ch1.setSize(50,50);
        con.add(ch1);
        
        JCheckBox ch2=new JCheckBox("Үндсэн");
        ch2.setLocation(250, 340);
        ch2.setSize(80,50);
        con.add(ch2);
        
        ButtonGroup checkgroup = new ButtonGroup();
        checkgroup.add(ch1);
        checkgroup.add(ch2);
        
        
        JLabel lb9=new JLabel("Олныг сонгож болох");
        lb9.setLocation(450, 350);
        lb9.setSize(200,30);
        con.add(lb9);
        
        //zereg
        JLabel lbl10=new JLabel("Зэрэг:");
        lbl10.setLocation(30, 390);
        lbl10.setSize(200,30);
        con.add(lbl10);
        
        JComboBox combo2=new JComboBox();
        
        try
        { 
            String s = "SELECT * FROM zereg"; 
            ResultSet rs = DatabaseTools.runQuery(s); 
            while(rs.next()) 
            { 
                combo2.addItem(rs.getString(2)); 
            } 
        }
        catch(Exception e)
        { 
        }
        combo2.setLocation(200, 390);
        combo2.setSize(200, 30);
        con.add(combo2);
        
        //torol
        JLabel lbl11=new JLabel("Төрөл:");
        lbl11.setLocation(30, 430);
        lbl11.setSize(200,30);
        con.add(lbl11);
        
        String str3[]={"Захирал","Бакалавр1","Бакалавр2","Бакалавр3","Бакалавр4",};
        JComboBox combo3=new JComboBox(str3);
        combo3.setLocation(200, 430);
        combo3.setSize(200, 30);
        con.add(combo3);
        
        //geriin utas
        JLabel lbl12=new JLabel("Гэрийн утас:");
        lbl12.setLocation(30, 470);
        lbl12.setSize(200,30);
        con.add(lbl12);
        
        JTextField txt6 = new JTextField();
        txt6.setLocation(200, 470);
        txt6.setSize(200, 30);
        con.add(txt6);
        
        JLabel lb12=new JLabel("Ихдээ 20 тэмдэгт");
        lb12.setLocation(450, 470);
        lb12.setSize(200,30);
        con.add(lb12);
        
        //gar utas
        JLabel lbl13=new JLabel("Гар утас:");
        lbl13.setLocation(30, 510);
        lbl13.setSize(200,30);
        con.add(lbl13);
        
        JTextField txt7 = new JTextField();
        txt7.setLocation(200, 510);
        txt7.setSize(200, 30);
        con.add(txt7);
        
        JLabel lb13=new JLabel("Ихдээ 20 тэмдэгт");
        lb13.setLocation(450, 510);
        lb13.setSize(200,30);
        con.add(lb13);
        
        //geriin hayag
        JLabel lbl14=new JLabel("Гэрийн хаяг:");
        lbl14.setLocation(30, 550);
        lbl14.setSize(200,30);
        con.add(lbl14);
        
        JTextArea ta1=new JTextArea();
        ta1.setLocation(200, 550);
        ta1.setSize(250, 90);
        con.add(ta1);
        
        JLabel lb14=new JLabel("Ихдээ 200 тэмдэгт");
        lb14.setLocation(500, 550);
        lb14.setSize(200,30);
        con.add(lb14);
        
        //mail hayag
        JLabel lbl15=new JLabel("Майл хаяг:");
        lbl15.setLocation(30, 650);
        lbl15.setSize(200,30);
        con.add(lbl15);
        
        JTextField txt8 = new JTextField();
        txt8.setLocation(200, 650);
        txt8.setSize(200, 30);
        con.add(txt8);
        
        JLabel lb15=new JLabel("Ихдээ 100 тэмдэгт");
        lb15.setLocation(450, 650);
        lb15.setSize(200,30);
        con.add(lb15);
        
        //torson odor
        JLabel lbl16=new JLabel("Төрсөн өдөр:");
        lbl16.setLocation(30, 690);
        lbl16.setSize(200,30);
        con.add(lbl16);
        
        String year1[]=new String[116];
        for(int on=0;on<116;on++)
        {
           year1[on]=Integer.toString(1900+on);
        }
        JComboBox year=new JComboBox(year1);
        year.setMaximumRowCount(8);
        year.setLocation(200, 690);
        year.setSize(60, 30);
        con.add(year);
        
        JLabel lbl161=new JLabel("Он");
        lbl161.setLocation(265, 690);
        lbl161.setSize(30,30);
        con.add(lbl161);
        
        String month1[]=new String[12];
        for(int sar=0;sar<12;sar++)
        {
           month1[sar]=Integer.toString(1+sar);
        }
        JComboBox month=new JComboBox(month1);
        month.setMaximumRowCount(8);
        month.setLocation(290, 690);
        month.setSize(60, 30);
        con.add(month);
        
        JLabel lbl162=new JLabel("Сар");
        lbl162.setLocation(355, 690);
        lbl162.setSize(30,30);
        con.add(lbl162);
        
        String day1[]=new String[31];
        for(int odor=0;odor<31;odor++)
        {
           day1[odor]=Integer.toString(1+odor);
        }
        JComboBox day=new JComboBox(day1);
        day.setLocation(385, 690);
        day.setSize(60, 30);
        con.add(day);
        
        JLabel lbl163=new JLabel("Өдөр");
        lbl163.setLocation(450, 690);
        lbl163.setSize(50,30);
        con.add(lbl163);
        
        
        JLabel lb16=new JLabel("3-н combobox байх");
        lb16.setForeground(Color.red);
        lb16.setLocation(550, 690);
        lb16.setSize(200,30);
        con.add(lb16);
        
        //nemeh
        JButton bt1=new JButton("Нэмэх");
        bt1.setForeground(Color.blue);
        bt1.setLocation(600, 30);
        bt1.setSize(100, 40);
        bt1.addActionListener(ae->{
            String stuLastName = txt2.getText();
            String stuFirstName = txt3.getText();
            String huis;
            if(rd1.isSelected())
                huis="эр";
            else
                huis="эм";
            String elssenOn = txt5.getText();
            String address = ta1.getText();
            String phone = txt7.getText();
            String mail= txt8.getText();
            String code = txt1.getText();
            
            String query1 = "insert into student(stu_lastname, stu_firstname,stu_sex,stu_elssenOn,stu_address,stu_phone,stu_mail,stu_code)"
                            +"values('"+stuLastName+"','"+stuFirstName+"','"+huis+"','"+elssenOn+"','"+address+"','"+phone+"','"+mail+"','"+code+"')";
            DatabaseTools.runQuery(query1);
            JOptionPane.showMessageDialog(null, "Амжилттай нэмэгдлээ.");
            this.dispose();
        });
        con.add(bt1);
        
        
        //tseverleh
        JButton bt4=new JButton("Цэвэрлэх");
        bt4.setForeground(Color.blue);
        bt4.setLocation(600, 180);
        bt4.setSize(100, 40);
        con.add(bt4);
        

        setLocation(800, 350);
        setSize(750, 800);
        setVisible(true);
        setResizable(false);
    }
}