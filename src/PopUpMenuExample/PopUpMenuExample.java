package PopUpMenuExample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class PopUpMenuExample extends JFrame{
    
    JTextArea txtArea;
    JMenuItem redo,undo,cut,copy,paste;
    JPopupMenu popUp;
    
    public PopUpMenuExample(){
    
        setLayout(new BorderLayout());
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        cut = new JMenuItem("CUT", new ImageIcon("cut.png"));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
        
        copy = new JMenuItem("COPY", new ImageIcon("copy.png"));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
        
        paste = new JMenuItem("PASTE", new ImageIcon("paste.png"));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
        
        paste.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("actionListener");
            }
        });
        
        popUp = new JPopupMenu();
        popUp.add(cut);
        popUp.add(copy);
        popUp.add(paste);
        
        txtArea.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                if(e.isPopupTrigger())
                {
                    popUp.show(e.getComponent(),e.getX(),e.getY());
                }
            }
        });
        
        add(txtArea, BorderLayout.CENTER);
        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        
        PopUpMenuExample a=new PopUpMenuExample();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
