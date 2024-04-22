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

    public BallGameView(BallGame ref)
    {
        // Backend passed in
        this.ref = ref;

        // Constructs the window
        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    public void paint(Graphics g) {
    }
}
