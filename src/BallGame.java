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

        if (!group1.isEmpty())
        {
            if (group1.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group1.get(0).setCenter(x, y);
                window.repaint();
            }
        }

        if (!group2.isEmpty())
        {
            if (group2.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group2.get(0).setCenter(x, y);
                window.repaint();
            }
        }

        if (!group3.isEmpty())
        {
            if (group3.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group3.get(0).setCenter(x, y);
                window.repaint();
            }
        }
        if (!group4.isEmpty())
        {
            if (group4.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group4.get(0).setCenter(x, y);
                window.repaint();
            }
        }
        if (!group5.isEmpty())
        {
            if (group5.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group5.get(0).setCenter(x, y);
                window.repaint();
            }
        }

        if (!group6.isEmpty())
        {
            if (group6.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group6.get(0).setCenter(x, y);
                window.repaint();
            }
        }

        if (!group7.isEmpty())
        {
            if (group7.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group7.get(0).setCenter(x, y);
                window.repaint();
            }
        }
        if (!group8.isEmpty())
        {
            if (group8.get(0).isClicked(x, y))
            {
                // Move the ball and repaint.
                group8.get(0).setCenter(x, y);
                window.repaint();
            }
        }
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
