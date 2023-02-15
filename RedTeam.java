import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class RedTeam extends JFrame implements ActionListener{
    JFrame jFrame;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,
    t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30;
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
    JLabel labelHeader;
    JButton edit, start;
    
    /* Set text fields to false until the f3key/button is pressed/clicked and then allow
     * typing in the fields
     * Do something like when a check box is checked get the player name from the textbox
     * next to it and send it to the database
     */


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
        // Adds edit button
        editButton();
        // Adds start button
        startButton();
        
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
        t1.setEnabled(false);
        t2 = new JTextField();  
        t2.setBounds(203,45, 240,40);
        t2.setEnabled(false);
        t3 = new JTextField();  
        t3.setBounds(67,80, 140,40);
        t3.setEnabled(false);
        t4 = new JTextField();  
        t4.setBounds(203,80, 240,40);
        t4.setEnabled(false);
        t5 = new JTextField();
        t5.setBounds(67, 115, 140, 40);
        t5.setEnabled(false);
        t6 = new JTextField();
        t6.setBounds(203, 115, 240, 40);
        t6.setEnabled(false);
        t7 = new JTextField();
        t7.setBounds(67, 150, 140, 40);
        t7.setEnabled(false);
        t8 = new JTextField();
        t8.setBounds(203, 150, 240, 40);
        t8.setEnabled(false);
        t9 = new JTextField();
        t9.setBounds(67, 185, 140, 40);
        t9.setEnabled(false);
        t10 = new JTextField();
        t10.setBounds(203, 185, 240, 40);
        t10.setEnabled(false);
        t11 = new JTextField();
        t11.setBounds(67, 220, 140, 40);
        t11.setEnabled(false);
        t12 = new JTextField();
        t12.setBounds(203, 220, 240, 40);
        t12.setEnabled(false);
        t13 = new JTextField();
        t13.setBounds(67, 255, 140, 40);
        t13.setEnabled(false);
        t14 = new JTextField();
        t14.setBounds(203, 255, 240, 40);
        t14.setEnabled(false);
        t15 = new JTextField();
        t15.setBounds(67, 290, 140, 40);
        t15.setEnabled(false);
        t16 = new JTextField();
        t16.setBounds(203, 290, 240, 40);
        t16.setEnabled(false);
        t17 = new JTextField();
        t17.setBounds(67, 325, 140, 40);
        t17.setEnabled(false);
        t18 = new JTextField();
        t18.setBounds(203, 325, 240, 40);
        t18.setEnabled(false);
        t19 = new JTextField();
        t19.setBounds(67, 360, 140, 40);
        t19.setEnabled(false);
        t20 = new JTextField();
        t20.setBounds(203, 360, 240, 40);
        t20.setEnabled(false);
        t21 = new JTextField();
        t21.setBounds(70, 395, 140, 40);
        t21.setEnabled(false);
        t22 = new JTextField();
        t22.setBounds(206, 395, 240, 40);
        t22.setEnabled(false);
        t23 = new JTextField();
        t23.setBounds(70, 430, 140, 40);
        t23.setEnabled(false);
        t24 = new JTextField();
        t24.setBounds(206, 430, 240, 40);
        t24.setEnabled(false);
        t25 = new JTextField();
        t25.setBounds(70, 465, 140, 40);
        t25.setEnabled(false);
        t26 = new JTextField();
        t26.setBounds(206, 465, 240, 40);
        t26.setEnabled(false);
        t27 = new JTextField();
        t27.setBounds(70, 500, 140, 40);
        t27.setEnabled(false);
        t28 = new JTextField();
        t28.setBounds(206, 500, 240, 40);
        t28.setEnabled(false);
        t29 = new JTextField();
        t29.setBounds(70, 535, 140, 40);
        t29.setEnabled(false);
        t30 = new JTextField();
        t30.setBounds(206, 535, 240, 40);
        t30.setEnabled(false);
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
    }

    public void editButton() {
        // Creates edit button
        edit = new JButton("Edit\nTeam");
        edit.setBounds(25,580,75,75);
        // Add action listener to edit button
        edit.addActionListener(this);
        jFrame.add(edit);
    }

    public void startButton() {
        // Creates edit button
        start = new JButton("Start\nGame");
        start.setBounds(125,580,75,75);
        // Add action listener to edit button
        start.addActionListener(this);
        jFrame.add(start);
    }

    // When button is clicked allow input in text fields
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String playerInfo1;
        String playerInfo2;
        String playerInfo3;
        String playerInfo4;
        String playerInfo5;
        String playerInfo6;
        String playerInfo7;
        String playerInfo8;
        String playerInfo9;
        String playerInfo10;
        String playerInfo11;
        String playerInfo12;
        String playerInfo13;
        String playerInfo14;
        String playerInfo15;
        String playerInfo16;
        String playerInfo17;
        String playerInfo18;
        String playerInfo19;
        String playerInfo20;
        String playerInfo21;
        String playerInfo22;
        String playerInfo23;
        String playerInfo24;
        String playerInfo25;
        String playerInfo26;
        String playerInfo27;
        String playerInfo28;
        String playerInfo29;
        String playerInfo30;

        t1.setEnabled(true);
        t2.setEnabled(true);
        t3.setEnabled(true);
        t4.setEnabled(true);
        t5.setEnabled(true);
        t6.setEnabled(true);
        t7.setEnabled(true);
        t8.setEnabled(true);
        t9.setEnabled(true);
        t10.setEnabled(true);
        t11.setEnabled(true);
        t12.setEnabled(true);
        t13.setEnabled(true);
        t14.setEnabled(true);
        t15.setEnabled(true);
        t16.setEnabled(true);
        t17.setEnabled(true);
        t18.setEnabled(true);
        t19.setEnabled(true);
        t20.setEnabled(true);
        t21.setEnabled(true);
        t21.setEnabled(true);
        t23.setEnabled(true);
        t24.setEnabled(true);
        t25.setEnabled(true);
        t26.setEnabled(true);
        t27.setEnabled(true);
        t28.setEnabled(true);
        t29.setEnabled(true);
        t30.setEnabled(true);

        
        if (e.getSource() == start) {
            playerInfo1 = t1.getText();
            playerInfo2 = t2.getText();
            playerInfo3 = t3.getText();
            playerInfo4 = t4.getText();
            playerInfo5 = t5.getText();
            playerInfo6 = t6.getText();
            playerInfo7 = t7.getText();
            playerInfo8 = t8.getText();
            playerInfo9 = t9.getText();
            playerInfo10 = t10.getText();
            playerInfo11 = t11.getText();
            playerInfo12 = t12.getText();
            playerInfo13 = t13.getText();
            playerInfo14 = t14.getText();
            playerInfo15 = t15.getText();
            playerInfo16 = t16.getText();
            playerInfo17 = t17.getText();
            playerInfo18 = t18.getText();
            playerInfo19 = t19.getText();
            playerInfo20 = t20.getText();
            playerInfo21 = t21.getText();
            playerInfo22 = t22.getText();
            playerInfo23 = t23.getText();
            playerInfo24 = t24.getText();
            playerInfo25 = t25.getText();
            playerInfo26 = t26.getText();
            playerInfo27 = t27.getText();
            playerInfo28 = t28.getText();
            playerInfo29 = t29.getText();
            playerInfo30 = t30.getText();

            System.out.println("Player 1: " + playerInfo1 + " " + playerInfo2 + "\n");
            System.out.println("Player 2: " + playerInfo3 + " " + playerInfo4 + "\n");
            System.out.println("Player 3: " + playerInfo5 + " " + playerInfo6 + "\n");
            System.out.println("Player 4: " + playerInfo7 + " " + playerInfo8 + "\n");
            System.out.println("Player 5: " + playerInfo9 + " " + playerInfo10 + "\n");
            System.out.println("Player 6: " + playerInfo11 + " " + playerInfo12 + "\n");
            System.out.println("Player 7: " + playerInfo13 + " " + playerInfo14 + "\n");
            System.out.println("Player 8: " + playerInfo15 + " " + playerInfo16 + "\n");
            System.out.println("Player 9: " + playerInfo17 + " " + playerInfo18 + "\n");
            System.out.println("Player 10: " + playerInfo19 + " " + playerInfo20 + "\n");
            System.out.println("Player 11: " + playerInfo21 + " " + playerInfo22 + "\n");
            System.out.println("Player 12: " + playerInfo23 + " " + playerInfo24 + "\n");
            System.out.println("Player 13: " + playerInfo25 + " " + playerInfo26 + "\n");
            System.out.println("Player 14: " + playerInfo27 + " " + playerInfo28 + "\n");
            System.out.println("Player 15: " + playerInfo29 + " " + playerInfo30 + "\n"); 
        }
    }

    public static void main(String[] args) throws Exception{
        new RedTeam();
    }
}