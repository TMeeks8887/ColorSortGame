// Teddy Meeks
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;


public class BallGameView extends JFrame {

    // Instance variables
    public static final String TITLE = "Color Sort Game";

    public static final int
            WIDTH = 600, HEIGHT = 600, Y_OFFSET = 42, X_OFFSET = 20, GROUPONEX = 75, GROUPTWOX = 225, GROUPTHREEX = 375, GROUPFOURX = 525,
            GROUPFIVEX = 75, GROUPSIXX = 225, GROUPSEVENX = 375, GROUPEIGHTX = 525,
            TOPGROUPSY = 100, BOTTOMGROUPSY = 300, DIAMETER = 20, RADIUS = 10;

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
    private ArrayList<ArrayList<Ball>> allGroups;
    private Timer timer;



    // Constructor
    public BallGameView(BallGame ref, Ball ball, ArrayList<Ball> group1, ArrayList<Ball> group2, ArrayList<Ball> group3,
                        ArrayList<Ball> group4, ArrayList<Ball> group5, ArrayList<Ball> group6, ArrayList<Ball> group7,
                        ArrayList<Ball> group8, Timer timer, ArrayList<ArrayList<Ball>> allGroups) {
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
        this.timer = timer;
        this.allGroups = allGroups;


        // Constructs the window
        this.setTitle(TITLE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        createBufferStrategy(2);
    }

    // Draws the welcome screen
    public void drawWelcome(Graphics g) {
        // Sets color to black because reset had color as white
        g.setColor(Color.BLACK);

        g.drawString("Hello! ", X_OFFSET + 20, Y_OFFSET + 20);
        g.drawString("Thank you for playing Color Sort Ball Game! ", X_OFFSET + 20, Y_OFFSET + 40);
        g.drawString("by Teddy Meeks", X_OFFSET + 20, Y_OFFSET + 60);
        g.drawString("(Click to move to the next screen)", X_OFFSET + 20, Y_OFFSET + 100);
        g.drawString("(If it doesn't go to the next screen try clicking again)", X_OFFSET + 20, Y_OFFSET + 120);
    }

    // Draws the rules
    public void drawRules(Graphics g) {
        // Sets color to black because reset had color as white
        g.setColor(Color.BLACK);

        g.drawString("Rules: ", X_OFFSET + 20, Y_OFFSET + 20);
        g.drawString("There are 4 of each colored ball", X_OFFSET + 20, Y_OFFSET + 40);
        g.drawString("Your job is to sort the balls with the same color into the containers", X_OFFSET + 20, Y_OFFSET + 60);
        g.drawString("You can only interact with the top ball of each group", X_OFFSET + 20, Y_OFFSET + 80);
        g.drawString("To sort them you drag the ball and release it covering fully where the marking says to", X_OFFSET + 20, Y_OFFSET + 100);
        g.drawString("If you want to move two balls at once you can drag over both", X_OFFSET + 20, Y_OFFSET + 120);
        g.drawString("when you drop them they will each appear", X_OFFSET + 20, Y_OFFSET + 140);
        g.drawString("It will not show both balls when moving them", X_OFFSET + 20, Y_OFFSET + 160);
        g.drawString("Try not to drag over the top ball in a group while moving a ball unless you want to move both", X_OFFSET + 20, Y_OFFSET + 180);
        g.drawString("Try to drag the ball slowly, it sometimes lets go if you drag too fast", X_OFFSET + 20, Y_OFFSET + 200);
        g.drawString("(Click to move to the next screen)", X_OFFSET + 20, Y_OFFSET + 240);
        g.drawString("(If it doesn't go to the next screen try clicking again)", X_OFFSET + 20, Y_OFFSET + 260);
    }

    // Draws the bottom of where the groups are
    public void drawVials(Graphics g) {
        g.setColor(Color.BLACK);

        g.drawString("___", GROUPONEX - RADIUS, TOPGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPTWOX - RADIUS, TOPGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPTHREEX - RADIUS, TOPGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPFOURX - RADIUS, TOPGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPFIVEX - RADIUS, BOTTOMGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPSIXX - RADIUS, BOTTOMGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPSEVENX - RADIUS, BOTTOMGROUPSY + (4 * DIAMETER) + RADIUS);
        g.drawString("___", GROUPEIGHTX - RADIUS, BOTTOMGROUPSY + (4 * DIAMETER) + RADIUS);
    }

    // Resets screen to white
    public void reset(Graphics g) {
        // Resets screen to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    // Draws all the balls
    public void drawBalls(Graphics g)
    {
        // Go through each group and draw their balls
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < allGroups.get(i).size(); j++) {
                Ball b = allGroups.get(i).get(j);
                b.draw(g);
            }
        }
    }
    // Draws where the top of the group is for the person to drop the ball
    public void drawPlacementSquares(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawString("---", GROUPONEX - RADIUS, TOPGROUPSY + RADIUS);
        g.drawString("---", GROUPTWOX - RADIUS, TOPGROUPSY + RADIUS);
        g.drawString("---", GROUPTHREEX - RADIUS, TOPGROUPSY + RADIUS);
        g.drawString("---", GROUPFOURX - RADIUS, TOPGROUPSY + RADIUS);
        g.drawString("---", GROUPFIVEX - RADIUS, BOTTOMGROUPSY + RADIUS);
        g.drawString("---", GROUPSIXX - RADIUS, BOTTOMGROUPSY + RADIUS);
        g.drawString("---", GROUPSEVENX - RADIUS, BOTTOMGROUPSY + RADIUS);
        g.drawString("---", GROUPEIGHTX - RADIUS, BOTTOMGROUPSY + RADIUS);
    }
    // Draws win screen
    public void drawWon(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawString("YOU WIN", 100, 100);
        g.drawString("Click to play again", 100, 300);
        g.drawString("(If it doesn't work try clicking again)", X_OFFSET + 20, Y_OFFSET + 320);

    }

    // Double buffer set
    public void paint(Graphics g)
    {
        // Taken from Aquarium
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;
        Graphics g2 = null;
        try {
            g2 = bf.getDrawGraphics();
            myPaint(g2);
        } finally {
            g2.dispose();
        }
        bf.show();
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g)
    {
        reset(g);

        // Draw welcome
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
            drawBalls(g);
            drawVials(g);
            drawPlacementSquares(g);
        }
        if (ref.getGameState() == 3)
        {
            drawWon(g);
        }
    }
}