// Daniel Isaksson
// Daniel.isaksson90@gmail.com
package Geometry;
import java.awt.*;

public class Square implements Shape {
    private int x;
    private int y;
    private final int SIZE;

    public Square(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.SIZE = size;
    }//Square

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, SIZE, SIZE);
    }//draw


    public void currentPosition(int dx, int dy) {
        x += dx;
        y += dy;
    }//currentPosition

    public boolean contains(int x, int y) {
        return x >= this.x && x <= this.x + SIZE && y >= this.y && y <= this.y + SIZE;
    }//contains

}//class
