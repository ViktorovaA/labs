package lab1.figure;

import javax.swing.*;
import java.awt.*;

/** отрезок **/
public class Line extends JPanel {
    int x, y, length, angle;
    public Color color;

    /** конструктор 1 **/
    public Line() {
        setLayout(null);
        setOpaque(false);
        this.angle = 0;
        this.length = 20;
        this.x = 20;
        this.y = 20;
        this.color = Color.RED;
    }
    /** конструктор 2 **/
    public Line(int x, int y, int length, int angle) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.angle = angle;
        this.color = Color.RED;
    }
    /** показывает фигуру на панели **/
    public void show() {
        this.repaint();
    }
    /** передвигает фигуру на dx, dy относительно предыдущей точки **/
    public void moveTo(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setLength(int length) {
        this.length = length;
    }

    /** переопределенный метод, отрисовывающий фигуру **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawLine(x + (int) (length / 2 * Math.cos(angle)),
                y + (int) (length / 2 * Math.sin(angle)),
                x - (int) (length / 2 * Math.cos(angle)),
                y - (int) (length / 2 * Math.sin(angle)));
    }
}
