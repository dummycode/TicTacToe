import java.util.Random;
import java.util.Scanner;

/**
 * @author Henry Harris
 */
public class Game {
    private final Board board;
    private final Computer computer;
    private final GUI gui;
    private char turn;
    private char winner = '_';
    private GameStatus status;
    
    /**
     * Game constructor
     */
    public Game(GUI gui) 
    {
        this.gui = gui;
        board = new Board();
        computer = new Computer('X');
        
        turn = whoGoesFirst();
        status = GameStatus.IN_PROGRESS;
    }
    
    /**
     * Get a move
     */
    public void getMove()
    {
        int[] move = new int[2];
        
        if (turn == computer.getPlayer()) {
            move = computer.getMove(board.getState());
        } else {
            move = getHumanMove();
        }
    
        boolean goodMove = move(move[0], move[1]);
        
        if (!goodMove && turn == computer.getPlayer()) {
            System.out.println("Something broke and the computer made a bad move.");
            status = GameStatus.BROKEN;
        } 
        
        if (goodMove) {
            if (isOver(move)) {
                winner = turn;
                status = GameStatus.OVER;
            } 
            if (isDraw()) {
                status = GameStatus.OVER;
            }
            nextTurn();
        }
    }
    
    /**
     * Print the current state of the game
     */
    public void printState() 
    {
        System.out.println(board);
    }
    
    /**
     * Get the current status of the game
     * 
     * @return 
     */
    public GameStatus getStatus() 
    {
        return status;
    }
    
    /**
     * Get the winner

     * @return 
     */
    public char getWinner() 
    {
        return winner;
    }
    
    private boolean move(int row, int col) 
    {
        if (row > 2 || row < 0 || col > 2 || col < 0) {
            System.out.println("Error! Invalid spot.");
        } else {
            if (board.move(turn, row, col)) {
                gui.drawMove(turn, row, col);
                return true;
            } else {
                System.out.println("Spot taken! Try again.");
            }
        }
        return false;
    }
    
    /**
     * Get who goes first
     */
    private char whoGoesFirst() 
    {
        Random r = new Random();
        return r.nextBoolean() ? 'X' : 'O';
    }
    
    /**
     * Set next turn
     */
    private void nextTurn() 
    {
        turn = (turn == 'X') ? 'O' : 'X';
    }
    
    /**
     * Get human move
     * 
     * @return
     */
    private int[] getHumanMove() {
        gui.setText("Your move");
        return gui.getMove();
    }
    
    /**
     * Check if the game is over
     * 
     * @param lastMove
     * 
     * @return 
     */
    private boolean isOver(int[] lastMove) 
    {
        char state[][] = board.getState();

        // Check if column is a 3 in a row
        if (state[0][lastMove[1]] == turn 
                && state[1][lastMove[1]] == turn 
                && state[2][lastMove[1]] == turn) {
            return true;
        }
        // Check if row is a 3 in a row
        if (state[lastMove[0]][0] == turn 
                && state[lastMove[0]][1] == turn 
                && state[lastMove[0]][2] == turn) {
            return true;
        }
        // Check if 3 in a row in diagonal
        if (lastMove[0] == lastMove[1] 
                && state[0][0] == turn 
                && state[1][1] == turn 
                && state[2][2] == turn) {
            return true;
        }
        // Check if 3 in a row in other diagonal
        return lastMove[0] + lastMove[1] == 2 
                && state[2][0] == turn 
                && state[1][1] == turn 
                && state[0][2] == turn;
    }
    
    /**
     * Check to see if the game is a draw
     * 
     * @return 
     */
    private boolean isDraw() 
    {
        return board.isFull();
    }
}
