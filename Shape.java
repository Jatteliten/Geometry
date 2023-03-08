package Geometry;
import java.awt.*;

public interface Shape {
    int size = 60;
    int circleRadius = size / 2;
    int distance = 100;
    void draw(Graphics g);
    void currentPosition(int dx, int dy);
    boolean contains(int x, int y);
}

