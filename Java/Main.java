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
		System.out.println("Welcome! Let's play Tic Tac Toe...");
		Game game = new Game();
		System.out.println(game.getTurn());
		game.getMove();
		game.printState();
		game.move(1,0);
		game.printState();
	}
}
