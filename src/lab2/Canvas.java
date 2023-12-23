package lab2;

import lab2.figure.*;
import lab2.figure.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Canvas {
    private JFrame frame;
    Circle circle;
    Rectangle rectangle;
    Line line;
    Ring ring;
    Face face;
    private JPanel layout;
    private JPanel btnLayout;
    private JButton btnCreateRectangle, btnCreateCircle, btnDelete, btnMoveToRectangle, btnMoveToCircle,
            btnSetRectangleWidth, btnSetRectangleHeight, btnSetCircleRadius, btnCreateLine, btnMoveToLine,
            btnSetLineAngle, btnSetLineLength, btnCreateRing, btnMoveToRing,
            btnSetRingRadius, btnCreateFace, btnMoveToFace, btnSetFaceSize;

    public Canvas() {

        layout = new JPanel();
        layout.setLayout(new BorderLayout());

        btnLayout = new JPanel();
        btnLayout.setLayout(new GridLayout(4, 6, 10, 10));

        // создание кнопок
        btnCreateRectangle = new JButton("Создать прямоугольник");
        btnCreateCircle = new JButton("Создать круг");
        btnMoveToRectangle = new JButton("переместить прямоугольник");
        btnMoveToCircle = new JButton("переместить круг");
        btnSetRectangleWidth = new JButton("ширина");
        btnSetRectangleHeight = new JButton("высота");
        btnSetCircleRadius = new JButton("радиус");
        btnCreateLine = new JButton("Создать отрезок");
        btnMoveToLine = new JButton("переместить отрезок");
        btnSetLineAngle = new JButton("повернуть отрезок");
        btnSetLineLength = new JButton("длина отрезка");
        btnCreateRing = new JButton("создать кольцо");
        btnMoveToRing = new JButton("переместить кольцо");
        btnSetRingRadius = new JButton("радиус кльца");
        btnCreateFace = new JButton("создать лицо");
        btnMoveToFace = new JButton("переместить лицо");
        btnSetFaceSize = new JButton("размер лица");

        //listener
        btnCreateRectangle.addActionListener(new BListener(this));
        btnCreateCircle.addActionListener(new BListener(this));
        btnMoveToRectangle.addActionListener(new BListener(this));
        btnMoveToCircle.addActionListener(new BListener(this));
        btnSetRectangleWidth.addActionListener(new BListener(this));
        btnSetRectangleHeight.addActionListener(new BListener(this));
        btnSetCircleRadius.addActionListener(new BListener(this));

        btnCreateLine.addActionListener(new BListener(this));
        btnMoveToLine.addActionListener(new BListener(this));
        btnSetLineAngle.addActionListener(new BListener(this));
        btnSetLineLength.addActionListener(new BListener(this));

        btnCreateRing.addActionListener(new BListener(this));
        btnMoveToRing.addActionListener(new BListener(this));
        btnSetRingRadius.addActionListener(new BListener(this));

        btnCreateFace.addActionListener(new BListener(this));
        btnMoveToFace.addActionListener(new BListener(this));
        btnSetFaceSize.addActionListener(new BListener(this));



        //add
        btnLayout.add(btnCreateRectangle);
        btnLayout.add(btnMoveToRectangle);
        btnLayout.add(btnSetRectangleWidth);
        btnLayout.add(btnSetRectangleHeight);

        btnLayout.add(btnCreateCircle);
        btnLayout.add(btnMoveToCircle);
        btnLayout.add(btnSetCircleRadius);

        btnLayout.add(btnCreateLine);
        btnLayout.add(btnMoveToLine);
        btnLayout.add(btnSetLineAngle);
        btnLayout.add(btnSetLineLength);

        btnLayout.add(btnCreateRing);
        btnLayout.add(btnMoveToRing);
        btnLayout.add(btnSetRingRadius);

        btnLayout.add(btnCreateFace);
        btnLayout.add(btnMoveToFace);
        btnLayout.add(btnSetFaceSize);

        int width = 1000;
        int height = 500;

        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(btnLayout, BorderLayout.NORTH);
        frame.add(layout, BorderLayout.CENTER);
        frame.setSize(width, height);
        frame.setLocation(300, 100);
        frame.setTitle("Drawing of figure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        circle = null;
        rectangle = null;
        ring = null;
        face = null;
    }
    class BListener implements ActionListener {
        Canvas canvas;
        public BListener(Canvas canvas){
            this.canvas = canvas;
        }
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnCreateRectangle) {
                if(rectangle != null) return;

                rectangle = new Rectangle(400, 200, 100,50);
                canvas.layout.add(rectangle);
//                canvas.layout.repaint();
                canvas.layout.revalidate();
            }
            if (e.getSource() == btnMoveToRectangle) {
                if(rectangle == null) return;

                rectangle.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
//                canvas.layout.validate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetRectangleWidth) {
                if(rectangle == null) return;

                rectangle.setWidth((int) (Math.random() * 200));
                canvas.layout.repaint();
                canvas.layout.revalidate();
            }
            if (e.getSource() == btnSetRectangleHeight) {
                if(rectangle == null) return;

                rectangle.setHeight((int) (Math.random() * 200));
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }

            if (e.getSource() == btnCreateCircle) {
                if(circle != null) return;

                circle = new Circle(400, 250, 50);
                canvas.layout.add(circle);
//                canvas.layout.repaint();
                canvas.layout.revalidate();
            }
            if (e.getSource() == btnMoveToCircle) {
                if(circle == null) return;

                circle.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetCircleRadius) {
                if(circle == null) return;

                circle.setRadius((int) (Math.random() * 100));
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }

            if (e.getSource() == btnCreateLine) {
                if(line != null) return;

                line = new Line(400, 200, 70, 90);
                canvas.layout.add(line);
                canvas.layout.validate();
                canvas.layout.repaint();
            }
            // передвинуть отрезок
            if (e.getSource() == btnMoveToLine) {
                if(line == null) return;

                line.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetLineAngle) {
                if(line == null) return;

                line.setAngle((int) (Math.random() * 360) - 180);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetLineLength) {
                if(line == null) return;

                line.setLength((int) (Math.random() * 200) - 100);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }

            if (e.getSource() == btnCreateRing) {
                if(ring != null) return;

                ring = new Ring(300, 200, 50, 30);
                canvas.layout.add(ring);
                canvas.layout.revalidate();
//                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetRingRadius) {
                if(ring == null) return;

                ring.setRadius((int) (Math.random() * 100), (int) (Math.random() * 100));
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnMoveToRing) {
                if(ring == null) return;

                ring.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }

            if (e.getSource() == btnCreateFace) {
                if(face != null) return;

                face = new Face(200, 200, 50);
                canvas.layout.add(face);
                canvas.layout.revalidate();
//                canvas.layout.repaint();
            }
            if (e.getSource() == btnSetFaceSize) {
                if(face == null) return;

                face.setSize((int) (Math.random() * 100));
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            if (e.getSource() == btnMoveToFace) {
                if(face == null) return;

                face.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
//                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Canvas::new);
    }
}