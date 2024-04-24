// Teddy Meeks
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


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
    private ArrayList<Ball> group;
    
    
    public BallGameView(BallGame ref, Ball ball, ArrayList<Ball> group)
    {
        // Backend passed in
        this.ref = ref;
        this.ball = ball;
        this.group = group;

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
    public void reset(Graphics g)
    {
        // Resets screen to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
    public void drawBalls(Graphics g)
    {
        for (int i = 0; i < 24; i++)
        {
            Ball b = group.get(i);
            b.draw(g);
        }
    }
    public void paint(Graphics g) 
    {
        reset(g);

        if (ref.getGameState() == 0)
        {
            drawWelcome(g);
        }
        // Prints the rules
        if (ref.getGameState() == 1)
        {
            drawRules(g);
        }
        // Plays Game
        if (ref.getGameState() == 2)
        {
//            ball.draw(g);
            drawBalls(g);
        }
    }
}
