/**
 * @author Henry Harris
 */
public class Computer 
{
    final private Brain brain;
    final private char player;
    
    public Computer(char player) 
    {
        brain = new Brain(this);
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
        // Call Brain's minimax to get best move
        int[] move = brain.getMove(state);
        return move;
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
