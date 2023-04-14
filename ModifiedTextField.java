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
    private boolean checked;
    public ModifiedTextField(int index)
    {
        super();
        this.index = index;
        this.value = value;
        this.updated = false;
        this.checked = false;

        //! Hopefully these method calls should work. The problem is that I don't know if these calls will call the object that made them or do something else that I don't know what it will do
        this.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e)
            {}
            public void removeUpdate(DocumentEvent e)
            {}
            public void insertUpdate(DocumentEvent e)
            {
                //If the textField is not updated then check to see if the user is done updating
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

    //What exactly do we want this method to do now
    //It should update when the last update was 
    public void update()
    {
        this.lastUpdate = System.currentTimeMillis();
    }

    public void checkUpdate()
    {
        if(isUpdated())
            return;
        else
        {
            long currentTime = System.currentTimeMillis();
            if((currentTime - this.lastUpdate) >= 5000)
            {
                this.updated = true;
            }
            else
            {
                if(isUpdated())
                    return;
            }
        }
    }

    public boolean isChecked()
    {
        return this.checked;
    }

    //Sets that the JTextField has been checked
    public void setChecked()
    {
        this.checked = true;
    }

    public void prnt()
    {
        System.out.println(checked);
        System.out.println(updated);
    }

    
}
