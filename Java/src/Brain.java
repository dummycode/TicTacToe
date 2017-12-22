import java.util.Random;

/**
 * @author henry
 */
public class Brain
{
    // Computer the Brain represents
    final private Computer computer;
    final private Random random = new Random();
    private Difficulty difficulty;

    /**
     * Constructor
     * 
     * @param computer 
     */
    Brain(Computer computer, Difficulty difficulty) {
        this.computer = computer;
        this.difficulty = difficulty;
    }

    /**
     * Get move
     *
     * @param state
     *
     * @return
     */
    public int[] getMove(char[][] state) {
        switch(this.difficulty) {
            case EASY:
                return getEasyMove(state);
            case MEDIUM:
                return getMediumMove(state);
            case HARD:
                return getHardMove(state);
            default:
                return getHardMove(state);
        }
    }

    /**
     * Gets a random move, winning if possible
     *
     * @param state
     *
     * @return
     */
    private int[] getEasyMove(char[][] state) {
        int[] winningMove = canWin(state);
        if (winningMove != null) {
            return winningMove;
        }
        return getRandomMove(state);
    }

    /**
     * Gets either a random move or the best move, winning if possible
     *
     * @param state
     *
     * @return
     */
    private int[] getMediumMove(char[][] state) {
        return random.nextInt(4) < 3 ? getHardMove(state) : getEasyMove(state);
    }


