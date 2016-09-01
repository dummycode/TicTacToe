/**
 * Copyright 104101110114121
 */

/**
 * Class Computer
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Computer {
	char player;
	Game game;
	Brain brain;
	
	/**
	 * Initialize a new computer
	 */
	Computer(char player, Game game) 
	{
		// Give it a brain
		this.brain = new Brain(this);
		// Initialize other variables
		this.player = player;
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
		// Ask the brain if we can win. If so, do it
		move = brain.canWin(state);
		if(move != null)
			return move;
		
		// Ask the brain if we are about to lose. If so, block it
		move = brain.canLose(state);
		if(move != null)
			return move;
		
		// Ask the brain if we can fork the opponent. If so, play the move
		move = brain.canFork(state);
		if(move != null)
			return move;

		// Ask the brain if we are about to get forked. If so, block that shit
		move = brain.canGetForked(state);
		if(move != null)
			return move;
		
		// Ask the brain if the center is open. If it is, take it
		move = brain.shouldTakeCenter(state);
		if(move != null)
			return move;
		
		// Ask the brain if the player is in a corner, if they are, take opposite
		move = brain.shouldTakeCorner(state);
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
	 * Sets the player of the computer
	 *
	 * @return char
	 */
	void setPlayer(char c)
	{
		player = c;
	}
}
