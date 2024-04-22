// Teddy Meeks
import java.util.Scanner;
import java.util.ArrayList;
import java.awt.*;
public class BallGame {
    private BallGameView window;
    public BallGame()
    {
        this.window = new BallGameView(this);
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
