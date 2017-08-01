/**
 * @author Henry Harris
 */
public class Main {
    /** GUI for the game */
    private static final GUI gui = new GUI();

    public static void main(String args[]) 
    {
        gui.setText("Welcome! Let's play!");
        
        Game game = new Game(gui);
        // While the game is being played, continuously print state
        // and ask for new move
        Thread t = new Thread(game);

        // Handle exceptions
        Thread.UncaughtExceptionHandler h = new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread th, Throwable ex) {
                System.out.println(ex.getMessage());
                exitWithForce();
            }
        };

        t.start();
        t.setUncaughtExceptionHandler(h);

        try {
            t.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
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
            exitWithForce();
        }
    }
    
    /**
     * DA fuck happened?
     */
    private static void exitWithForce() {
        gui.tellTheUserWeAreSorry();
        System.err.println("Something really fucked up... and we have no clue what.");
        System.exit(0);
    }
}
