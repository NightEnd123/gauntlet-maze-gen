import java.awt.*;

public class Player extends Brick
{
    private int speed;
    private Color color;
    private String name;
    private int health;

    public Player(int ex, int wy, int wd, int ht, int spd, Color col, String n)
    {
        super(ex, wy, wd, ht);
        speed = spd;
        color = col;
        name = n;
        health = 2000;
    }

    public void setSpeed(int s) { speed = s; }
    public int getSpeed() { return speed; }

    public int getHealth() { return health; }
    public void setHealth(int h) { health = h; }

    public void moveUp() { setY(getY() - speed); }
    public void moveDown() { setY(getY() + speed); }
    public void moveLeft() { setX(getX() - speed); }
    public void moveRight() { setX(getX() + speed); }
    public void moveDiag(int xDir, int yDir) {
        setX(getX() + (speed * xDir));
        setY(getY() + (speed * yDir));
    }


    public void paint(Graphics window)
    {
        window.setColor(color);
        window.fillRect(getX(), getY(), getW(), getH());
        window.setColor(Color.BLACK);
        window.drawRect(getX(), getY(), getW(), getH());

        window.setColor(Color.WHITE);
        window.setFont(new Font("Arial", Font.BOLD, 10));
        window.drawString(name + " (" + health + ")", getX() - 5, getY() - 5);
    }
}