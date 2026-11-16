import java.awt.*;

public class Brick extends Canvas
{
	private int x, y, w, h;

	public Brick()
	{
		x = 0;
		y = 0;
		w = 0;
		h = 0;
	}

	public Brick(int ex, int wy, int wd, int ht)
	{
		x = ex;
		y = wy;
		w = wd;
		h = ht;
	}

	public int getX() { return x; }
	public void setX(int ex) { x = ex; }
	public int getY() { return y; }
	public void setY(int wy) { y = wy; }
	public int getW() { return w; }
	public int getH() { return h; }

	public boolean intersects(Brick other)
	{
		Rectangle r1 = new Rectangle(x, y, w, h);
		Rectangle r2 = new Rectangle(other.getX(), other.getY(), other.getW(), other.getH());
		return r1.intersects(r2);
	}

	public void paint(Graphics window)
	{
		window.setColor(Color.DARK_GRAY);
		window.fillRect(getX(), getY(), getW(), getH());
		window.setColor(Color.BLACK);
		window.drawRect(getX(), getY(), getW(), getH());
	}
}