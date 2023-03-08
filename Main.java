// Daniel Isaksson
// Daniel.isaksson90@gmail.com
package Geometry;
import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args){

        Panel p = new Panel();
        p.setBackground(Color.LIGHT_GRAY);

        JFrame db = new JFrame("Geometry");
        db.setSize(450,300);
        db.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        db.add(p);
        db.setVisible(true);

    }//main

}//Main
