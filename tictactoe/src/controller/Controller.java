package controller;

/** The Controller is responsible for requesting the model
 * to update its state when there is an event triggered from 
 * the board.
 * */

import java.util.ArrayList;

import model.*;

public class Controller {
	private Model m;
	
	// initializing the reference of model class
	public void setModel(Model m) {
		this.m = m;
	}
	
	// request the model to update the board
	public void setRequest(ArrayList<Integer> position) {
		m.PlayMove(position.get(0), position.get(1));
	}
	
	// request model to reset
	public void setRequest() {
		m.ResetModel();
	}

 }