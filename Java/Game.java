/**
 * Copyright 104101110114121
 */
import java.util.Random;
import java.util.Scanner;
/**
 * Class Game
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Game 
{
	Board board;
	char turn;
	String status;
	Computer computer;
	Scanner scanner;
	GameStatus gameStatus;
	char winner;
	
	/**
	 * Initialize a new game
	 */
	Game() 
	{
		board = new Board();
		computer = new Computer('X', this);
		gameStatus = new GameStatus();
		scanner = new Scanner(System.in);
		setFirstTurn();
		status = gameStatus.IN_PROGRESS;
		winner = '_';
	}
	
	/**
	 * Set the first turn randomly
	 */
	void setFirstTurn()
	{
		Random r = new Random();
		turn = r.nextBoolean() ? 'X' : 'O';
	}
	
	/**
	 * Get current turn
	 * 
	 * @return char
	 */
	char getTurn()
	{
		return turn;
	}
	
	/**
	 * Print the state of the game
	 */
	void printState()
	{
		board.printState();
	}
	
	/**
	 * Move current player to given position
	 * 
	 * @param row
	 * @param column
	 */
	boolean move(int row, int col)
	{	
		if(row > 2 || row < 0 || col > 2 || col < 0) {
			System.out.println("Error! Invalid spot.");
			return false;
		}
		else {
			if(board.move(getTurn(), row, col)) {
				System.out.println("Moved.");
				return true;
			}
			else {
				System.out.println("Spot taken! Try again...");
				return false;
			}
		}
	}
	
	/**
	 * Change turn to next player
	 */
	void nextTurn() 
	{
		if(turn == 'X')
			turn = 'O';
		else
			turn = 'X';
				
	}
	
	/**
	 * Get general move, route to player or computer
	 */
	void getMove() 
	{
		int[] move;
		// Get the move based on if it's the computer's or player's turn
		if(computer.getPlayer() == turn) {
			System.out.println("Computer.");
			int[] winningMove = computer.canWin(board.getState());
			int[] losingMove = computer.canLose(board.getState());
			boolean canWin = winningMove != null;
			boolean canLose = losingMove != null;
			if(canWin) {
				System.out.println((winningMove[1] + 1) + "," + (winningMove[0] + 1));
				move = computer.getMove();
			} else if(canLose) {
				System.out.println((losingMove[1] + 1) + "," + (losingMove[0] + 1));
				move = computer.getMove();
			} else {
				move = getPlayersMove(); //TODO switch back to getComputersMove
			}
		} else {
			System.out.println("Player.");
			move = getPlayersMove();
		}
		// Make the move, store response
		boolean goodMove = move(move[0], move[1]);
		
		// If it was a good move, check winner and set next turn
		if(goodMove) {
			if(isOver(move)) {
				this.winner = getTurn();
				this.status = gameStatus.OVER;
			}
			if(isDraw()) {
				this.status = gameStatus.OVER;
			}
				
			nextTurn();
		}
	}
	
	/**
	 * Gets the player's move
	 */
	//TODO add bad input handling and bad ranges
	int[] getPlayersMove()
	{
		System.out.print("Enter move: ");
		String move = scanner.next();
		
		String[] parts = move.split(",");
		// Subtract 1 because index of array starts at 0
		int column = Integer.parseInt(parts[0]) - 1;
		int row = Integer.parseInt(parts[1]) - 1;
		
		int[] array = {row, column};
		return array;
	}
	
	/**
	 * Gets the computer's move
	 */
	int[] getComputersMove()
	{
		return computer.getMove();
	}

	String getStatus() {
		return status;
	}
	
	/**
	 * 
	 * @param lastMove (passed as row, column)
	 * 
	 * @return
	 */
	boolean isOver(int[] lastMove) {
		char state[][] = board.getState();
//		if(state[0][0] != '_')
//			return true;
		
		// Check if column is a 3 in a row
		if(state[0][lastMove[1]] == this.turn &&
				state[1][lastMove[1]] == this.turn &&
				state[2][lastMove[1]] == this.turn)
			return true;
		// Check if row is a 3 in a row
		if(state[lastMove[0]][0] == this.turn &&
				state[lastMove[0]][1] == this.turn &&
				state[lastMove[0]][2] == this.turn)
			return true;
		// Check if 3 in a row in diagonal
		if(lastMove[0] == lastMove[1] &&
				state[0][0] == this.turn &&
				state[1][1] == this.turn &&
				state[2][2] == this.turn)
			return true;
		// Check if 3 in a row in other diagonal
		if(lastMove[0] + lastMove[1] == 2 &&
				state[2][0] == this.turn &&
				state[1][1] == this.turn &&
				state[0][2] == this.turn)
			return true;
		
		// No winner
		return false;
	}
	
	boolean isDraw() {
		// If the board is full, it's a draw
		return board.isFull();
	}
	
	/**
	 * This method gets the winner of the game
	 * If called and the game isn't over, it throws an exception, because there is no winner
	 * 
	 * @throws Exception
	 * 
	 * @return char 
	 */
	char getWinner() throws Exception {
		// The game isn't over... something broke
		if(this.status != gameStatus.OVER) {
			throw new Exception();
		}
		return this.winner;
	}
	
	/**
	 * Returns the board of the game
	 * 
	 * @return Board
	 */
	Board getBoard()
	{
		return this.board;
	}
	
}
