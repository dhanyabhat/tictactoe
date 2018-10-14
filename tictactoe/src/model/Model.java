package model;

/** The model class has the current state of the game
 * as well as the logic to decide who the winner is. 
 * */

import view.*;

public class Model {
	private View v;
	private int playerId;
	private int movesCount;
	private char[][] board;
	private String msg;

	public Model() {
		this.board = new char[3][3];
		this.movesCount = 9;
		this.playerId = 1;
	}
	
	// initializing the reference of the view class
	public void registerView(View v) {
		this.v = v;
	}

	//setter and getter methods for the variables
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getMovesCount() {
		return movesCount;
	}

	public void setMovesCount(int movesCount) {
		this.movesCount = movesCount;
	}

	public char[][] getBoard() {
		return board;
	}

	public void setBoard(char[][] board) {
		this.board = board;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String message) {
		this.msg = message;
	}

	// update board model
	public void PlayMove(int x, int y) {
		
		if(getMovesCount() > 0){
			// mark on the board with 'X' or 'O' depending on playerId
			if(playerId % 2 != 0) 
				board[x][y] = 'X';
			else 
				board[x][y] = 'O';
			
			// decrease the count of moves left
			setMovesCount(--movesCount);
			
			// check if playerId won or if game is tied
			if(isWinner(x, y)) {
				setMsg("Player " + playerId + " is Winner!");
				v.isWinner(x, y, board[x][y], getMsg());
			}
			else if(getMovesCount()==0) {
				setMsg("No Winner! Game ended in a tie");
				v.isWinner(x, y, board[x][y], getMsg());
			}
			else {
				if(playerId%2 != 0) {
					// toggle the playerId
					setPlayerId(2);
					setMsg("'O':  Player " +getPlayerId());
				}
				else {
					setPlayerId(1);
					setMsg("'X':  Player " +getPlayerId());
				}
				// update the board with a message for the next player's turn
				v.update(x, y, board[x][y], getMsg());
			}
			
		}
		
	}
	
	// function to check if there is a winner
	public boolean isWinner(int x, int y) {
		int countRow = 0;
		int countCol = 0;
		int countLDiag = 0;
		int countRDiag = 0;
		char symbol;
		if(getPlayerId() %2 !=0)
			symbol = 'X';
		else
			symbol = 'O';
		
		for(int i=0; i<board.length;i++) {
			if(board[x][i] == symbol)
				countRow++;
			if(board[i][y] == symbol)
				countCol++;
			if(board[i][i] == symbol)
				countRDiag++;
			if(board[board.length-1-i][i] == symbol)
				countLDiag++;	
		}
		
		if(countCol==board.length || countRow==board.length 
		   || countLDiag == board.length || countRDiag == board.length)
			return true;
		
		return false;
	}

	// function to clear the model and reset it to its initial state
	public void ResetModel() {
		movesCount = 9;
		setPlayerId(1);
		setMsg("");
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board.length;j++) {
				board[i][j] = '\0';
			}
		}
		v.resetGame();
	}
		
}