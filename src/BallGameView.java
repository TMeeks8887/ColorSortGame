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
    private ArrayList<Ball> MainGroup;
    private ArrayList<Ball> group1;
    private ArrayList<Ball> group2;
    private ArrayList<Ball> group3;
    private ArrayList<Ball> group4;
    private ArrayList<Ball> group5;
    private ArrayList<Ball> group6;
    private ArrayList<Ball> group7;
    private ArrayList<Ball> group8;
    
    
    public BallGameView(BallGame ref, Ball ball, ArrayList<Ball> group1, ArrayList<Ball> group2, ArrayList<Ball> group3,
                        ArrayList<Ball> group4, ArrayList<Ball> group5, ArrayList<Ball> group6, ArrayList<Ball> group7,
                        ArrayList<Ball> group8)
    {
        // Backend passed in
        this.ref = ref;
        this.ball = ball;
        this.group1 = group1;
        this.group2 = group2;
        this.group3 = group3;
        this.group4 = group4;
        this.group5 = group5;
        this.group6 = group6;
        this.group7 = group7;
        this.group8 = group8;


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

    public void drawVials(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawString("___", 65, 190);
        g.drawString("___", 215, 190);
        g.drawString("___", 365, 190);
        g.drawString("___", 515, 190);
        g.drawString("___", 65, 390);
        g.drawString("___", 215, 390);
        g.drawString("___", 365, 390);
        g.drawString("___", 515, 390);
    }
    public void reset(Graphics g)
    {
        // Resets screen to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }
    public void drawBalls(Graphics g)
    {
        for (int i = 0; i < 4; i++)
        {
            Ball b = group1.get(i);
            b.draw(g);
        }
        for (int i = 0; i < 4; i++)
        {
            Ball b = group2.get(i);
            b.draw(g);
        }
        for (int i = 0; i < 4; i++)
        {
            Ball b = group3.get(i);
            b.draw(g);
        }
        for (int i = 0; i < 4; i++)
        {
            Ball b = group4.get(i);
            b.draw(g);
        }
        for (int i = 0; i < 4; i++)
        {
            Ball b = group5.get(i);
            b.draw(g);
        }
        for (int i = 0; i < 4; i++)
        {
            Ball b = group6.get(i);
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
            drawVials(g);
        }
    }
}
