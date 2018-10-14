package view;
import controller.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import adapter.*;

 public class View {
	private Controller c;
	private Adapter a;
	private JFrame gui;
    private JButton[][] blocks;
    private JButton reset;
    private JTextArea playerturn;
    
    public View() {
		this.gui = new JFrame("Tic Tac Toe");
		this.blocks = new JButton[3][3];
		this.reset = new JButton("Reset");
		this.playerturn = new JTextArea();

		initialize();
    }
    
    // function to add action listeners to buttons
    public void setActionListener(Controller c) {
    		// adapter needs reference of controller and view class
		this.a = new Adapter(c, this);
		for(int row = 0; row<3 ;row++) {
	        for(int column = 0; column<3 ;column++) {
	        	blocks[row][column].addActionListener(a);
	        }
		}
	    reset.addActionListener(a);
    }
    
    public void initialize () {
	    
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    gui.setSize(new Dimension(500, 350));
	    gui.setResizable(true);
	    
	    JPanel gamePanel = new JPanel(new FlowLayout());
	    JPanel game = new JPanel(new GridLayout(3,3));
	    gamePanel.add(game, BorderLayout.CENTER);
	    JPanel options = new JPanel(new FlowLayout());
	    options.add(reset);
	    JPanel messages = new JPanel(new FlowLayout());
	    messages.setBackground(Color.white);
	    gui.add(gamePanel, BorderLayout.NORTH);
	    gui.add(options, BorderLayout.CENTER);
	    gui.add(messages, BorderLayout.SOUTH);
	    messages.add(playerturn);
	    playerturn.setText("Player 1 to play 'X'");
	    
	    for(int row = 0; row < 3; row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                game.add(blocks[row][column]);
            }
	    }
	    gui.setVisible(true);
    }

    public boolean isReset(ActionEvent e) {
		if(e.getSource() == reset)
			return true;
		return false;
    }
    
    public ArrayList<Integer> getMyPosition(ActionEvent e) {
    	ArrayList<Integer> position = new ArrayList<Integer>();
    	for(int row = 0; row < 3 ;row++) {
	        for(int column = 0; column < 3 ;column++) {
	        		if(e.getSource() == blocks[row][column]) {
	        			position.add(row);
	        			position.add(column);
	        		}
	        }
    	}
    	return position;
    }
  
    public void update(int row, int column, char symbol, String message) {
		blocks[row][column].setText(Character.toString(symbol));
		blocks[row][column].setEnabled(false);
		playerturn.setText(message);
    }

    public void isWinner(int row, int col, char symbol, String message) {
		blocks[row][col].setText(Character.toString(symbol));
		blocks[row][col].setEnabled(false);
		for(int i = 0; i < 3; i++) {
	        for(int j = 0; j < 3; j++) {
	        	blocks[i][j].setEnabled(false);
	        }
		}
		playerturn.setText(message);
    }

    public void resetGame() {
    	for(int row = 0; row < 3; row++) {
            for(int column = 0; column < 3; column++) {
                blocks[row][column].setText("");
                blocks[row][column].setEnabled(true);
            }
        }
        playerturn.setText("Player 1 to play 'X'");
    }
    
    // getter function to check value of a button on the grid
    public String getButtonText(int i, int j) {
    	return blocks[i][j].getText();
    }
 
}