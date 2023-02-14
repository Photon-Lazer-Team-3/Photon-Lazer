import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import java.awt.Color;

public class Entryscreen extends JFrame {
    JFrame jFrame;
    JPanel panel1;
    JPanel panel2;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18; 
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8;
    JLabel labelHeader;

    public Entryscreen() {
        // Adds title to the frame
        jFrame = new JFrame("Entryscreen");
        
        // Creates team name text
        labelHeader = new JLabel("Red Team", SwingConstants.CENTER);
        labelHeader.setBounds(140, 65, 220, 37);
        // Create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        labelHeader.setBorder(border);

        // Creates text fields
        t1 = new JTextField();  
        t1.setBounds(   87,100, 140,40);  
        t2 = new JTextField();  
        t2.setBounds(223,100, 240,40);
        t3 = new JTextField();  
        t3.setBounds(87,135, 140,40);
        t4 = new JTextField();  
        t4.setBounds(223,135, 240,40);
        t5 = new JTextField();
        t5.setBounds(87, 170, 140, 40);
        t6 = new JTextField();
        t6.setBounds(223, 170, 240, 40);
        t7 = new JTextField();
        t7.setBounds(87, 205, 140, 40);
        t8 = new JTextField();
        t8.setBounds(223, 205, 240, 40);
        t9 = new JTextField();
        t9.setBounds(87, 240, 140, 40);
        t10 = new JTextField();
        t10.setBounds(223, 240, 240, 40);
        t11 = new JTextField();
        t11.setBounds(87, 275, 140, 40);
        t12 = new JTextField();
        t12.setBounds(223, 275, 240, 40);
        t13 = new JTextField();
        t13.setBounds(87, 310, 140, 40);
        t14 = new JTextField();
        t14.setBounds(223, 310, 240, 40);
        t15 = new JTextField();
        t15.setBounds(87, 345, 140, 40);
        t16 = new JTextField();
        t16.setBounds(223, 345, 240, 40);

        // Create checkboxes
        c1 = new JCheckBox("0");
        c1.setBounds(50, 100, 40, 40);
        c2 = new JCheckBox("1");
        c2.setBounds(50, 135, 40, 40);
        c3 = new JCheckBox("2");
        c3.setBounds(50, 170, 40, 40);
        c4 = new JCheckBox("3");
        c4.setBounds(50, 205, 40, 40);
        c5 = new JCheckBox("4");
        c5.setBounds(50, 240, 40, 40);
        c6 = new JCheckBox("5");
        c6.setBounds(50, 275, 40, 40);
        c7 = new JCheckBox("6");
        c7.setBounds(50, 310, 40, 40);
        c8 = new JCheckBox("7");
        c8.setBounds(50, 345, 40, 40);

        // Adds team name box
        jFrame.add(labelHeader);

        // Adds text fields
        jFrame.add(t1); 
        jFrame.add(t2);  
        jFrame.add(t3);
        jFrame.add(t4);
        jFrame.add(t5);
        jFrame.add(t6);
        jFrame.add(t7);
        jFrame.add(t8);
        jFrame.add(t9);
        jFrame.add(t10);
        jFrame.add(t11);
        jFrame.add(t12);
        jFrame.add(t13);
        jFrame.add(t14);
        jFrame.add(t15);
        jFrame.add(t16);

        // Adds checkboxes
        jFrame.add(c1);
        jFrame.add(c2);
        jFrame.add(c3);
        jFrame.add(c4);
        jFrame.add(c5);
        jFrame.add(c6);
        jFrame.add(c7);
        jFrame.add(c8);
        
        jFrame.setSize(465,700);  
        jFrame.setLayout(null);  
        jFrame.setVisible(true);  
        jFrame.getContentPane().setBackground(new Color(141,2,31));
    }

    public static void main(String[] args) throws Exception{
        new Entryscreen();
    }
}