package adapter;
import controller.*;
import view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Adapter implements ActionListener {

	private Controller c;
	private View v;
	
	//initialize reference of view and controller
    public Adapter(Controller c, View v) {
        this.c = c;
        this.v = v;
    }

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