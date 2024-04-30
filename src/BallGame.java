// Teddy Meeks
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class BallGame implements MouseListener, MouseMotionListener
{
    private BallGameView window;
    private Ball ball;
    private int gameState = 0;
    private int counter = 0;
    public static final int DIAMETER = 20, GROUPONEX = 75, GROUPONEY = 100, GROUPSEVENX = 375, GROUPSEVENY = 300;

    private ArrayList<Ball> MainGroup;
    private ArrayList<Ball> group1;
    private ArrayList<Ball> group2;
    private ArrayList<Ball> group3;
    private ArrayList<Ball> group4;
    private ArrayList<Ball> group5;
    private ArrayList<Ball> group6;
    private ArrayList<Ball> group7;
    private ArrayList<Ball> group8;
//    private int groupSize;




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


        this.ball = new Ball();
        this.window = new BallGameView(this, ball, group1, group2, group3, group4, group5, group6, group7, group8);

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    public void addToMainGroup(ArrayList<Ball> MainGroup)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Ball b = new Ball(75 + 150 * i, 100 + 25 * j, 5, 4, 10, Color.RED);
                b.iColors(i);
                MainGroup.add(b);
            }
        }
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Ball b = new Ball(75 + 150 * i, 300 + 25 * j, 5, 4, 10, Color.RED);
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

        topOfGroupClick(group1, x, y);
        topOfGroupClick(group2, x, y);
        topOfGroupClick(group3, x, y);
        topOfGroupClick(group4, x, y);
        topOfGroupClick(group5, x, y);
        topOfGroupClick(group6, x, y);
        topOfGroupClick(group7, x, y);
        topOfGroupClick(group8, x, y);
    }

    public void topOfGroupClick(ArrayList<Ball> group, int x, int y)
    {
        if (!group.isEmpty())
        {
            if (group.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group.get(0).setCenter(x, y);
                if (addToGroup(group) == 1)
                {
                    // How to break out of whole mouse dragged
                    break;
                }
                window.repaint();
            }
        }
    }
    public int addToGroup(ArrayList<Ball> group)
    {
        if ((group.get(0).getX() < (GROUPONEX + DIAMETER) && group.get(0).getX() > GROUPONEX) && (group.get(0).getY() >
                GROUPONEY && group.get(0).getY() < (GROUPONEY + (DIAMETER * (4 - group1.size())))) && (group1.size() < 4))
        {
            group1.add(0, group.remove(0));
            group.get(0).setCenter(GROUPONEX, GROUPONEY + (DIAMETER * (3 - group1.size())));
            return 1;
        }
        if ((group.get(0).getX() < (GROUPSEVENX + DIAMETER) && group.get(0).getX() > GROUPSEVENX) && (group.get(0).getY() >
                GROUPSEVENY && group.get(0).getY() < (GROUPSEVENY + (DIAMETER * (4 - group7.size())))) && (group7.size() < 4))
        {
            group7.add(0, group.remove(0));
            group.get(0).setCenter(GROUPSEVENX, GROUPSEVENY + (DIAMETER * (3 - group7.size())));
            return 1;
        }
        return 0;
    }

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
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
