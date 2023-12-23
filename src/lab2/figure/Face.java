package lab2.figure;

import javax.swing.*;
import java.awt.*;

public class Face extends JPanel {
    Circle leftEye, rightEye;
    Line mouth;
    Rectangle head;
    int size;

    public Face() {
        size = 50;
        leftEye = new Circle(size / 4, size / 4, size/8);
        rightEye = new Circle(size / 4 * 3, size / 4, size/8);
        mouth = new Line(size / 4, size / 4 * 3, size / 4 * 3, size / 4 * 3);
        head = new Rectangle(0, 0, size, size);
    }

    public Face(int x, int y, int size) {
        this.size = size;
        leftEye = new Circle(x + size / 4, y + size / 4, size/8);
        rightEye = new Circle(x + size / 4 * 3, y + size / 4, size/8);
        mouth = new Line(x + size / 2, y + size / 4 * 3, size / 2, 0);
        head = new Rectangle(x, y, size, size);
    }

    public void setSize(int size) {
        this.size = size;
        int x = head.point.getX();
        int y = head.point.getY();
        leftEye = new Circle(x + size / 4, y + size / 4, size/8);
        rightEye = new Circle(x + size / 4 * 3, y + size / 4, size/8);
        mouth = new Line(x + size / 4, y + size / 4 * 3, x + size / 4 * 3, y + size / 4 * 3);
        head = new Rectangle(x, y, size, size);
    }

    public void moveTo(int dx, int dy) {
        leftEye.moveTo(dx, dy);
        rightEye.moveTo(dx, dy);
        mouth.moveTo(dx, dy);
        head.moveTo(dx, dy);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(leftEye.point.getX() - leftEye.radius,
                leftEye.point.getY() - leftEye.radius,
                leftEye.radius * 2,
                leftEye.radius * 2);
        g.drawOval(rightEye.point.getX() - rightEye.radius,
                rightEye.point.getY() - rightEye.radius,
                rightEye.radius * 2,
                rightEye.radius * 2);
        g.drawLine(mouth.getPoint1().getX(), mouth.getPoint1().getY(),
                mouth.getPoint2().getX(), mouth.getPoint2().getY());
        g.drawRect(head.point.getX(), head.point.getY(), head.width, head.height);
    }

}
