/**
 * @author Henry Harris
 */
public class Main {
    public static void main(String args[]) 
    {
        System.out.println("Welcome! Let's play Tic Tac Toe...");
        
        Game game = new Game();
        // While the game is being played, continously print state 
        // and ask for new move
        while(game.getStatus() == GameStatus.IN_PROGRESS) {
            game.printState();
            game.getMove();
        }
        // Did the game break, or finish naturally
        if (game.getStatus() != GameStatus.BROKEN) {
            game.printState();

            char winner = game.getWinner();

            if (winner == '_') {
                System.out.println("Draw, play again!");
            } else {
                System.out.println(winner + " won!");
            }
        } else {
            // Idk what the hell happened
            System.out.println("That was embarrassing...\nPlay again!");
        }
    }
}
