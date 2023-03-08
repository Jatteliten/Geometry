package Geometry;
import java.awt.*;

public class Circle implements Shape {
    private int x;
    private int y;
    private final int RADIUS;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.RADIUS = radius;
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - RADIUS, y - RADIUS, size, size);
    }


    public void currentPosition(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public boolean contains(int x, int y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)) <= RADIUS;
    }
}

