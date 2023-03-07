package Geometry;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Panel extends JPanel implements MouseListener, MouseMotionListener{

    private final int SIZE = 60;
    private final int DISTANCE = 100;
    //circle coordinates
    private final int CIRCLE_RADIUS = SIZE / 2;
    private int circleX = DISTANCE * 3 + CIRCLE_RADIUS;
    private int circleY = DISTANCE+CIRCLE_RADIUS;
    //square coordinates
    private int squareX = DISTANCE * 2;
    private int squareY = DISTANCE;
    //triangle coordinates
    private int triangleX = DISTANCE;
    private int triangleY = DISTANCE;
    private final int[] TX_POINTS = {triangleX, triangleX + SIZE / 2, triangleX - SIZE / 2};
    private final int[] TY_POINTS = {triangleY, triangleY + SIZE, triangleY + SIZE};

    //position of the mouse to drag the shapes
    private int dragFromX = 0;
    private int dragFromY = 0;

    public Panel(){
        //adding mouse listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.YELLOW);
        g.fillRect(squareX, squareY, SIZE, SIZE);

        g.setColor(Color.RED);
        g.fillOval (circleX-CIRCLE_RADIUS, circleY-CIRCLE_RADIUS, 2 * CIRCLE_RADIUS, 2 * CIRCLE_RADIUS);

        g.setColor(Color.BLUE);
        g.fillPolygon(TX_POINTS, TY_POINTS, 3);



    }//end paintComponent

    //mousePressed
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if(x >= circleX && x <= (circleX + SIZE) && y >= circleY && y <= (circleY + SIZE)){
            dragFromX = x - circleX;
            dragFromY = y - circleY;
        }
        else if(x >= squareX && x <= (squareX + SIZE) && y >= squareY && y <= (squareY + SIZE)){
            dragFromX = x - squareX;
            dragFromY = y - squareY;
        }
        else if(x >= triangleX && x <= (triangleX + SIZE) && y >= triangleY && y <= (triangleY + SIZE)){
            dragFromX = x - triangleX;
            dragFromY = y - triangleY;
        }


    }// end mousePressed

    //mouseDragged
    public void mouseDragged(MouseEvent e){
            int x = e.getX();
            int y = e.getY();
            if (containsCircle (x, y) && !containsSquare(x,y) && !containsTriangle(x,y)) {

                //change position
                circleX = e.getX() - dragFromX;
                circleY = e.getY() - dragFromY;

                //don't move off the screen
                circleX = Math.max(circleX, 0);
                circleX = Math.min(circleX, getWidth() - SIZE);

                circleY = Math.max(circleY, 0);
                circleY = Math.min(circleY, getHeight() - SIZE);
            }
            else if (containsSquare(x,y) && !containsCircle(x,y) && !containsTriangle(x,y)){

                squareX = e.getX() - dragFromX;
                squareY = e.getY() - dragFromY;

                squareX = Math.max(squareX, 0);
                squareX = Math.min(squareX, getWidth() - SIZE);

                squareY = Math.max(squareY, 0);
                squareY = Math.min(squareY, getHeight() - SIZE);

            }
            else if (containsTriangle(x,y) && !containsCircle(x,y) && !containsSquare(x,y)){

                triangleX = e.getX() - dragFromX;
                triangleY = e.getY() - dragFromY;

                // update the triangle points
                TX_POINTS[0] = triangleX;
                TX_POINTS[1] = triangleX + SIZE / 2;
                TX_POINTS[2] = triangleX - SIZE / 2;

                TY_POINTS[0] = triangleY;
                TY_POINTS[1] = triangleY + SIZE;
                TY_POINTS[2] = triangleY + SIZE;

                // don't move off the screen
                int maxY = Math.max(TY_POINTS[0], Math.max(TY_POINTS[1], TY_POINTS[2]));
                int minY = Math.min(TY_POINTS[0], Math.min(TY_POINTS[1], TY_POINTS[2]));

                triangleX = Math.max(triangleX, 0);
                triangleX = Math.min(triangleX, getWidth() - SIZE);

                triangleY = Math.max(triangleY, 0);
                triangleY = Math.min(triangleY, getHeight() - SIZE - maxY + minY);
            }

        repaint();

    } //end mouseDragged

    public void mouseClicked(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public boolean containsTriangle(int x, int y) {
        int dx = x - triangleX;
        int dy = y - triangleY;

        return -dy <= 2*dx
                && 2*dx <= dy
                && dy <= SIZE;
    }

    public boolean containsSquare(int x, int y) {
        return squareX<=x && squareY<=y && x <= squareX+ SIZE && y <= squareY+ SIZE;

    }

    public boolean containsCircle(int x, int y) {
        return (x >= circleX - CIRCLE_RADIUS && x <= circleX + CIRCLE_RADIUS + SIZE &&
                y >= circleY - CIRCLE_RADIUS && y <= circleY + CIRCLE_RADIUS + SIZE);
    }
}//end class
