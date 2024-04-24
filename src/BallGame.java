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
    private ArrayList<Ball> group;


    public BallGame()
    {
        group = new ArrayList<Ball>();
        addToMainGroup(group);
        this.ball = new Ball();
        this.window = new BallGameView(this, ball, group);

        this.window.addMouseListener(this);
        this.window.addMouseMotionListener(this);
    }

    public void addToMainGroup(ArrayList<Ball> group)
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Ball b = new Ball(75 + 150 * i, 100 + 25 * j, 5, 4, 10, Color.RED);
                b.iColors(i);
                group.add(b);
            }
        }
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                Ball b = new Ball(75 + 150 * i, 300 + 25 * j, 5, 4, 10, Color.RED);
                int k = i + 4;
                b.iColors(k);
                group.add(b);
            }
        }
    }
    public void addToMiniGroups()
    {
        ArrayList<Ball> mini1 = new ArrayList<Ball>();

    }


    @Override
    public void mouseDragged(MouseEvent e) 
    {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        // If the ball is clicked
        for (int i = 0; i < 24; i++)
        {
            if (group.get(i).isClicked(x, y))
            {
                // Move the ball and repaint.
                group.get(i).setCenter(x, y);
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
