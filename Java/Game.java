/**
 * Copyright 104101110114121
 */
import java.util.Random;
/**
 * Class Game
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Game 
{
	Board board;
	char turn;
	Computer computer;
	
	/**
	 * Initialize a new game
	 * 
	 * @method game
	 */
	Game() 
	{
		board = new Board();
		computer = new Computer();
		setFirstTurn();
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
	void move(int row, int column)
	{
		if(row > 2 || row < 0 || column > 2 || column < 0) {
			System.out.println("Error! Invalid spot.");
		}
		else {
			if(board.move(getTurn(), row, column)) {
				nextTurn();
				System.out.println("Moved.");
			}
			else {
				System.out.println("Spot taken! Try again...");
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
	
	void getMove() 
	{
		if(computer.getPlayer() == turn) {
			int[] computersMove = computer.getMove(board.getState());
			move(computersMove[0], computersMove[1]);
		} 
	}
}
