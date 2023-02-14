import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Color;

public class Entryscreen extends JFrame {
    
    public Entryscreen() {
        /*this.setTitle("Entryscreen");
        this.setSize(500,500);
        this.setFocusable(true);
        this.getContentPane();
        this.setVisible(true);
        JTextField textField = new JTextField("hiihihihihhi");
        textField.setToolTipText("Please enter some text here");*/
        JFrame jFrame = new JFrame("Entryscreen");
        JTextField t1,t2,t3,t4,t5, t6; 
        JCheckBox c1, c2, c3;
         
        t1 = new JTextField();  
        t1.setBounds(50,100, 100,30);  
        t2 = new JTextField();  
        t2.setBounds(145,100, 200,30);
        t3 = new JTextField();  
        t3.setBounds(50,123, 100,30);
        t4 = new JTextField();  
        t4.setBounds(145,123, 200,30);
        t5 = new JTextField();
        t5.setBounds(50, 146, 100, 30);
        t6 = new JTextField();
        t6.setBounds(145, 146, 200, 30);
        c1 = new JCheckBox("0");
        c1.setBounds(30, 105, 20, 20);
        c2 = new JCheckBox("1");
        c2.setBounds(30, 128, 20, 20);
        c3 = new JCheckBox("2");
        c3.setBounds(30, 151, 20, 20);
        jFrame.add(t1); 
        jFrame.add(t2);  
        jFrame.add(t3);
        jFrame.add(t4);
        jFrame.add(t5);
        jFrame.add(t6);
        jFrame.add(c1);
        jFrame.add(c2);
        jFrame.add(c3);
        jFrame.setSize(700,700);  
        jFrame.setLayout(null);  
        jFrame.setVisible(true);  
        jFrame.getContentPane().setBackground(new Color(254,17,0));
    }

    public static void main(String[] args) throws Exception{
        new Entryscreen();
    }
}