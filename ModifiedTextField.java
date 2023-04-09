import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//! So what we need to do here is to add the document listener to the actual contruction of this class
public class ModifiedTextField extends JTextField{
    private int index;
    private String value;
    private long lastUpdate = NULL;
    private boolean updated;
    public ModifiedTextField(int index)
    {
        super();
        this.index = index;
        this.value = value;
        this.updated = false;


        this.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e)
            {}
            public void removeUpdate(DocumentEvent e)
            {}
            public void insertUpdate(DocumentEvent e)
            {
                if(this.isUpdated() != true)
                {
                    this.checkUpdate();
                }
            }
        });
    }

    public int getIndex()
    {
        return this.index;
    }

    public boolean isUpdated()
    {
        return this.updated;
    }

    //Checks when the last key stroke was added
    private void checkUpdate()
    {
        long currentUpdate = System.currentTimeMillis();
        if(lastUpdate == NULL)
        {
            lastUpdate = System.currentTimeMillis();
        }
        else
        {
            if((lastUpdate - currentUpdate) > 500)
            {
                updated = true;
                this.setEditable(false);
            }
        }
    }

    
}
