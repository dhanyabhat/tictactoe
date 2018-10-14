package adapter;

/** The adapter class is an interface between the view and the controller.
 * It listens for actions on the buttons and invokes 
 * the controller class to take appropriate action.
 * */

import controller.*;
import view.*;
import java.awt.event.*;
import java.util.ArrayList;
public class Adapter implements ActionListener {

	private Controller c;
	private View v;

	//initialize reference of view and controller
    public Adapter(Controller c, View v) {
        this.c = c;
        this.v = v;
    }

    public void actionPerformed(ActionEvent e) {
    	// request the controller to perform action depending on the button pressed
		if(v.isReset(e))
			c.setRequest();
		else {
			ArrayList<Integer> position = v.getMyPosition(e);
			c.setRequest(position);
		}
    }
}