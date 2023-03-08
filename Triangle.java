// Daniel Isaksson
// Daniel.isaksson90@gmail.com
package Geometry;
import java.awt.*;

public class Triangle implements Shape {
    private final int[] X_POINTS;
    private final int[] Y_POINTS;

    public Triangle(int x, int y, int size) {
        this.X_POINTS = new int[]{x, x + size / 2, x - size / 2};
        this.Y_POINTS = new int[]{y, y + size, y + size};
    }//Triangle

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(X_POINTS, Y_POINTS, 3);
    }//draw


    public void currentPosition(int dx, int dy) {
        for (int i = 0; i < X_POINTS.length; i++) {
            X_POINTS[i] += dx;
            Y_POINTS[i] += dy;
        }//for

    }//currentPosition

    public boolean contains(int x, int y) {
        int minX = Math.min(X_POINTS[0], Math.min(X_POINTS[1], X_POINTS[2]));
        int maxX = Math.max(X_POINTS[0], Math.max(X_POINTS[1], X_POINTS[2]));
        int minY = Math.min(Y_POINTS[0], Math.min(Y_POINTS[1], Y_POINTS[2]));
        int maxY = Math.max(Y_POINTS[0], Math.max(Y_POINTS[1], Y_POINTS[2]));
        return x >= minX && x <= maxX && y >= minY && y <= maxY;
    }//contains

}//class