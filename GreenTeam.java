
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

public class GreenTeam extends JFrame implements ActionListener{

    JFrame green_window;
    JTextField text_boxes[] = new JTextField[30];
    JCheckBox check_boxes[] = new JCheckBox[30];
    JLabel labelHeader;
    JButton edit, start;

    
    public GreenTeam() {

        green_window = new JFrame("Green Team Player Entry Terminal");

        labelHeader = new JLabel("Green Team", SwingConstants.CENTER);
        labelHeader.setBounds(120, 10, 220, 37);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        labelHeader.setBorder(border);

        green_window.add(labelHeader);

        createTextbox();

        createCheckBox();
    
        editButton();

        startButton();

        green_window.setSize(465,850);  
        green_window.setLayout(null);  
        green_window.setVisible(true);  
        // Sets the windows background color to dark green

        green_window.getContentPane().setBackground(new Color(13, 154, 0));
    }

    public void createTextbox(){

    int x = 67; // initial x-coordinate
    int y = 45; // initial y-coordinate

    for (int i = 0; i < 30; i++) {
        text_boxes[i] = new JTextField();
        text_boxes[i].setBounds(x, y, 140, 40);
        text_boxes[i].setEnabled(false);

        if(i % 2 == 0){
            x = 203;
        }
        else{
            x = 67;
            y += 35;
        }
    green_window.add(text_boxes[i]);
    }
    }

    public void createCheckBox(){
        int x = 30;
        int y = 45;

        for(int i = 0; i < 15; i++){
            String title = String.valueOf(i);
            check_boxes[i] = new JCheckBox(title);
            check_boxes[i].setBounds(x, y, 40, 40);
            y += 35;

            green_window.add(check_boxes[i]);
        }
    }

    public void editButton() {
        // Creates edit button
        edit = new JButton("Edit\nTeam");
        edit.setBounds(25,580,75,75);
        // Add action listener to edit button
        edit.addActionListener(this);
        green_window.add(edit);
    }

    public void startButton() {
        // Creates edit button
        start = new JButton("Start\nGame");
        start.setBounds(125,580,75,75);
        // Add action listener to edit button
        start.addActionListener(this);
        green_window.add(start);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String playerInfo[] = new String[30];

        for(int i = 0; i < 30; i++){
            playerInfo[i] = new String("PlayerInfo" + i);
            text_boxes[i].setEnabled(true);
        }

        if(e.getSource() == start){

            for(int i = 0; i < 30; i++){
                playerInfo[i] = text_boxes[i].getText();
            }

            //CREATE PLAYER OBJECTS SET THE NAME AND THE USER ID 
            //Player player1 = player1.set PLAYER INFO[0] and PLAYER INFO[1]
            //Player player2 = player2.set PlAYERINFO[2] and Player INFO[3]
        }
    }

    public static void main(String[] args) throws Exception{
        new GreenTeam();
    }
}