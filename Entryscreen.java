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
        JFrame jframe = new JFrame("Entryscreen");  
        JTextField t1,t2,t3,t4;  
        t1=new JTextField();  
        t1.setBounds(50,100, 100,30);  
        t2=new JTextField();  
        t2.setBounds(145,100, 200,30);
        t3=new JTextField();  
        t3.setBounds(50,200, 100,30);
        t4=new JTextField();  
        t4.setBounds(145,200, 200,30);
        jframe.add(t1); 
        jframe.add(t2);  
        jframe.add(t3);
        jframe.add(t4);
        jframe.setSize(700,700);  
        jframe.setLayout(null);  
        jframe.setVisible(true);  
        jframe.getContentPane().setBackground(Color.RED);
    }

    public static void main(String[] args) throws Exception{
        new Entryscreen();
    }
}