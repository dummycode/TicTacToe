/**
 * Copyright 104101110114121
 */

/**
 * Class Brain
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Brain {
	Computer computer;
	
	/**
	 * Initialize a new brain for a computer
	 */
	Brain(Computer computer) 
	{
		this.computer = computer;
	}
	
	/**
	 * Brain logic to check to see if a computer can win
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
				if (state[row][i] == computer.getPlayer()) {
					rank++;;
				} else if(state[row][i] == computer.getOpponent()) {
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
			rank = 0;
		}
		
		// Columns
		for(int col = 0; col < 3; col++) {
			for(int i = 0; i < 3; i++) {
				if (state[i][col] == computer.getPlayer()) {
					rank++;;
				} else if(state[i][col] == computer.getOpponent()) {
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
			rank = 0;
		}
		
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[i][i] == computer.getPlayer()) {
				rank++;;
			} else if(state[i][i] == computer.getOpponent()) {
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
		rank = 0;
		
		// Other Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[2-i][i] == computer.getPlayer()) {
				rank++;;
			} else if(state[2-i][i] == computer.getOpponent()) {
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
				if (state[row][i] == computer.getPlayer()) {
					rank++;;
				} else if(state[row][i] == computer.getOpponent()) {
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
			rank = 0;
		}
		// Columns
		for(int col = 0; col < 3; col++) {
			for(int i = 0; i < 3; i++) {
				if (state[i][col] == computer.getPlayer()) {
					rank++;;
				} else if(state[i][col] == computer.getOpponent()) {
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
			rank = 0;
		}
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[i][i] == computer.getPlayer()) {
				rank++;;
			} else if(state[i][i] == computer.getOpponent()) {
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
			if (state[2-i][i] == computer.getPlayer()) {
				rank++;;
			} else if(state[2-i][i] == computer.getOpponent()) {
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
	
	/**
	 * Checks to see if the computer can fork the opponent
	 * Can create two ways to win
	 * 
	 * @param state
	 * 
	 * @return int[]
	 */
	int[] canFork(char[][] state)
	{
		char[][] tempState = new char[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tempState[i][j] = state[i][j];

		// If top left is open, possible forking spot!
		if(state[0][0] == '_') {
			int[] forkingMove = new int[2];
			int rank = 0;
			int forks = 0;
			// Take it
			tempState[0][0] = computer.getPlayer();
			// Can now win the row?
			for(int i = 0; i < 3; i++) {
				if(tempState[0][i] == computer.getPlayer())
					rank++;
				else if(tempState[0][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the column?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][0] == computer.getPlayer())
					rank++;
				else if(tempState[i][0] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the diagonal?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][i] == computer.getPlayer())
					rank++;
				else if(tempState[i][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			
			if(forks >= 2) {
				forkingMove[0] = 0;
				forkingMove[1] = 0;
				return forkingMove;
			}
		}
		
		tempState = new char[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tempState[i][j] = state[i][j];

		// If top right is open, possible forking spot!
		if(state[0][2] == '_') {
			int[] forkingMove = new int[2];
			int rank = 0;
			int forks = 0;
			// Take it
			tempState[0][2] = computer.getPlayer();
			// Can now win the row?
			for(int i = 0; i < 3; i++) {
				if(tempState[0][i] == computer.getPlayer())
					rank++;
				else if(tempState[0][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the column?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][2] == computer.getPlayer())
					rank++;
				else if(tempState[i][2] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the diagonal?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][2 - i] == computer.getPlayer())
					rank++;
				else if(tempState[i][2 - i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			
			if(forks >= 2) {
				forkingMove[0] = 0;
				forkingMove[1] = 2;
				return forkingMove;
			}
		}
		
		tempState = new char[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tempState[i][j] = state[i][j];

		// If bottom left is open, possible forking spot!
		if(state[2][0] == '_') {
			int[] forkingMove = new int[2];
			int rank = 0;
			int forks = 0;
			// Take it
			tempState[2][0] = computer.getPlayer();
			// Can now win the row?
			for(int i = 0; i < 3; i++) {
				if(tempState[2][i] == computer.getPlayer())
					rank++;
				else if(tempState[2][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the column?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][0] == computer.getPlayer())
					rank++;
				else if(tempState[i][0] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the diagonal?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][2 - i] == computer.getPlayer())
					rank++;
				else if(tempState[i][2 - i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			
			if(forks >= 2) {
				forkingMove[0] = 2;
				forkingMove[1] = 0;
				return forkingMove;
			}
		}
		
		tempState = new char[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tempState[i][j] = state[i][j];

		// If bottom right is open, possible forking spot!
		if(state[2][2] == '_') {
			int[] forkingMove = new int[2];
			int rank = 0;
			int forks = 0;
			// Take it
			tempState[2][2] = computer.getPlayer();
			// Can now win the row?
			for(int i = 0; i < 3; i++) {
				if(tempState[2][i] == computer.getPlayer())
					rank++;
				else if(tempState[2][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the column?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][2] == computer.getPlayer())
					rank++;
				else if(tempState[i][2] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the diagonal?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][i] == computer.getPlayer())
					rank++;
				else if(tempState[i][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			
			if(forks >= 2) {
				forkingMove[0] = 2;
				forkingMove[1] = 0;
				return forkingMove;
			}
		}
		
		// TODO add middle square as a possible forking spot
		tempState = new char[3][3];
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				tempState[i][j] = state[i][j];

		// If middle is open, possible forking spot!
		if(state[1][1] == '_') {
			int[] forkingMove = new int[2];
			int rank = 0;
			int forks = 0;
			// Take it
			tempState[1][1] = computer.getPlayer();
			// Can now win the row?
			for(int i = 0; i < 3; i++) {
				if(tempState[1][i] == computer.getPlayer())
					rank++;
				else if(tempState[1][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the column?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][1] == computer.getPlayer())
					rank++;
				else if(tempState[i][1] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the diagonal?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][i] == computer.getPlayer())
					rank++;
				else if(tempState[i][i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			rank = 0;
			// Can now win the other diagonal?
			for(int i = 0; i < 3; i++) {
				if(tempState[i][2 - i] == computer.getPlayer())
					rank++;
				else if(tempState[i][2 - i] == computer.getOpponent())
					rank--;
			}
			if(rank == 2)
				forks++;
			
			if(forks >= 2) {
				forkingMove[0] = 1;
				forkingMove[1] = 1;
				return forkingMove;
			}
		}

		return null;
	}
	
	/**
	 * Checks to see if the player can fork the computer
	 * Can the opponent create two ways to win
	 * 
	 * @param state
	 * 
	 * @return int[]
	 */
	int[] canGetForked(char[][] state)
	{
		// Temporarily reverse roles to think as player
		computer.setPlayer(computer.getOpponent());
		int[] playersForkingMove = this.canFork(state);
		
		// Back to original roles
		computer.setPlayer(computer.getOpponent());
		
		// Check to see if the player can make a fork next move
		if (playersForkingMove != null) {
			System.out.println("Player can fork!");
			
			// We need to find a spot to force the player to block next move
			int[] blockingMove = getBlockingMove(state);
			
			System.out.println(playersForkingMove[0] + "," + playersForkingMove[1]);
			if (blockingMove != null)
				System.out.println(blockingMove[0] + "," + blockingMove[1]);
		}

		return null;
	}
	
	/**
	 * Returns the move the computer needs to make to block a potential fork
	 * 
	 * @param state
	 * 
	 * @return
	 */
	int[] getBlockingMove(char[][] state)
	{
		/*
		 *  Cycle through rows, columns, and diagonals to see if we have 2 out of 3 for any of them
		 */
		int rank = 0;
		int[] blockingMove = new int[2];
		
		// Rows
		for(int row = 0; row < 3; row++) {
			for(int i = 0; i < 3; i++) {
				if (state[row][i] == computer.getPlayer()) {
					rank++;;
				} else if(state[row][i] == computer.getOpponent()) {
					rank += 2;
				} else {
					// Store possible forcing move
					blockingMove[0] = row;
					blockingMove[1] = i;
				}
			}
			// If we hold 1 out of 3, and last two are empty, we can use this to force the 
			// player to block us, so he is unable to fork
			if(rank == 1)
				return blockingMove;
			rank = 0;
		}
		
		// Columns
		for(int col = 0; col < 3; col++) {
			for(int i = 0; i < 3; i++) {
				if (state[i][col] == computer.getPlayer()) {
					rank++;;
				} else if(state[i][col] == computer.getOpponent()) {
					rank += 2;
				} else {
					// Store possible forcing move
					blockingMove[0] = i;
					blockingMove[1] = col;
				}
			}
			// If we hold 1 out of 3, and last two are empty, we can use this to force the 
			// player to block us, so he is unable to fork
			if(rank == 1)
				return blockingMove;
			rank = 0;
		}
		
		// Diagonal
		for(int i = 0; i < 3; i++) {
			if (state[i][i] == computer.getPlayer()) {
				rank++;;
			} else if(state[i][i] == computer.getOpponent()) {
				rank += 2;
			} else {
				// Store possible forcing move
				blockingMove[0] = i;
				blockingMove[1] = i;
			}
		}
		// If we hold 1 out of 3, and last two are empty, we can use this to force the 
		// player to block us, so he is unable to fork
		if(rank == 1)
			return blockingMove;
		rank = 0;
		
		// Other diagonal
		for(int i = 0; i < 3; i++) {
			if (state[2-i][i] == computer.getPlayer()) {
				rank++;;
			} else if(state[2-i][i] == computer.getOpponent()) {
				rank += 2;
			} else {
				// Store possible forcing move
				blockingMove[0] = 2 - i;
				blockingMove[1] = i;
			}
		}
		// If we hold 1 out of 3, and last two are empty, we can use this to force the 
		// player to block us, so he is unable to fork
		if(rank == 1)
			return blockingMove;
		
		return null;
	}
	
	/**
	 * Logic to check if center is open
	 * We are going to take it, unless it's the first move of the game
	 * 
	 * @param state
	 * 
	 * @return
	 */
	int[] shouldTakeCenter(char[][] state)
	{
		if(state[1][1] == '_') {
			for(int i = 0; i < 3; i++)
				for(int j = 0; j < 3; j++)
					if(state[i][j] != '_') {
						int[] centerMove = {1, 1};
						return centerMove;
					}
		}
		return null;
	}
}
