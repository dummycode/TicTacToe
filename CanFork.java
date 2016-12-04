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
