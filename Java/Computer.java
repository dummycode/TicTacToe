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
	
	Computer() 
	{
		player = 'X';
		System.out.println("Initializing computer...");
	}
	
	/**
	 * Gets the computers move
	 * 
	 * @param char[][]
	 *
	 * @return int[]
	 */
	int[] getMove(char[][] state) 
	{
		int[] move = {1, 0};
		return move;
	}
	
	char getPlayer() 
	{
		return player;
	}
	
}
