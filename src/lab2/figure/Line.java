package lab2.figure;

import javax.swing.*;
import java.awt.*;

/** отрезок **/
public class Line extends JPanel {
    Point point;
    int length, angle;
    public Color color;

    /** конструктор 1 **/
    public Line() {
        setLayout(null);
        setOpaque(false);
        this.angle = 0;
        this.length = 20;
        this.point = new Point(20, 20);
        this.color = Color.RED;
    }
    /** конструктор 2 **/
    public Line(int x, int y, int length, int angle) {
        this.point = new Point(x, y);
        this.length = length;
        this.angle = angle;
        this.color = Color.RED;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setLength(int length) {
        this.length = length;
    }
    /** показывает фигуру на панели **/
    public void show() {
        this.repaint();
    }
    /** передвигает фигуру на dx, dy относительно предыдущей точки **/
    public void moveTo(int dx, int dy) {
        point.set(point.getX() + dx, point.getY() + dy);
    }

    public Point getPoint1() {
        return new Point(point.getX() + (int) (length / 2 * Math.cos(angle)),
                point.getY() + (int) (length / 2 * Math.sin(angle)));
    }
    public Point getPoint2() {
        return new Point(point.getX() - (int) (length / 2 * Math.cos(angle)),
                point.getY() - (int) (length / 2 * Math.sin(angle)));
    }

    /** переопределенный метод, отрисовывающий фигуру **/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawLine(point.getX() + (int) (length / 2 * Math.cos(angle)),
                point.getY() + (int) (length / 2 * Math.sin(angle)),
                point.getX() - (int) (length / 2 * Math.cos(angle)),
                point.getY() - (int) (length / 2 * Math.sin(angle)));
    }
}
