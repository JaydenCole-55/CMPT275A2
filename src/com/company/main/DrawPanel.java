package com.company.main;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    // Create shapes of the pipe within this JPanel
    Rectangle fillerRec = new Rectangle();
    Ellipse outerEllipse = new Ellipse();
    Ellipse innerEllipse = new Ellipse();
    Ellipse bottomEllipse = new Ellipse();
    Line side1 = new Line();
    Line side2 = new Line();

    // Keep the bottom left corner the same position for all cylinders
    static int BOTTOM_LEFT_CORNER_X  = 50;
    static int BOTTOM_LEFT_CORNER_Y  = 160;

    // Ensure all ellipses are same height for 3D consistency
    static int ELLIPSE_HEIGHT = 40;

    // Scale how large the user's inputs are displayed
    static int SCALE_FACTOR = 30;

    // Ratio of the outer radius to the inner radius (thickness to hole) to make visual of pipe hole correct
    double radiusRatio;

    // Update image calls functions to redraw the shapes to the new user specifcations and then repaints them
    public void updateImage(double height, double thickness, double radius){
        // Calculate important points and get measurements
        int innerRad  = (int) (radius*SCALE_FACTOR);
        int outerRad  = (int) ((radius + thickness)*SCALE_FACTOR);
        int cylHeight = (int) (height*SCALE_FACTOR);
        radiusRatio = Double.valueOf(innerRad)/Double.valueOf(outerRad);

        // Change components to reflect user inputs
        changeEllipse(bottomEllipse, BOTTOM_LEFT_CORNER_X, BOTTOM_LEFT_CORNER_Y-(ELLIPSE_HEIGHT/2),
                2*outerRad, Color.BLUE, 1);

        changeRec(fillerRec, BOTTOM_LEFT_CORNER_X,BOTTOM_LEFT_CORNER_Y-cylHeight, 2*outerRad, cylHeight);

        changeSide(side1, BOTTOM_LEFT_CORNER_X, BOTTOM_LEFT_CORNER_Y, BOTTOM_LEFT_CORNER_Y-cylHeight);

        changeSide(side2, BOTTOM_LEFT_CORNER_X+2*outerRad, BOTTOM_LEFT_CORNER_Y, BOTTOM_LEFT_CORNER_Y-cylHeight);

        changeEllipse(outerEllipse, BOTTOM_LEFT_CORNER_X,BOTTOM_LEFT_CORNER_Y-cylHeight-(ELLIPSE_HEIGHT/2),
                2*outerRad, Color.BLUE, 1);

        changeEllipse(innerEllipse,BOTTOM_LEFT_CORNER_X+outerRad-innerRad,
                BOTTOM_LEFT_CORNER_Y-cylHeight-((int)(ELLIPSE_HEIGHT/2*radiusRatio)),
                2*innerRad, Color.WHITE, radiusRatio);

        // Paint to screen
        repaint();
    }

    // Changes one of the ellipses in the drawing ot the correct dimensions
    private void changeEllipse(Ellipse e, int x, int y, int d, Color color, double ratio){
        e.setxPos(x);
        e.setyPos(y);
        e.setdiameter(d);
        e.setRatio(ratio);
        e.setEllipseColor(color);
    }

    // Moves pipe black outline on teh straight sides to the appropriate length and position
    private void changeSide(Line l, int x, int starty, int endy){
        l.setStartx(x);
        l.setStarty(starty);
        l.setEndy(endy);
    }

    // Updates a rectangle to the users dimensions to fill in the pipe
    private void changeRec(Rectangle r, int x, int y, int width, int height){
        r.setX(x);
        r.setY(y);
        r.setWidth(width);
        r.setHeight(height);
    }

    // Paint the components of the pipe drawing to the screen
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        bottomEllipse.paintEllipse(g, true);
        fillerRec.paintRec(g);
        outerEllipse.paintEllipse(g, true);
        innerEllipse.paintEllipse(g, true);
        side1.paintLine(g);
        side2.paintLine(g);
    }
}

class Ellipse{
    private int xPos = 0;
    private int yPos = 0;
    private int diameter = 0;
    private double ratio = 1;
    private static int HEIGHT = 40;
    private Color ellipseColor = Color.BLUE;

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public void setdiameter(int diameter) {
        this.diameter = diameter;
    }

    public void setEllipseColor(Color theColor) {
        this.ellipseColor = theColor;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public void paintEllipse(Graphics g, boolean addBorder){
        g.setColor(ellipseColor);
        g.fillOval(xPos, yPos, diameter, (int) (HEIGHT*ratio));
        if (addBorder) {
            g.setColor(Color.BLACK);
            g.drawOval(xPos, yPos, diameter, (int) (HEIGHT*ratio));
        }
    }
}

class Line{
    private int x = 0;
    private int starty = 0;
    private int endy   = 0;

    public void setStartx(int x) {
        this.x = x;
    }

    public void setStarty(int starty) {
        this.starty = starty;
    }

    public void setEndy(int endy) {
        this.endy = endy;
    }

    public void paintLine(Graphics g){
        g.setColor(Color.BLACK);
        g.drawLine(x, starty, x, endy);
    }
}

class Rectangle{
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void paintRec(Graphics g){
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
    }
}