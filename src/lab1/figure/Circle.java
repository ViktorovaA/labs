package lab1.figure;

import javax.swing.*;
import java.awt.*;

/** окружность **/
public class Circle extends JPanel {
    public int x, y, radius;
    public Color color;

    /** конструктор 1 **/
    public Circle() {
        setLayout(null);
        setOpaque(false);
        this.x = 0;
        this.y = 0;
        this.radius = 0;
        this.color = Color.BLACK;
    }
    /** конструктор 2 **/
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = Color.BLACK;
    }
    /** показывает куг на панели **/
    public void show() {
        this.repaint();
    }
    /** передвигает фигуру на dx, dy относительно предыдущей точки **/
    public void moveTo(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    /** устанавливает радиус **/
    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }
    /** переопределенный метод, отрисовывающий фигуру **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
