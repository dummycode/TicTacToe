/**
 * Copyright 104101110114121
 */

/**
 * Class Board
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Board 
{
	char state[][] = {{'_', '_', '_'},{'_', '_', '_'},{'_', '_', '_'}};
	
	/**
	 * Initialize a new board
	 */
	Board() 
	{
		// Do nothing
	}
	
	/**
	 * Get current state of board
	 * 
	 * @return char[][]
	 */
	char[][] getState()
	{
		return state;
	}
	
	/**
	 * Print the state of the board
	 */
	void printState()
	{
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.println("\n");
		}
	}
	
	/**
	 * Move given player to given spot, returns true || false on success
	 * 
	 * @param player
	 * @param row
	 * @param column
	 * 
	 * @return boolean
	 */
	boolean move(char player, int row, int column) 
	{
		if(state[row][column] == '_') {
			state[row][column] = player;
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Checks to see if board is completely filled
	 * 
	 * @return boolean
	 */
	boolean isFull() 
	{
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(state[i][j] == '_')
					return false;
		return true;
	}
}
