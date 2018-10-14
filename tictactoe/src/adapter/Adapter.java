package adapter;
import controller.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Adapter implements ActionListener {
	private Controller c;
    public Adapter(Controller c) {
        this.c = c;
    }
     /**
     * This class is an ActionListener, so it must implement this method. But,
     * it only transforms data and delegates the call.
     */
    public void actionPerformed(ActionEvent e) {
        String event = "You clicked " + getName(e);
    }
     /**
     * Determine the name of the component from which the event got triggered.
     */
    private String getName(ActionEvent e) {
        if (e.getSource() instanceof JComponent) {
            return ((JComponent)e.getSource()).getName();
        } else {
            throw new RuntimeException("Event from unexpected component");
        }
    }
}