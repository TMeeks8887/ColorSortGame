// Teddy Meeks
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class BallGame implements MouseListener, MouseMotionListener, ActionListener
{
    private BallGameView window;
    private Ball ball;
    private int gameState = 0;
    private int counter = 0;
    public static final int DELAY = 20, DIAMETER = 20, GROUPONEX = 75, GROUPTWOX = 225, GROUPTHREEX = 375, GROUPFOURX = 525,
            GROUPFIVEX = 75, GROUPSIXX = 225, GROUPSEVENX = 375, GROUPEIGHTX = 525,
            TOPGROUPSY = 100, BOTTOMGROUPSY = 300, RADIUS = 10, DIFFERENCEX = 150, DIFFERENCEY = 25;
    private Timer timer;
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

//    private Ball clickedBall;



    public BallGame()
    {
        MainGroup = new ArrayList<Ball>();
        addToMainGroup(MainGroup);
//        groupSize = MainGroup.size();

        group1 = new ArrayList<Ball>();
        addToMiniGroup(group1);
        group2 = new ArrayList<Ball>();
        addToMiniGroup(group2);
        group3 = new ArrayList<Ball>();
        addToMiniGroup(group3);
        group4 = new ArrayList<Ball>();
        addToMiniGroup(group4);
        group5 = new ArrayList<Ball>();
        addToMiniGroup(group5);
        group6 = new ArrayList<Ball>();
        addToMiniGroup(group6);
        group7 = new ArrayList<Ball>();
        group8 = new ArrayList<Ball>();
        allGroups = new ArrayList<ArrayList<Ball>>();
        timer = new Timer(DELAY, this);

        this.ball = new Ball();
        this.window = new BallGameView(this, ball, group1, group2, group3, group4, group5, group6, group7, group8, timer);

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    public void addToMainGroup(ArrayList<Ball> MainGroup)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Ball b = new Ball(GROUPONEX + DIFFERENCEX * i, TOPGROUPSY + DIFFERENCEY * j, 5, 4, RADIUS, Color.RED);
                b.iColors(i);
                MainGroup.add(b);
            }
        }
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Ball b = new Ball(GROUPONEX + DIFFERENCEX * i, BOTTOMGROUPSY + DIFFERENCEY * j, 5, 4, RADIUS, Color.RED);
                int k = i + 4;
                b.iColors(k);
                MainGroup.add(b);
            }
        }
    }
    public void addToMiniGroup(ArrayList<Ball> MiniGroup)
    {
        for (int i = 0; i < 4; i++)
        {
            if (counter < 4)
            {
                int randomNum = (int)(Math.random() * (MainGroup.size()));
                Ball intermediary = MainGroup.remove(randomNum);
                intermediary.setCenter(75 + 150 * counter, 100 + 25 * i);
                MiniGroup.add(intermediary);
            }
            else
            {
                int randomNum = (int)(Math.random() * (MainGroup.size()));
                Ball intermediary = MainGroup.remove(randomNum);
                intermediary.setCenter(75 + 150 * (counter - 4), 300 + 25 * i);
                MiniGroup.add(intermediary);
            }
        }
        counter++;
    }


    @Override
    public void mouseDragged(MouseEvent e) 
    {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        // If the ball is clicked

        topOfGroupClick(group1, group1.get(0), x, y);
        topOfGroupClick(group2, group2.get(0), x, y);
        topOfGroupClick(group3, group3.get(0), x, y);
        topOfGroupClick(group4, group4.get(0), x, y);
        topOfGroupClick(group5, group5.get(0), x, y);
        topOfGroupClick(group6, group6.get(0), x, y);
        topOfGroupClick(group7, group7.get(0), x, y);
        topOfGroupClick(group8, group8.get(0), x, y);
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
//        for (int i)
        addToGroup(group1, group1.get(0));
        addToGroup(group2, group2.get(0));
        addToGroup(group3, group3.get(0));
        addToGroup(group4, group4.get(0));
        addToGroup(group5, group5.get(0));
        addToGroup(group6, group6.get(0));
        addToGroup(group7, group7.get(0));
        addToGroup(group8, group8.get(0));
    }

