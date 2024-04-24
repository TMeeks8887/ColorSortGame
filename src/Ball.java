// Teddy Meeks
import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;

public class Ball
{

    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int radius;         // Radius of the ball
    private Color color;

    public Ball() 
    {
        this(200, 300,5,4, 10, Color.RED);
    }
    
    public Ball (int x, int y, int dx, int dy, int radius, Color color)
    {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.radius = radius;
        this.color = color;
    }

    public boolean isClicked(int x, int y) 
    {
        double dx = (this.x - x) * (this.x - x);
        double dy = (this.y - y) * (this.y - y);
        return Math.sqrt(dx + dy) <= radius;
    }

    public void setCenter(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public void iColors(int i)
    {
        if (i == 1)
        {
            setColor(Color.RED);
        }
        if (i == 2)
        {
            setColor(Color.ORANGE);
        }
        if (i == 3)
        {
            setColor(Color.YELLOW);
        }
        if (i == 4)
        {
            setColor(Color.BLUE);
        }
        if (i == 5)
        {
            setColor(Color.BLACK);
        }
        if (i == 6)
        {
            setColor(Color.PINK);
        }
    }
    public void setColor(Color colorIn)
    {
        color = colorIn;
    }
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}
