/**
 * @author Henry Harris
 */
public class Computer 
{
    final private Brain brain;
    final private char player;
    
    Computer(char player, Difficulty difficulty)
    {
        brain = new Brain(this, difficulty);
        this.player = player;
    }
    
    /**
     * Get the computer's move
     * 
     * @param state
     * 
     * @return 
     */
    public int[] getMove(char[][] state) 
    {
        // Imitate the computer "thinking"
        try {
            Thread.sleep(750);
        } catch (InterruptedException ie) {
            System.err.println("Could not think!");
        }
        // Get brain's move
        return brain.getMove(state);
    }
    
    /**
     * Get what player the computer is
     * 
     * @return
     */
    public char getPlayer()
    {
        return player;
    }
    
        
    /**
     * Get what player the opponent is
     * 
     * @return
     */
    public char getOpponent()
    {
        return player == 'X' ? 'O' : 'X';
    }
}