//    public void

    public void topOfGroupClick(ArrayList<Ball> group, Ball ball, int x, int y)
    {
        if (!group.isEmpty())
        {
            if (ball.isClicked(x, y))
            {
                // Move the ball and repaint.
                ball.setCenter(x, y);
            }
        }
    }
    public void addToGroup(ArrayList<Ball> group, Ball ball)
    {
        if ((ball.getX() < (GROUPONEX - RADIUS + DIAMETER) && ball.getX() > GROUPONEX - RADIUS) && (ball.getY() >
                TOPGROUPSY && ball.getY() < (TOPGROUPSY + (DIAMETER * (4 - group1.size())))) && (group1.size() < 4))
        {
            ball.setCenter(GROUPONEX, TOPGROUPSY + (DIFFERENCEY* (3 - group1.size())));
            group1.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPTWOX - RADIUS + DIAMETER) && ball.getX() > GROUPTWOX - RADIUS) && (ball.getY() >
                TOPGROUPSY && ball.getY() < (TOPGROUPSY + (DIAMETER * (4 - group2.size())))) && (group2.size() < 4))
        {
            ball.setCenter(GROUPTWOX, TOPGROUPSY + (DIFFERENCEY * (3 - group2.size())));
            group2.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPTHREEX - RADIUS + DIAMETER) && ball.getX() > GROUPTHREEX - RADIUS) && (ball.getY() >
                TOPGROUPSY && ball.getY() < (TOPGROUPSY + (DIAMETER * (4 - group3.size())))) && (group3.size() < 4))
        {
            ball.setCenter(GROUPTHREEX, TOPGROUPSY + (DIFFERENCEY  * (3 - group3.size())));
            group3.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPFOURX - RADIUS + DIAMETER) && ball.getX() > GROUPFOURX - RADIUS) && (ball.getY() >
                TOPGROUPSY && ball.getY() < (TOPGROUPSY + (DIAMETER * (4 - group4.size())))) && (group4.size() < 4))
        {
            ball.setCenter(GROUPFOURX, TOPGROUPSY + (DIFFERENCEY  * (3 - group4.size())));
            group4.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPFIVEX - RADIUS + DIAMETER) && ball.getX() > GROUPFIVEX - RADIUS) && (ball.getY() >
                BOTTOMGROUPSY && ball.getY() < (BOTTOMGROUPSY + (DIAMETER * (4 - group5.size())))) && (group5.size() < 4))
        {
            ball.setCenter(GROUPFIVEX, BOTTOMGROUPSY + (DIFFERENCEY  * (3 - group5.size())));
            group5.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPSIXX - RADIUS + DIAMETER) && ball.getX() > GROUPSIXX - RADIUS) && (ball.getY() >
                BOTTOMGROUPSY && ball.getY() < (BOTTOMGROUPSY + (DIAMETER * (4 - group6.size())))) && (group6.size() < 4))
        {
            ball.setCenter(GROUPSIXX, BOTTOMGROUPSY + (DIFFERENCEY * (3 - group6.size())));
            group6.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPSEVENX - RADIUS + DIAMETER) && ball.getX() > GROUPSEVENX - RADIUS) && (ball.getY() >
                BOTTOMGROUPSY && ball.getY() < (BOTTOMGROUPSY + (DIAMETER * (4 - group7.size())))) && (group7.size() < 4))
        {
            ball.setCenter(GROUPSEVENX, BOTTOMGROUPSY + (DIFFERENCEY  * (3 - group7.size())));
            group7.add(0, group.remove(0));
        }
        if ((ball.getX() < (GROUPEIGHTX - RADIUS + DIAMETER) && ball.getX() > GROUPEIGHTX - RADIUS) && (ball.getY() >
                BOTTOMGROUPSY && ball.getY() < (BOTTOMGROUPSY + (DIAMETER * (4 - group8.size())))) && (group8.size() < 4))
        {
            ball.setCenter(GROUPEIGHTX, BOTTOMGROUPSY + (DIFFERENCEY  * (3 - group8.size())));
            group8.add(0, group.remove(0));
        }
//        else
//        {
//            // return to original position
//            ball.setCenter(75, 100);
//        }
    }

//    public int getGroupX(ArrayList<Ball> group)
//    {
    // returns what group its in then based on that returns the x and y of the original ball
//        if (group.get)
//        return GROUPONEX;
//    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public int getGameState()
    {
        return gameState;
    }

    public void goThroughGameState()
    {
        gameState++;
        window.repaint();
    }
    public void playBallGame()
    {
        timer.start();
    }
    public static void main(String[] args)
    {
        BallGame game = new BallGame();
        game.playBallGame();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (gameState < 2)
        {
            goThroughGameState();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e)
    {
        // constanly call repaint
        window.repaint();
    }
}
