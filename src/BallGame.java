// Teddy Meeks
import java.awt.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BallGame implements MouseListener, MouseMotionListener
{
    private BallGameView window;
    private Ball ball;
    
    
    public BallGame()
    {
        this.ball = ball;
        this.window = new BallGameView(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) 
    {
        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        // If the ball is clicked
        if (b.isClicked(x, y))
        {
            // Move the ball and repaint.
            b.setCenter(x, y);
            window.repaint();
        }
    }
    
    
    
    
    public void playBallGame()
    {

    }
    public static void main(String[] args)
    {
        BallGame game = new BallGame();
        game.playBallGame();
    }
}
