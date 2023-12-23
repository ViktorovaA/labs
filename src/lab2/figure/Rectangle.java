package lab2.figure;

import javax.swing.*;
import java.awt.*;

/* прямоугольник */
public class Rectangle extends JPanel{
    public Point point;
    public int width, height;
    public Color color;

    public Rectangle() {
        setLayout(null);
        setOpaque(false);
        this.point = new Point();
        this.width = 0;
        this.height = 0;
        this.color = Color.BLUE;
    }
    public Rectangle(int x, int y, int w, int h) {
        this.point = new Point(x, y);
        this.width = w;
        this.height = h;
        this.color = Color.BLUE;
    }
    public void show() {
        this.repaint();
    }
    public void moveTo(int dx, int dy) {
        point.set(point.getX() + dx, point.getY() + dy);
    }
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(point.getX(), point.getY(), width, height);
    }
}
