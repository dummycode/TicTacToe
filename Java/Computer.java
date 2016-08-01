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
		/**
		 * Run through algorithm
		 */
		boolean canWin = canWin(state);
		if(canWin)
			System.out.println("Can Win!");
		int[] move = {1, 0};
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
	 * @return boolean
	 */
	boolean canWin(char[][] state)
	{
		/*
		 *  Cycle through rows, columns, and diagonals to see if we have 2 out of 3 for any of them
		 */
		int rank = 0;
		// Rows
		for(int row = 0; row < 3; row++) {
			for(int i = 0; i < 3; i++) {
				if (state[row][i] == this.getPlayer()) {
					rank++;;
				} else if(state[row][i] == this.getOpponent()) {
					rank--;
				} else {
					// Do nothing
				}
			}
			// If we hold 2 out of 3, and last one is empty, we can win this shit
			if(rank == 2)
				return true;
		}
		// Columns
		for(int col = 0; col < 3; col++) {
			for(int i = 0; i < 3; i++) {
				if (state[i][col] == this.getPlayer()) {
					rank++;;
				} else if(state[i][col] == this.getOpponent()) {
					rank--;
				} else {
					// Do nothing
				}
			}
			// If we hold 2 out of 3, and last one is empty, we can win this shit
			if(rank == 2)
				return true;
		}
		// Diagonal
		// TODO IMPLEMENT
//		for(int i = 0; i < 3; i++) {
//			if (state[i][i] == this.getPlayer()) {
//				rank++;;
//			} else if(state[i][i] == this.getOpponent()) {
//				rank--;
//			} else {
//				// Do nothing
//			}
//		}
		// Other diagonal
		
		return false;
	}
	
}
