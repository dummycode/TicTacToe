/**
 * @author Henry Harris
 */
public class Main {
    public static void main(String args[]) 
    {
        System.out.println("Welcome! Let's play Tic Tac Toe...");
        
        GUI gui = new GUI();
        
        Game game = new Game(gui);
        // While the game is being played, continously print state 
        // and ask for new move
        while(game.getStatus() == GameStatus.IN_PROGRESS) {
            game.getMove();
        }
        // Did the game break, or finish naturally
        if (game.getStatus() != GameStatus.BROKEN) {
            game.printState();

            char winner = game.getWinner();

            if (winner == '_') {
                gui.setText("Draw, play again!");
            } else {
                gui.setText(winner + " won!");
            }
        } else {
            // Idk what the hell happened
            System.out.println("That was embarrassing...\nPlay again!");
        }
    }
}
