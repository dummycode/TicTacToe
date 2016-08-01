/**
 * Copyright 104101110114121
 */

/**
 * Class Main
 * 
 * @author Henry Harris <henry@104101110114121.com>
 */
public class Main 
{
	public static void main(String args[])
	{
		System.out.println("Welcome! Let's play Tic Tac Toe...\n");
		
		Game game = new Game();
		GameStatus gameStatus = new GameStatus();
		System.out.println(game.getTurn() + " goes first!\n");
		
		while(game.getStatus() == gameStatus.IN_PROGRESS ) {
			game.printState();
			game.getMove();
		}
		
		game.printState();
		try {
			char winner = game.getWinner();
			if(winner == '_')
				System.out.println("Draw :(\nPlay again!");
			else
				System.out.println(winner + " won!");
		} catch(Exception e) {
			System.out.println("Sheiiittt.... Something really broke about getting the winner.\nExiting.");
			System.out.println(e);
			System.exit(0);
		}
	}
}
