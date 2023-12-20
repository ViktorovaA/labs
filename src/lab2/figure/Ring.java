package lab2.figure;

import javax.swing.*;
import java.awt.*;

public class Ring extends JPanel {
    Circle externalCircle, internalCircle;

    public Ring() {
        externalCircle = new Circle();
        internalCircle = new Circle();
    }

    public Ring(int x, int y, int externalRadius, int internalRadius) {
        externalCircle = new Circle(x, y, externalRadius);
        internalCircle = new Circle(x, y, internalRadius);
    }

    public void setRadius(int externalRadius, int internalRadius) {
        if (externalRadius < internalRadius) {
            int a = externalRadius;
            externalRadius = internalRadius;
            internalRadius = a;
        }
        externalCircle.setRadius(externalRadius);
        internalCircle.setRadius(internalRadius);
    }

    public void moveTo(int dx, int dy) {
        externalCircle.moveTo(dx, dy);
        internalCircle.moveTo(dx, dy);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(externalCircle.point.getX() - externalCircle.radius,
                externalCircle.point.getY() - externalCircle.radius,
                externalCircle.radius * 2,
                externalCircle.radius * 2);
        g.drawOval(internalCircle.point.getX() - internalCircle.radius,
                internalCircle.point.getY() - internalCircle.radius,
                internalCircle.radius * 2,
                internalCircle.radius * 2);
    }

}
