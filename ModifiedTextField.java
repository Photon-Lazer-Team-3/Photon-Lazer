import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
public class ModifiedTextField extends JTextField{
    
    private boolean updated;

    public ModifiedTextField()
    {
        super();
        this.updated = false;



        this.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                // TODO Auto-generated method stub
            }
            public void focusLost(FocusEvent e) {
                // TODO Auto-generated method stub
                update();
                
            }
        });

        
    }



    public boolean isUpdated()
    {
        return this.updated;
    }


    public void update()
    {
       this.updated = true; 
    }



    
}
