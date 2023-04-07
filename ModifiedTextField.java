import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class ModifiedTextField extends JTextField{
    private int index;
    private String value;
    public ModifiedTextField(int index)
    {
        super();
        this.index = index;
        this.value = value;
    }

    public int getIndex()
    {
        return this.index;
    }

    
}
