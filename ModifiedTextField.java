import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//! So what we need to do here is to add the document listener to the actual contruction of this class
public class ModifiedTextField extends JTextField{
    private int index;
    private String value;
    //Why does this now through an error at me right now this makes no sense to me right now
    //Should we have another boolean variable to tell us when the database has checked it maybe
    private long lastUpdate = -1;
    private boolean updated;
    public ModifiedTextField(int index)
    {
        super();
        this.index = index;
        this.value = value;
        this.updated = false;

        //! Hopefully these method calls should work. The problem is that I don't know if these calls will call the object that made them or do something else that I don't know what it will do
        this.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e)
            {}
            public void removeUpdate(DocumentEvent e)
            {}
            public void insertUpdate(DocumentEvent e)
            {
                //If the textField is not updated then check to see if the user is done updating
                if(updated != true)
                    update();
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
    public void update()
    {
        long updateTime = System.currentTimeMillis();
        if(lastUpdate == -1)
        {
            lastUpdate = updateTime;
            return;
        }
        else
        {
            long difference = updateTime - this.lastUpdate;
            //Checks to see if the last update was less than half a second a go and if so changes updated value to true
            if(difference >= 5000)
                updated = true;
        }
    }

    
}