    /**
     * Get the best move given a state
     * 
     * @param state
     * 
     * @return 
     */
    private int[] getHardMove(char[][] state) {
        int[] bestMove = {-1, -1};
        int[][] bestMoves = new int[0][2];
        int bestVal = -1000;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Is cell empty?
                if (state[i][j] == '_') {
                    state[i][j] = computer.getPlayer();
                    
                    // Compute eval for this move
                    int moveVal = minimax(state, 0, false);
                    
                    state[i][j] = '_';
                
                    // If even, save it to list of best moves
                    if (moveVal == bestVal) {
                        int[][] temp = new int[bestMoves.length + 1][2];
                        for (int x = 0; x < bestMoves.length; x++) {
                            for (int y = 0; y < 2; y++) {
                                temp[x][y] = bestMoves[x][y];
                            }
                        }
                        temp[bestMoves.length][0] = i;
                        temp[bestMoves.length][1] = j;
                        bestMoves = temp;
                    }
                    // If better best, it's the new best!
                    if (moveVal > bestVal) {
                        bestMove[0] = i;
                        bestMove[1] = j;
                        bestVal = moveVal;
                        
                        bestMoves = new int[1][2];
                        bestMoves[0][0] = i;
                        bestMoves[0][1] = j;
                    }
                }
            }
        }
        // If more than one, get one at random
        if (bestMoves.length > 1) {
            int randomIndex = random.nextInt(bestMoves.length - 1);
            bestMove = bestMoves[randomIndex];
        }
        
        return bestMove;
    }
    
    /**
     * Get all possible ways the game can go, and return score
     * 
     * @param state
     * @param depth
     * @param isMax
     * 
     * @return 
     */
    private int minimax(char[][] state, int depth, boolean isMax) {
        int score = evaluate(state);
        
        // Shorter wins are better
        if (score == 10) {
            return score - depth;
        }
        // Longer loses are better
        if (score == -10) {
            return score + depth;
        }
        // Draw?
        if (isFull(state)) {
            return 0;
        }
        
        if (isMax) {
            int best = -1000;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (state[i][j] == '_') {
                        // Make move
                        state[i][j] = computer.getPlayer();
                        // Eval new state
                        int recursiveMax = minimax(state, depth + 1, false);
                        best = Math.max(best, recursiveMax);
                        state[i][j] = '_';
                    }
                }
            }
            return best;
        } else {
            int best = 1000;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (state[i][j] == '_') {
                        // Make move
                        state[i][j] = computer.getOpponent();
                        // Eval new state
                        int recursiveMax = minimax(state, depth + 1, true);
                        best = Math.min(best, recursiveMax);
                        state[i][j] = '_';
                    }
                }
            } 
            return best;
        }
    }
    
    /**
     * Evaluate given state
     * 
     * @param state
     * 
     * @return 
     */
    private int evaluate(char[][] state) {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (state[row][0] == state[row][1] && state[row][0] == state[row][2]) {
                if (state[row][0] == computer.getPlayer()) {
                    return 10;
                } else if (state[row][0] == computer.getOpponent()) {
                    return -10;
                }
            }
        }
        
        // Check columns
        for (int col = 0; col < 3; col++) {
            if (state[0][col] == state[1][col] && state[1][col] == state[2][col]) {
                if (state[0][col] == computer.getPlayer()) {
                    return 10;
                } else if (state[0][col] == computer.getOpponent()) {
                    return -10;
                }
            }
        }
        
        // Check diagonals
        if (state[0][0] == state[1][1] && state[1][1] == state[2][2]) {
            if (state[0][0] == computer.getPlayer()) {
                return 10;
            } else if (state[0][0] == computer.getOpponent()) {
                return -10;
            }
        }
        // Check other diagonal
        if (state[0][2] == state[1][1] && state[1][1] == state[2][0]) {
            if (state[0][2] == computer.getPlayer()) {
                return 10;
            } else if (state[0][2] == computer.getOpponent()) {
                return -10;
            }
        } 
        return 0;
    }
    
    /**
     * Check to see if the board is full
     * 
     * @return 
     */
    private boolean isFull(char[][] state) 
    {
        for (char[] row : state) {
            for (char value : row) {
                // If no player, game still goes on!
                if (value == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Brain logic to check to see if a computer can win
     *
     * @param state
     *
     * @return
     */
    private int[] canWin(char[][] state) {
        /*
         *  Cycle through rows, columns, and diagonals to see if we have 2 out of 3 for any of them
         */
        int rank;
        int[] winningMove = new int[2];

        // Rows
        for(int row = 0; row < 3; row++) {
            rank = 0;
            for(int i = 0; i < 3; i++) {
                if (state[row][i] == computer.getPlayer()) {
                 rank++;
                } else if (state[row][i] == computer.getOpponent()) {
                    rank--;
                } else {
                    // Store possible winning move
                    winningMove[0] = row;
                    winningMove[1] = i;
                }
            }
            // If we hold 2 out of 3, and last one is empty, we can win this shit
            if (rank == 2) {
                return winningMove;
            }
        }

        // Columns
        for(int col = 0; col < 3; col++) {
            rank = 0;
            for (int i = 0; i < 3; i++) {
                if (state[i][col] == computer.getPlayer()) {
                    rank++;
                } else if (state[i][col] == computer.getOpponent()) {
                    rank--;
                } else {
                    // Store possible winning move
                    winningMove[0] = i;
                    winningMove[1] = col;
                }
            }
            // If we hold 2 out of 3, and last one is empty, we can win this shit
            if (rank == 2) {
                return winningMove;
            }
        }

        // Diagonal
        rank = 0;
        for(int i = 0; i < 3; i++) {
            if (state[i][i] == computer.getPlayer()) {
                rank++;
            } else if(state[i][i] == computer.getOpponent()) {
                rank--;
            } else {
                // Store possible winning move
                winningMove[0] = i;
                winningMove[1] = i;
            }
        }
        // If we hold 2 out of 3, and the last one is empty, we can win this shit
        if(rank == 2) {
            return winningMove;
        }

        // Other diagonal
        rank = 0;
        for(int i = 0; i < 3; i++) {
            if (state[2-i][i] == computer.getPlayer()) {
                rank++;
            } else if(state[2-i][i] == computer.getOpponent()) {
                rank--;
            } else {
                // Store possible winning move
                winningMove[0] = 2 - i;
                winningMove[1] = i;
            }
        }
        // If we hold 2 out of 3, and the last one is empty, we can win this shit
        if (rank == 2) {
            return winningMove;
        }

        return null;
    }

    /**
     * Get a random move out of empty moves
     *
     * @param state
     *
     * @return
     */
    private int[] getRandomMove(char[][] state) {
        int[][] possibleMoves = new int[0][2];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (state[x][y] == '_') {
                    int[][] temp = new int[possibleMoves.length + 1][2];
                    for (int x2 = 0; x2 < possibleMoves.length; x2++) {
                        for (int y2 = 0; y2 < 2; y2++) {
                            temp[x2][y2] = possibleMoves[x2][y2];
                        }
                    }
                    temp[possibleMoves.length][0] = x;
                    temp[possibleMoves.length][1] = y;
                    possibleMoves = temp;
                }
            }
        }
        if (possibleMoves.length > 1) {
            int randomIndex = random.nextInt(possibleMoves.length - 1);
            return possibleMoves[randomIndex];
        }
        return possibleMoves[0];
    }
}
