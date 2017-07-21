/**
 * @author Henry Harris
 */
public class Main {
    public static void main(String args[]) 
    {
        GUI gui = new GUI();
        
        gui.setText("Welcome! Let's play!");
        
        Game game = new Game(gui);
        // While the game is being played, continously print state 
        // and ask for new move
        Thread t = new Thread(game);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            exitWithForce();
        }
        
        // Did the game break, or finish naturally
        if (game.getStatus() != GameStatus.BROKEN) {
            char winner = game.getWinner();

            if (winner == '_') {
                gui.setText("Draw, play again!");
            } else {
                gui.setText(winner + " won!");
            }
        } else {
            // Idk what the hell happened
            gui.tellTheUserWeAreSorry();
            exitWithForce();
        }
    }
    
    /**
     * DA fuck happened?
     */
    private static void exitWithForce() {
        System.err.println("Something really fucked up... and we have no clue what.");
        System.exit(0);
    }
}
