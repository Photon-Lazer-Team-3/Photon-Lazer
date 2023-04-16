import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
public class ModifiedTextField extends JTextField{
    
    private boolean updated;

    public ModifiedTextField()
    {
        super();
        this.updated = false;

        
    }



    public boolean isUpdated()
    {
        return this.updated;
    }


    public void update()
    {
        
    }



    
}
