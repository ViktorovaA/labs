package lab2.figure;

import javax.swing.*;
import java.awt.*;

import static java.lang.Integer.min;

public class Circle extends JPanel {
    public Point point;
    public int radius;
    public Color color;

    public Circle() {
        setLayout(null);
        setOpaque(false);
        this.point = new Point();
        this.radius = 0;
        this.color = Color.BLACK;
    }
    public Circle(int x, int y, int radius) {
        this.point = new Point(x, y);
        this.radius = radius;
        if (radius > min(x, y))
            this.radius = min(x, y);
        this.color = Color.BLACK;
        System.out.println("Circle: центр (" + x + ", " + y + ") радиус = " + radius);
    }
    public void show() {
        this.repaint();
    }
    public void moveTo(int dx, int dy) {
        this.point.set(this.point.getX() + dx, this.point.getY() + dy);
//        this.repaint();
    }
    public void setRadius(int newRadius) {
        this.radius = newRadius;
//        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawOval(point.getX() - radius, point.getY() - radius, radius * 2, radius * 2);
    }
}
