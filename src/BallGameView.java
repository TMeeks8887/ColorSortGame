// Teddy Meeks
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;


public class BallGameView extends JFrame {

    public static final String TITLE = "Color Sort Game";

    public static final int
            WIDTH = 600, HEIGHT = 600, Y_OFFSET = 42, X_OFFSET = 20, GROUPONEX = 75,
            GROUPONEY = 100, GROUPSEVENX = 375, GROUPSEVENY = 300, DIAMETER = 20, RADIUS = 10;

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
    private Timer timer;
    private boolean won;


    public BallGameView(BallGame ref, Ball ball, ArrayList<Ball> group1, ArrayList<Ball> group2, ArrayList<Ball> group3,
                        ArrayList<Ball> group4, ArrayList<Ball> group5, ArrayList<Ball> group6, ArrayList<Ball> group7,
                        ArrayList<Ball> group8, Timer timer, boolean won) {
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
        this.won = won;


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
    }

    // Draws the rules
    public void drawRules(Graphics g) {
        // Sets color to black because reset had color as white
        g.setColor(Color.BLACK);

        g.drawString("Rules: ", X_OFFSET + 20, Y_OFFSET + 20);
        g.drawString("There are 4 of each colored ball", X_OFFSET + 20, Y_OFFSET + 40);
        g.drawString("Your job is to sort them into the containers", X_OFFSET + 20, Y_OFFSET + 60);
        g.drawString("You can only interact with the top ball of each group", X_OFFSET + 20, Y_OFFSET + 80);
        g.drawString("to sort them you drag the ball and release it above the group where the marking says to", X_OFFSET + 20, Y_OFFSET + 100);
        g.drawString("There are only markings for groups 1 and 7 so far, release on the same x values as those", X_OFFSET + 20, Y_OFFSET + 120);
        g.drawString("There is no win check or screen win", X_OFFSET + 20, Y_OFFSET + 140);
        g.drawString("There also is'nt a reset of the balls position to it's original group yet", X_OFFSET + 20, Y_OFFSET + 160);
    }

    public void drawVials(Graphics g) {
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

    public void reset(Graphics g) {
        // Resets screen to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void drawBalls(Graphics g)
    {
        for (int i = 0; i < group1.size(); i++) {
            Ball b = group1.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group2.size(); i++) {
            Ball b = group2.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group3.size(); i++) {
            Ball b = group3.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group4.size(); i++) {
            Ball b = group4.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group5.size(); i++) {
            Ball b = group5.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group6.size(); i++) {
            Ball b = group6.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group7.size(); i++) {
            Ball b = group7.get(i);
            b.draw(g);
        }
        for (int i = 0; i < group8.size(); i++) {
            Ball b = group8.get(i);
            b.draw(g);
        }
    }
    public void drawPlacementSquares(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawString("|", GROUPONEX - RADIUS, GROUPONEY);
        g.drawString("|", GROUPONEX - RADIUS, GROUPONEY + RADIUS);
        g.drawString("---", GROUPONEX - RADIUS, GROUPONEY + RADIUS);
        g.drawString("|", GROUPONEX - RADIUS + DIAMETER, GROUPONEY);
        g.drawString("|", GROUPONEX - RADIUS + DIAMETER, GROUPONEY + RADIUS);

        g.drawString("|", GROUPSEVENX - RADIUS, GROUPSEVENY);
        g.drawString("---", GROUPSEVENX - RADIUS, GROUPSEVENY + RADIUS);
        g.drawString("|", GROUPSEVENX - RADIUS + DIAMETER, GROUPSEVENY);
    }
    public void drawWon(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawString("YOU WIN", 100, 100);

    }

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
        if (ref.getGameState() == 2 && won == false)
        {
            drawBalls(g);
            drawVials(g);
            drawPlacementSquares(g);
        }
        if (ref.getGameState() == 3 && won == true)
        {
            drawWon(g);
        }
    }
}