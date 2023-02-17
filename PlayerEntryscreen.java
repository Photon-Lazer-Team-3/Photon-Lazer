import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class PlayerEntryscreen extends JFrame implements ActionListener{
    JFrame entryFrame;
    JTextField [] redText = new JTextField[30];
    JTextField [] greenText = new JTextField[30];
    JLabel [] redLabels = new JLabel[15];
    JLabel [] greenLabels = new JLabel[15];
    JLabel redLabelHeader, greenLabelHeader;
    JButton edit, start;
    
    public PlayerEntryscreen() {
        // Adds title to the frame
        entryFrame = new JFrame("Player Entry Terminal");
        // Creates red team name header
        redLabelHeader = new JLabel("Red Team", SwingConstants.CENTER);
        redLabelHeader.setBounds(120, 10, 220, 37);
        redLabelHeader.setForeground(Color.RED);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        redLabelHeader.setBorder(border);
        entryFrame.add(redLabelHeader);
        // Creates red team name header
        greenLabelHeader = new JLabel("Green Team", SwingConstants.CENTER);
        greenLabelHeader.setBounds(500, 10, 220, 37);
        greenLabelHeader.setForeground(Color.GREEN);
        Border border2 = BorderFactory.createLineBorder(Color.WHITE, 1);
        greenLabelHeader.setBorder(border2);
        entryFrame.add(greenLabelHeader);
        // Creates and adds red team textboxes
        createRedTextbox();
        // Creates and adds red team labels
        createRedLabels();
        // Creates and adds green team textboxes
        createGreenTextbox();
        // Creates and adds green team labels
        createGreenLabels();
        // Adds edit button
        editButton();
        // Adds start button
        startButton();
        // Sets the window size
        entryFrame.setSize(900,850);  
        entryFrame.setLayout(null);  
        entryFrame.setVisible(true);  
        // Sets the windows background color to dark red
        entryFrame.getContentPane().setBackground(Color.BLACK);
    }

    public void createRedTextbox() {
        int x = 67; // Initial x position
        int y = 45; // Initial y position

        for (int i = 0; i < 30; i++) {
            redText[i] = new JTextField();
            redText[i].setBounds(x, y, 140, 40);
            redText[i].setEnabled(false);

            if (i % 2 == 0) {
                x = 203;
            } else {
                x = 67;
                y += 35;
            }
            entryFrame.add(redText[i]);
        }
    }

    public void createGreenTextbox() {
        int x = 497; // Initial x position
        int y = 45; // Initial y position

        for (int i = 0; i < 30; i++) {
            greenText[i] = new JTextField();
            greenText[i].setBounds(x, y, 140, 40);
            greenText[i].setEnabled(false);

            if (i % 2 == 0) {
                x = 633;
            } else {
                x = 497;
                y += 35;
            }
            entryFrame.add(greenText[i]);
        }
    }

    public void createRedLabels() {
        int x = 30;
        int y = 45;

        for (int i = 0; i < 15; i++) {
            int number = i + 1;
            String playerNum = Integer.toString(number);
            redLabels[i] = new JLabel(playerNum);
            redLabels[i].setBounds(x, y, 40, 40);
            redLabels[i].setForeground(Color.RED);
            y += 35;

            entryFrame.add(redLabels[i]);
        }
    }

    public void createGreenLabels() {
        int x = 800;
        int y = 45;

        for (int i = 0; i < 15; i++) {
            int number = i + 1;
            String playerNum = Integer.toString(number);
            greenLabels[i] = new JLabel(playerNum);
            greenLabels[i].setBounds(x, y, 40, 40);
            greenLabels[i].setForeground(Color.GREEN);
            y += 35;

            entryFrame.add(greenLabels[i]);
        }
    }

    public void editButton() {
        // Creates edit button
        edit = new JButton("Edit\nTeam");
        edit.setBounds(25,580,75,75);
        // Add action listener to edit button
        edit.addActionListener(this);
        entryFrame.add(edit);
    }

    public void startButton() {
        // Creates edit button
        start = new JButton("Start\nGame");
        start.setBounds(125,580,85,75);
        // Add action listener to edit button
        start.addActionListener(this);
        entryFrame.add(start);
    }

    // When button is clicked allow input in text fields
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String rPlayerInfo1;
        String rPlayerInfo2;
        String rPlayerInfo3;
        String rPlayerInfo4;
        String rPlayerInfo5;
        String rPlayerInfo6;
        String rPlayerInfo7;
        String rPlayerInfo8;
        String rPlayerInfo9;
        String rPlayerInfo10;
        String rPlayerInfo11;
        String rPlayerInfo12;
        String rPlayerInfo13;
        String rPlayerInfo14;
        String rPlayerInfo15;
        String rPlayerInfo16;
        String rPlayerInfo17;
        String rPlayerInfo18;
        String rPlayerInfo19;
        String rPlayerInfo20;
        String rPlayerInfo21;
        String rPlayerInfo22;
        String rPlayerInfo23;
        String rPlayerInfo24;
        String rPlayerInfo25;
        String rPlayerInfo26;
        String rPlayerInfo27;
        String rPlayerInfo28;
        String rPlayerInfo29;
        String rPlayerInfo30;

        String gPlayerInfo1;
        String gPlayerInfo2;
        String gPlayerInfo3;
        String gPlayerInfo4;
        String gPlayerInfo5;
        String gPlayerInfo6;
        String gPlayerInfo7;
        String gPlayerInfo8;
        String gPlayerInfo9;
        String gPlayerInfo10;
        String gPlayerInfo11;
        String gPlayerInfo12;
        String gPlayerInfo13;
        String gPlayerInfo14;
        String gPlayerInfo15;
        String gPlayerInfo16;
        String gPlayerInfo17;
        String gPlayerInfo18;
        String gPlayerInfo19;
        String gPlayerInfo20;
        String gPlayerInfo21;
        String gPlayerInfo22;
        String gPlayerInfo23;
        String gPlayerInfo24;
        String gPlayerInfo25;
        String gPlayerInfo26;
        String gPlayerInfo27;
        String gPlayerInfo28;
        String gPlayerInfo29;
        String gPlayerInfo30;

        // Set red textboxes to editable
        redText[0].setEnabled(true);
        redText[1].setEnabled(true);
        redText[2].setEnabled(true);
        redText[3].setEnabled(true);
        redText[4].setEnabled(true);
        redText[5].setEnabled(true);
        redText[6].setEnabled(true);
        redText[7].setEnabled(true);
        redText[8].setEnabled(true);
        redText[9].setEnabled(true);
        redText[10].setEnabled(true);
        redText[11].setEnabled(true);
        redText[12].setEnabled(true);
        redText[13].setEnabled(true);
        redText[14].setEnabled(true);
        redText[15].setEnabled(true);
        redText[16].setEnabled(true);
        redText[17].setEnabled(true);
        redText[18].setEnabled(true);
        redText[19].setEnabled(true);
        redText[20].setEnabled(true);
        redText[21].setEnabled(true);
        redText[22].setEnabled(true);
        redText[23].setEnabled(true);
        redText[24].setEnabled(true);
        redText[25].setEnabled(true);
        redText[26].setEnabled(true);
        redText[27].setEnabled(true);
        redText[28].setEnabled(true);
        redText[29].setEnabled(true);
        // Set green textboxes to editable
        greenText[0].setEnabled(true);
        greenText[1].setEnabled(true);
        greenText[2].setEnabled(true);
        greenText[3].setEnabled(true);
        greenText[4].setEnabled(true);
        greenText[5].setEnabled(true);
        greenText[6].setEnabled(true);
        greenText[7].setEnabled(true);
        greenText[8].setEnabled(true);
        greenText[9].setEnabled(true);
        greenText[10].setEnabled(true);
        greenText[11].setEnabled(true);
        greenText[12].setEnabled(true);
        greenText[13].setEnabled(true);
        greenText[14].setEnabled(true);
        greenText[15].setEnabled(true);
        greenText[16].setEnabled(true);
        greenText[17].setEnabled(true);
        greenText[18].setEnabled(true);
        greenText[19].setEnabled(true);
        greenText[20].setEnabled(true);
        greenText[21].setEnabled(true);
        greenText[22].setEnabled(true);
        greenText[23].setEnabled(true);
        greenText[24].setEnabled(true);
        greenText[25].setEnabled(true);
        greenText[26].setEnabled(true);
        greenText[27].setEnabled(true);
        greenText[28].setEnabled(true);
        greenText[29].setEnabled(true);

        
        if (e.getSource() == start) {
            rPlayerInfo1 = redText[0].getText();
            rPlayerInfo2 = redText[1].getText();
            rPlayerInfo3 = redText[2].getText();
            rPlayerInfo4 = redText[3].getText();
            rPlayerInfo5 = redText[4].getText();
            rPlayerInfo6 = redText[5].getText();
            rPlayerInfo7 = redText[6].getText();
            rPlayerInfo8 = redText[7].getText();
            rPlayerInfo9 = redText[8].getText();
            rPlayerInfo10 = redText[9].getText();
            rPlayerInfo11 = redText[10].getText();
            rPlayerInfo12 = redText[11].getText();
            rPlayerInfo13 = redText[12].getText();
            rPlayerInfo14 = redText[13].getText();
            rPlayerInfo15 = redText[14].getText();
            rPlayerInfo16 = redText[15].getText();
            rPlayerInfo17 = redText[16].getText();
            rPlayerInfo18 = redText[17].getText();
            rPlayerInfo19 = redText[18].getText();
            rPlayerInfo20 = redText[19].getText();
            rPlayerInfo21 = redText[20].getText();
            rPlayerInfo22 = redText[21].getText();
            rPlayerInfo23 = redText[22].getText();
            rPlayerInfo24 = redText[23].getText();
            rPlayerInfo25 = redText[24].getText();
            rPlayerInfo26 = redText[25].getText();
            rPlayerInfo27 = redText[26].getText();
            rPlayerInfo28 = redText[27].getText();
            rPlayerInfo29 = redText[28].getText();
            rPlayerInfo30 = redText[29].getText();

            gPlayerInfo1 = greenText[0].getText();
            gPlayerInfo2 = greenText[1].getText();
            gPlayerInfo3 = greenText[2].getText();
            gPlayerInfo4 = greenText[3].getText();
            gPlayerInfo5 = greenText[4].getText();
            gPlayerInfo6 = greenText[5].getText();
            gPlayerInfo7 = greenText[6].getText();
            gPlayerInfo8 = greenText[7].getText();
            gPlayerInfo9 = greenText[8].getText();
            gPlayerInfo10 = greenText[9].getText();
            gPlayerInfo11 = greenText[10].getText();
            gPlayerInfo12 = greenText[11].getText();
            gPlayerInfo13 = greenText[12].getText();
            gPlayerInfo14 = greenText[13].getText();
            gPlayerInfo15 = greenText[14].getText();
            gPlayerInfo16 = greenText[15].getText();
            gPlayerInfo17 = greenText[16].getText();
            gPlayerInfo18 = greenText[17].getText();
            gPlayerInfo19 = greenText[18].getText();
            gPlayerInfo20 = greenText[19].getText();
            gPlayerInfo21 = greenText[20].getText();
            gPlayerInfo22 = greenText[21].getText();
            gPlayerInfo23 = greenText[22].getText();
            gPlayerInfo24 = greenText[23].getText();
            gPlayerInfo25 = greenText[24].getText();
            gPlayerInfo26 = greenText[25].getText();
            gPlayerInfo27 = greenText[26].getText();
            gPlayerInfo28 = greenText[27].getText();
            gPlayerInfo29 = greenText[28].getText();
            gPlayerInfo30 = greenText[29].getText();

            System.out.println("Red Player 1: " + rPlayerInfo1 + " " + rPlayerInfo2 + "\n");
            System.out.println("Red Player 2: " + rPlayerInfo3 + " " + rPlayerInfo4 + "\n");
            System.out.println("Red Player 3: " + rPlayerInfo5 + " " + rPlayerInfo6 + "\n");
            System.out.println("Red Player 4: " + rPlayerInfo7 + " " + rPlayerInfo8 + "\n");
            System.out.println("Red Player 5: " + rPlayerInfo9 + " " + rPlayerInfo10 + "\n");
            System.out.println("Red Player 6: " + rPlayerInfo11 + " " + rPlayerInfo12 + "\n");
            System.out.println("Red Player 7: " + rPlayerInfo13 + " " + rPlayerInfo14 + "\n");
            System.out.println("Red Player 8: " + rPlayerInfo15 + " " + rPlayerInfo16 + "\n");
            System.out.println("Red Player 9: " + rPlayerInfo17 + " " + rPlayerInfo18 + "\n");
            System.out.println("Red Player 10: " + rPlayerInfo19 + " " + rPlayerInfo20 + "\n");
            System.out.println("Red Player 11: " + rPlayerInfo21 + " " + rPlayerInfo22 + "\n");
            System.out.println("Red Player 12: " + rPlayerInfo23 + " " + rPlayerInfo24 + "\n");
            System.out.println("Red Player 13: " + rPlayerInfo25 + " " + rPlayerInfo26 + "\n");
            System.out.println("Red Player 14: " + rPlayerInfo27 + " " + rPlayerInfo28 + "\n");
            System.out.println("Red Player 15: " + rPlayerInfo29 + " " + rPlayerInfo30 + "\n"); 

            System.out.println("Green Player 1: " + gPlayerInfo1 + " " + gPlayerInfo2 + "\n");
            System.out.println("Green Player 2: " + gPlayerInfo3 + " " + gPlayerInfo4 + "\n");
            System.out.println("Green Player 3: " + gPlayerInfo5 + " " + gPlayerInfo6 + "\n");
            System.out.println("Green Player 4: " + gPlayerInfo7 + " " + gPlayerInfo8 + "\n");
            System.out.println("Green Player 5: " + gPlayerInfo9 + " " + gPlayerInfo10 + "\n");
            System.out.println("Green Player 6: " + gPlayerInfo11 + " " + gPlayerInfo12 + "\n");
            System.out.println("Green Player 7: " + gPlayerInfo13 + " " + gPlayerInfo14 + "\n");
            System.out.println("Green Player 8: " + gPlayerInfo15 + " " + gPlayerInfo16 + "\n");
            System.out.println("Green Player 9: " + gPlayerInfo17 + " " + gPlayerInfo18 + "\n");
            System.out.println("Green Player 10: " + gPlayerInfo19 + " " + gPlayerInfo20 + "\n");
            System.out.println("Green Player 11: " + gPlayerInfo21 + " " + gPlayerInfo22 + "\n");
            System.out.println("Green Player 12: " + gPlayerInfo23 + " " + gPlayerInfo24 + "\n");
            System.out.println("Green Player 13: " + gPlayerInfo25 + " " + gPlayerInfo26 + "\n");
            System.out.println("Green Player 14: " + gPlayerInfo27 + " " + gPlayerInfo28 + "\n");
            System.out.println("Green Player 15: " + gPlayerInfo29 + " " + gPlayerInfo30 + "\n"); 
        }
    }

    public static void main(String[] args) throws Exception{
        new PlayerEntryscreen();
    }
}