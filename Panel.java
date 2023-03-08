package Geometry;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Panel extends JPanel implements MouseListener, MouseMotionListener {
    private final List<Shape> SHAPES = new ArrayList<>();
    private Shape selectedShape = null;
    private int dragFromX = 0;
    private int dragFromY = 0;

    public Panel() {
        Circle circle = new Circle(Shape.distance *3+ Shape.size, Shape.distance + Shape.circleRadius, Shape.circleRadius);
        Square square = new Square(Shape.distance *2, Shape.distance, Shape.size);
        Triangle triangle = new Triangle(Shape.distance, Shape.distance, Shape.size);
        SHAPES.add(circle);
        SHAPES.add(square);
        SHAPES.add(triangle);
        addMouseListener(this);
        addMouseMotionListener(this);
    }//Panel

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : SHAPES) {
            if (shape != selectedShape) { // draw all shapes except the selected shape first
                shape.draw(g);
            }//if

        }//for

        if (selectedShape != null) { // draw the selected shape last
            selectedShape.draw(g);
        }//if

    }//paintComponent

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        for (Shape shape : SHAPES) {
            if (shape.contains(x, y)) {
                selectedShape = shape;
                SHAPES.remove(selectedShape); // remove the selected shape from the list
                SHAPES.add(selectedShape); // add it to the end of the list
                dragFromX = x;
                dragFromY = y;
                break;
            }//if

        }//for

    }//mousePressed

    public void mouseDragged(MouseEvent e) {
        if (selectedShape != null) {
            int x = e.getX();
            int y = e.getY();
            int dx = x - dragFromX;
            int dy = y - dragFromY;
            selectedShape.currentPosition(dx, dy);
            dragFromX = x;
            dragFromY = y;
            repaint();
        }//if

    }//mouseDragged

    public void mouseReleased(MouseEvent e) {
        selectedShape = null;
    }//mouseReleased

    public void mouseClicked(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}

}//class