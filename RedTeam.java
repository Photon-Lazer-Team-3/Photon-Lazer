import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;

public class RedTeam extends JFrame {
    JFrame jFrame;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,
    t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40; 
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20;
    JLabel labelHeader;

    public RedTeam() {
        // Adds title to the frame
        jFrame = new JFrame("Red Team Player Entry Terminal");
        // Creates team name text
        labelHeader = new JLabel("Red Team", SwingConstants.CENTER);
        labelHeader.setBounds(120, 10, 220, 37);
        // Create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        labelHeader.setBorder(border);
        // Adds team name label
        jFrame.add(labelHeader);
        // Creates textbox
        createTextbox();
        // Adds textbox
        addTextbox();
        // Creates checkbox
        createCheckbox();
        // Adds checkbox
        addCheckbox();
        // Sets the window size
        jFrame.setSize(465,850);  
        jFrame.setLayout(null);  
        jFrame.setVisible(true);  
        // Sets the windows background color to dark red
        jFrame.getContentPane().setBackground(new Color(141,2,31));
    }

    public void createTextbox() {
        // Creates text fields
        t1 = new JTextField();  
        t1.setBounds(67,45, 140,40);  
        t2 = new JTextField();  
        t2.setBounds(203,45, 240,40);
        t3 = new JTextField();  
        t3.setBounds(67,80, 140,40);
        t4 = new JTextField();  
        t4.setBounds(203,80, 240,40);
        t5 = new JTextField();
        t5.setBounds(67, 115, 140, 40);
        t6 = new JTextField();
        t6.setBounds(203, 115, 240, 40);
        t7 = new JTextField();
        t7.setBounds(67, 150, 140, 40);
        t8 = new JTextField();
        t8.setBounds(203, 150, 240, 40);
        t9 = new JTextField();
        t9.setBounds(67, 185, 140, 40);
        t10 = new JTextField();
        t10.setBounds(203, 185, 240, 40);
        t11 = new JTextField();
        t11.setBounds(67, 220, 140, 40);
        t12 = new JTextField();
        t12.setBounds(203, 220, 240, 40);
        t13 = new JTextField();
        t13.setBounds(67, 255, 140, 40);
        t14 = new JTextField();
        t14.setBounds(203, 255, 240, 40);
        t15 = new JTextField();
        t15.setBounds(67, 290, 140, 40);
        t16 = new JTextField();
        t16.setBounds(203, 290, 240, 40);
        t17 = new JTextField();
        t17.setBounds(67, 325, 140, 40);
        t18 = new JTextField();
        t18.setBounds(203, 325, 240, 40);
        t19 = new JTextField();
        t19.setBounds(67, 360, 140, 40);
        t20 = new JTextField();
        t20.setBounds(203, 360, 240, 40);
        t21 = new JTextField();
        t21.setBounds(70, 395, 140, 40);
        t22 = new JTextField();
        t22.setBounds(206, 395, 240, 40);
        t23 = new JTextField();
        t23.setBounds(70, 430, 140, 40);
        t24 = new JTextField();
        t24.setBounds(206, 430, 240, 40);
        t25 = new JTextField();
        t25.setBounds(70, 465, 140, 40);
        t26 = new JTextField();
        t26.setBounds(206, 465, 240, 40);
        t27 = new JTextField();
        t27.setBounds(70, 500, 140, 40);
        t28 = new JTextField();
        t28.setBounds(206, 500, 240, 40);
        t29 = new JTextField();
        t29.setBounds(70, 535, 140, 40);
        t30 = new JTextField();
        t30.setBounds(206, 535, 240, 40);
        t31 = new JTextField();
        t31.setBounds(70, 570, 140, 40);
        t32 = new JTextField();
        t32.setBounds(206, 570, 240, 40);
        t33 = new JTextField();
        t33.setBounds(70, 605, 140, 40);
        t34 = new JTextField();
        t34.setBounds(206, 605, 240, 40);
        t35 = new JTextField();
        t35.setBounds(70, 640, 140, 40);
        t36 = new JTextField();
        t36.setBounds(206, 640, 240, 40);
        t37 = new JTextField();
        t37.setBounds(70, 675, 140, 40);
        t38 = new JTextField();
        t38.setBounds(206, 675, 240, 40);
        t39 = new JTextField();
        t39.setBounds(70, 710, 140, 40);
        t40 = new JTextField();
        t40.setBounds(206, 710, 240, 40);
    }

