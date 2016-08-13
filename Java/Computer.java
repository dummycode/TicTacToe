/**
 * Copyright 104101110114121
 */

/**
 * Class Board
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Computer {
	char player;
	Game game;
	
	/**
	 * Initialize a new computer
	 */
	Computer(char p, Game game) 
	{
		player = p;
		this.game = game;
	}
	
	/**
	 * Gets the computers move
	 * 
	 * @param char[][]
	 *
	 * @return int[]
	 */
	int[] getMove() 
	{
		// Get the state of the game
		char state[][] = game.getBoard().getState();
		int move[];
		/**
		 * Run through algorithm
		 */
		// Can we win? If so, do it
		move = canWin(state);
		if(move != null)
			return move;
		
		// Are we about to lose? If so, block it
		move = canLose(state);
		if(move != null)
			return move;
		
	
		return move;
	}
	
	/**
	 * Returns the player of the computer
	 * 
	 * @return char
	 */
	char getPlayer() 
	{
		return player;
	}
	
	/**
	 * Returns the player of the opponent
	 */
	char getOpponent()
	{
		return getPlayer() == 'X' ? 'O' : 'X';
	}
	
	/**
	 * Checks to see if the player can win
	 * 
	 * @param char[][]
	 * 
	 * @return boolean
	 */
	int[] canWin(char[][] state)
	{
		/*
		 *  Cycle through rows, columns, and diagonals to see if we have 2 out of 3 for any of them
		 */
		int rank = 0;
		int[] winningMove = new int[2];
		// Rows
		for(int row = 0; row < 3; row++) {
			for(int i = 0; i < 3; i++) {
				if (state[row][i] == this.getPlayer()) {
					rank++;;
				} else if(state[row][i] == this.getOpponent()) {
					rank--;
				} else {
					// Store possible winning move
					winningMove[0] = row;
					winningMove[1] = i;
				}
			}
			// If we hold 2 out of 3, and last one is empty, we can win this shit
			if(rank == 2)
				return winningMove;
		}
		rank = 0;
		// Columns
		for(int col = 0; col < 3; col++) {
			for(int i = 0; i < 3; i++) {
				if (state[i][col] == this.getPlayer()) {
					rank++;;
				} else if(state[i][col] == this.getOpponent()) {
					rank--;
				} else {
					// Store possible winning move
					winningMove[0] = i;
					winningMove[1] = col;
				}
			}
			// If we hold 2 out of 3, and last one is empty, we can win this shit
			if(rank == 2)
				return winningMove;
		}
		rank = 0;
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[i][i] == this.getPlayer()) {
				rank++;;
			} else if(state[i][i] == this.getOpponent()) {
				rank--;
			} else {
				// Store possible winning move
				winningMove[0] = i;
				winningMove[1] = i;
			}
		}
		// If we hold 2 out of 3, and the last one is empty, we can win this shit
		if(rank == 2)
			return winningMove;
		// Other diagonal
		rank = 0;
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[2-i][i] == this.getPlayer()) {
				rank++;;
			} else if(state[2-i][i] == this.getOpponent()) {
				rank--;
			} else {
				// Store possible winning move
				winningMove[0] = 2 - i;
				winningMove[1] = i;
			}
		}
		// If we hold 2 out of 3, and the last one is empty, we can win this shit
		if(rank == 2)
			return winningMove;
		
		return null;
	}
	
	/**
	 * Checks to see if the computer is about to lose
	 * 
	 * @param char[][]
	 * 
	 * @return boolean
	 */
	int[] canLose(char[][] state)
	{
		/*
		 *  Cycle through rows, columns, and diagonals to see if we have 2 out of 3 for any of them
		 */
		int rank = 0;
		int[] savingMove = new int[2];
		// Rows
		for(int row = 0; row < 3; row++) {
			for(int i = 0; i < 3; i++) {
				if (state[row][i] == this.getPlayer()) {
					rank++;;
				} else if(state[row][i] == this.getOpponent()) {
					rank--;
				} else {
					// Store possible winning move
					savingMove[0] = row;
					savingMove[1] = i;
				}
			}
			// If they hold 2 out of 3, and the last one is empty, we gotta block em
			if(rank == -2)
				return savingMove;
		}
		rank = 0;
		// Columns
		for(int col = 0; col < 3; col++) {
			for(int i = 0; i < 3; i++) {
				if (state[i][col] == this.getPlayer()) {
					rank++;;
				} else if(state[i][col] == this.getOpponent()) {
					rank--;
				} else {
					// Store possible winning move
					savingMove[0] = i;
					savingMove[1] = col;
				}
			}
			// If they hold 2 out of 3, and the last one is empty, we gotta block em
			if(rank == -2)
				return savingMove;
		}
		rank = 0;
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[i][i] == this.getPlayer()) {
				rank++;;
			} else if(state[i][i] == this.getOpponent()) {
				rank--;
			} else {
				// Store possible winning move
				savingMove[0] = i;
				savingMove[1] = i;
			}
		}
		// If they hold 2 out of 3, and the last one is empty, we gotta block em
		if(rank == -2)
			return savingMove;
		// Other diagonal
		rank = 0;
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[2-i][i] == this.getPlayer()) {
				rank++;;
			} else if(state[2-i][i] == this.getOpponent()) {
				rank--;
			} else {
				// Store possible winning move
				savingMove[0] = 2 - i;
				savingMove[1] = i;
			}
		}
		// If they hold 2 out of 3, and the last one is empty, we gotta block em
		if(rank == -2)
			return savingMove;
		
		return null;
	}
}
