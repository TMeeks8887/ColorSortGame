// Teddy Meeks
import javax.swing.*;
import java.awt.*;


public class BallGameView extends JFrame
{

    public static final String TITLE = "Color Sort Game";

    public static final int
            WIDTH = 600,
            HEIGHT = 600,
            Y_OFFSET = 42,
            X_OFFSET = 20;

    private BallGame ref;
    private Ball ball;
    
    
    public BallGameView(BallGame ref)
    {
        // Backend passed in
        this.ref = ref;
        this.ball = ball;

        // Constructs the window
        this.setTitle(TITLE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    // Draws the welcome screen
    public void drawWelcome(Graphics g)
    {
        // Sets color to black because reset had color as white
        g.setColor(Color.BLACK);

        g.drawString("Hello! ", X_OFFSET + 20, Y_OFFSET + 20);
        g.drawString("Thank you for playing Color Sort Ball Game! ", X_OFFSET + 20, Y_OFFSET + 40);
        g.drawString("by Teddy Meeks", X_OFFSET + 20, Y_OFFSET + 60);
    }

    // Draws the rules
    public void drawRules(Graphics g)
    {
        // Sets color to black because reset had color as white
        g.setColor(Color.BLACK);

        g.drawString("Rules: ", X_OFFSET + 20, Y_OFFSET + 20);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 40);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 60);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 80);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 100);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 120);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 140);
        g.drawString("II", X_OFFSET + 20, Y_OFFSET + 160);
    }
    public void paint(Graphics g) 
    {
        ball.draw(g);
        if (ref.getGameState() == 0)
        {
            drawWelcome(g);
        }
        // Prints the rules
        if (ref.getGameState() == 1)
        {
            drawRules(g);
        }
    }
}
