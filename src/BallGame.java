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
    private int gameState = 0;
    
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
        if (ball.isClicked(x, y))
        {
            // Move the ball and repaint.
            ball.setCenter(x, y);
            window.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public int getGameState()
    {
        return gameState;
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
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