    public void addTextbox() {
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
        jFrame.add(t17);
        jFrame.add(t18);
        jFrame.add(t19);
        jFrame.add(t20);
        jFrame.add(t21);
        jFrame.add(t22);
        jFrame.add(t23);
        jFrame.add(t24);
        jFrame.add(t25);
        jFrame.add(t26);
        jFrame.add(t27);
        jFrame.add(t28);
        jFrame.add(t29);
        jFrame.add(t30);
        jFrame.add(t31);
        jFrame.add(t32);
        jFrame.add(t33);
        jFrame.add(t34);
        jFrame.add(t35);
        jFrame.add(t36);
        jFrame.add(t37);
        jFrame.add(t38);
        jFrame.add(t39);
        jFrame.add(t40);
    }

    public void createCheckbox() {
        // Create checkboxes
        c1 = new JCheckBox("0");
        c1.setBounds(30, 45, 40, 40);
        c2 = new JCheckBox("1");
        c2.setBounds(30, 80, 40, 40);
        c3 = new JCheckBox("2");
        c3.setBounds(30, 115, 40, 40);
        c4 = new JCheckBox("3");
        c4.setBounds(30, 150, 40, 40);
        c5 = new JCheckBox("4");
        c5.setBounds(30, 185, 40, 40);
        c6 = new JCheckBox("5");
        c6.setBounds(30, 220, 40, 40);
        c7 = new JCheckBox("6");
        c7.setBounds(30, 255, 40, 40);
        c8 = new JCheckBox("7");
        c8.setBounds(30, 290, 40, 40);
        c9 = new JCheckBox("8");
        c9.setBounds(30, 325, 40, 40);
        c10 = new JCheckBox("9");
        c10.setBounds(30, 360, 40, 40);
        c11 = new JCheckBox("10");
        c11.setBounds(25, 395, 50, 40);
        c12 = new JCheckBox("11");
        c12.setBounds(25, 430, 50, 40);
        c13 = new JCheckBox("12");
        c13.setBounds(25, 465, 50, 40);
        c14 = new JCheckBox("13");
        c14.setBounds(25, 500, 50, 40);
        c15 = new JCheckBox("14");
        c15.setBounds(25, 535, 50, 40);
        c16 = new JCheckBox("15");
        c16.setBounds(25, 570, 50, 40);
        c17 = new JCheckBox("16");
        c17.setBounds(25, 605, 50, 40);
        c18 = new JCheckBox("17");
        c18.setBounds(25, 640, 50, 40);
        c19 = new JCheckBox("18");
        c19.setBounds(25, 675, 50, 40);
        c20 = new JCheckBox("19");
        c20.setBounds(25, 710, 50, 40);
    }

    public void addCheckbox() {
        // Adds checkboxes
        jFrame.add(c1);
        jFrame.add(c2);
        jFrame.add(c3);
        jFrame.add(c4);
        jFrame.add(c5);
        jFrame.add(c6);
        jFrame.add(c7);
        jFrame.add(c8);
        jFrame.add(c9);
        jFrame.add(c10);
        jFrame.add(c11);
        jFrame.add(c12);
        jFrame.add(c13);
        jFrame.add(c14);
        jFrame.add(c15);
        jFrame.add(c16);
        jFrame.add(c17);
        jFrame.add(c18);
        jFrame.add(c19);
        jFrame.add(c20);
    }

    public static void main(String[] args) throws Exception{
        new RedTeam();
    }
}