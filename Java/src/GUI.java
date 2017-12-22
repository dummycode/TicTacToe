import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

/**
 * @author Henry Harris
 */
public class GUI extends Applet {
    private final Frame f;
    
    private final int[] colCoordinates = {100, 200, 300};
    private final int[] rowCoordinates = {200, 300, 400};
    
    private CountDownLatch countDown;
    
    private int[] playersMove = new int[2];
    
    private final Panel header = new Panel();
    
    private final Label title = new Label("Tic Tac Toe", Label.CENTER);
    private final Label message = new Label("Let's play!", Label.CENTER);
      
    /**
     * GUI constructor
     */
    GUI()
    {
        f = new Frame("Tic Tac Toe");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setSize(400, 500);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.addWindowListener(new WindowAdapter() {
            @Override      
            public void windowClosing(WindowEvent we) {
                onWindowClosing();
            }
        });
        f.setLayout(new FlowLayout());
        
        header.setPreferredSize(new Dimension(400, 100));
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        
        title.setForeground(new Color(38, 40, 49));
        title.setFont(new Font("Default", Font.PLAIN, 36));
        header.add(title);
        
        message.setForeground(new Color(120, 120, 120));
        message.setFont(new Font("Default", Font.PLAIN, 20));
        header.add(message);
        
        f.add(header);
        
        f.setVisible(true);
        this.buildTheBoard();
    }
    
    /**
     * Get human move
     * 
     * @return
     */
    public int[] getMove()
    {
        playersMove = new int[2];
        
        // New latch
        countDown = new CountDownLatch(1);
        
        // Wait for a click
        try {
            countDown.await();
        } catch (InterruptedException ie) {
            System.err.println("Error getting human's move. Exiting...");
            System.exit(0);
        }
        
        return playersMove;
    }
    
    /**
     * Set message
     * 
     * @param message
     */
    public void setText(String message) {
        this.message.setText(message);
    }
        
    /**
     * Draw a move
     * 
     * @param symbol
     * @param row
     * @param col 
     */
    public void drawMove(char symbol, int row, int col)
    {
        // Center of move
        int xCoordinate = colCoordinates[col];	
        int yCoordinate = rowCoordinates[row];

        Graphics2D g = (Graphics2D) f.getGraphics();
        g.setStroke(new BasicStroke(5));

        // Logic for drawing an X
        if (symbol == 'X') {
            g.setColor(new Color(235, 88, 95));
            g.drawLine(xCoordinate - 25, yCoordinate - 25, xCoordinate + 25, yCoordinate + 25);
            g.drawLine(xCoordinate - 25, yCoordinate + 25, xCoordinate + 25, yCoordinate - 25);
        }
        // Logic for drawing an O
        else {
            g.setColor(new Color(77, 136, 255));
            g.drawOval(xCoordinate - 25, yCoordinate - 25, 50, 50);
        }
    }
    
    /**
     * Apologize because we can do nothing more. 
     */
    public void tellTheUserWeAreSorry() 
    {
        JOptionPane.showMessageDialog(null, "I fucked up bad, and I am sorry.");
    }
  
    /**
     * Build the board
     */
    private void buildTheBoard() 
    { 
        Graphics2D g = (Graphics2D) f.getGraphics();
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.BLACK);
        g.drawLine(150, 150, 150, 450);
        g.drawLine(250, 150, 250, 450);
        g.drawLine(50, 250, 350, 250);
        g.drawLine(50, 350, 350, 350);
        
        // Setup mouse listener to handle clicks        
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                int xCoordinate = me.getX();
                int yCoordinate = me.getY();
                
                handleClick(xCoordinate, yCoordinate);
            }
        });
    }
    
    /**
     * Handle a click by updating human move
     * 
     * @param xCoordinate
     * @param yCoordinate 
     */
    private void handleClick(int xCoordinate, int yCoordinate) {
        // If within board and is player's move
        if (xCoordinate > 50 && xCoordinate < 350 && yCoordinate > 150 && yCoordinate < 450) {
            // First column
            if (xCoordinate > 50 && xCoordinate < 150) {
                if (yCoordinate > 150 && yCoordinate < 250) {
                    playersMove[0] = 0;
                    playersMove[1] = 0;
                    countDown.countDown();
                }
                else if (yCoordinate > 250 && yCoordinate < 350) {
                    playersMove[0] = 1;
                    playersMove[1] = 0;
                    countDown.countDown();
                }
                else if (yCoordinate > 350 && yCoordinate < 450) {
                    playersMove[0] = 2;
                    playersMove[1] = 0;
                    countDown.countDown();
                }
        }
        // Second column
        else if (xCoordinate > 150 && xCoordinate < 250) {
                if (yCoordinate > 150 && yCoordinate < 250) {
                    playersMove[0] = 0;
                    playersMove[1] = 1;
                    countDown.countDown();
                }
                else if (yCoordinate > 250 && yCoordinate < 350) {
                    playersMove[0] = 1;
                    playersMove[1] = 1;
                    countDown.countDown();
                }
                else if (yCoordinate > 350 && yCoordinate < 450) {
                    playersMove[0] = 2;
                    playersMove[1] = 1;
                    countDown.countDown();
                }
        }
        // Last column
        else if (xCoordinate > 250 && xCoordinate < 350) {
                if (yCoordinate > 150 && yCoordinate < 250) {
                    playersMove[0] = 0;
                    playersMove[1] = 2;
                    countDown.countDown();
                }
                else if (yCoordinate > 250 && yCoordinate < 350) {
                    playersMove[0] = 1;
                    playersMove[1] = 2;
                    countDown.countDown();
                }
                else if (yCoordinate > 350 && yCoordinate < 450) {
                    playersMove[0] = 2;
                    playersMove[1] = 2;
                    countDown.countDown();
                }
            }
        }
    }
    
    /**
     * Handle window closing
     */
    private void onWindowClosing()
    {
        // Alert console and exit
        System.out.println("User has exited...");
        f.dispose();
        System.exit(0);
    }
}
