package lab1.figure;

import javax.swing.*;
import java.awt.*;

/** прямоугольник **/
public class Rectangle extends JPanel{
    public int x, y, width, height;
    public Color color;

    /** конструктор 1 (по умолчанию) **/
    public Rectangle() {
        setLayout(null);
        setOpaque(false);
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        this.color = Color.BLUE;
    }
    /** конструктор 2 **/
    public Rectangle(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
        this.color = Color.BLUE;
    }
    /** отображает фигуру **/
    public void show() {
        this.repaint();
    }
    /** dfh **/
    public void moveTo(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    /** изменение ширины **/
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    /** изменение высоты **/
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }

    /** отрислвка фигуры **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(x, y, width, height);
    }
}
