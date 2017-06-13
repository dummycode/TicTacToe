/**
 * @author Henry Harris
 */
public class Board 
{
    // Instance variable for the current state
    private final char state[][] = {
        {'_', '_', '_'}, 
        {'_', '_', '_'}, 
        {'_', '_', '_'}
    };
    
    /**
     * Get current state of board
     * 
     * @return 
     */
    public char[][] getState() 
    {
        char[][] copyOfState = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                copyOfState[i][j] = state[i][j];
            }
        }
        return copyOfState;
    }
    
    /**
     * Move a given player to a given spot, returns success
     * 
     * @param player
     * @param row
     * @param col
     * 
     * @return 
     */
    public boolean move(char player, int row, int col)
    {
        if (state[row][col] == '_') {
            state[row][col] = player;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Check to see if the board is full
     * 
     * @return 
     */
    public boolean isFull() 
    {
        for (char[] row : state) {
            for (char value : row) {
                if (value == '_') {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Convert Board object to String
     * 
     * @return 
     */
    @Override
    public String toString() 
    {
        String board = "";
        for(int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[i].length; j++) {
                board += " " + (state[i][j] == '_' ? " " : state[i][j]) + " " + (j == 2 ? "" : "|");
            }
            if (i < 2) {
                board += "\n_ _ _ _ _ _\n";
            }
        }
        return board;
    }
}
