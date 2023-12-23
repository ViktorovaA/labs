package lab1;

import lab1.figure.Circle;
import lab1.figure.Rectangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** окно, на котором происходит отрисовка **/
public class Canvas {
    /** основное окно **/
    private JFrame frame;
    /** круг **/
    lab1.figure.Circle circle;
    /** прямоугольник **/
    lab1.figure.Rectangle rectangle;
    /** отрезок **/
    lab1.figure.Line line;
    private JPanel layout;
    private JPanel btnLayout;
    /** кнопки **/
    private JButton btnCreateRectangle, btnCreateCircle, btnMoveToRectangle, btnMoveToCircle,
            btnSetRectangleWidth, btnSetRectangleHeight, btnSetCircleRadius, btnCreateLine, btnMoveToLine,
            btnSetLineAngle, btnSetLineLength;

    /** конструктор **/
    public Canvas() {
        // создания места отрисовки фигур
        layout = new JPanel();
        layout.setLayout(new BorderLayout());

        // создание места отображения кнопок
        btnLayout = new JPanel();
        btnLayout.setLayout(new GridLayout(3, 6, 10, 10));

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



        // listener - реагирование на нажатие кнопок
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

        // добавление кнопок в место их отображения
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

        // ширина и высота окна
        int width = 1000;
        int height = 500;

        // созжание окна
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.add(btnLayout, BorderLayout.NORTH);
        frame.add(layout, BorderLayout.CENTER);
        frame.setSize(width, height);
        frame.setLocation(300, 100);
        frame.setTitle("Drawing of figure");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // фигуры
        circle = null;
        rectangle = null;
        line = null;
    }

    // реагирование на нажатие кнопок
    class BListener implements ActionListener {
        Canvas canvas;
        /** конструктор **/
        public BListener(Canvas canvas){
            this.canvas = canvas;
        }
        /** реагирование на нажатие кнопок **/
        public void actionPerformed(ActionEvent e) {
            // создать прямоугольник
            if (e.getSource() == btnCreateRectangle) {
                if(rectangle != null) return;

                rectangle = new lab1.figure.Rectangle(400, 200, 100,50);
                canvas.layout.add(rectangle);
                canvas.layout.validate();
                canvas.layout.repaint();
            }
            // передвинуть прямоугольник
            if (e.getSource() == btnMoveToRectangle) {
                if(rectangle == null) return;

                rectangle.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
                canvas.layout.validate();
                canvas.layout.repaint();
            }
            // изменить ширину прямоугольника
            if (e.getSource() == btnSetRectangleWidth) {
                if(rectangle == null) return;

                rectangle.setWidth((int) (Math.random() * 200));
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            // изменить  высоту прямоугольника
            if (e.getSource() == btnSetRectangleHeight) {
                if(rectangle == null) return;

                rectangle.setHeight((int) (Math.random() * 200));
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            // создать круг
            if (e.getSource() == btnCreateCircle) {
                if(circle != null) return;

                circle = new lab1.figure.Circle(400, 250, 50);
                canvas.layout.add(circle);
                canvas.layout.validate();
                canvas.layout.repaint();
            }
            // передвинуть круг
            if (e.getSource() == btnMoveToCircle) {
                if(circle == null) return;

                circle.moveTo((int) (Math.random() * 100) - 50, (int) (Math.random() * 100) - 50);
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            // изменить радиус круга
            if (e.getSource() == btnSetCircleRadius) {
                if(circle == null) return;

                circle.setRadius((int) (Math.random() * 100));
                canvas.layout.revalidate();
                canvas.layout.repaint();
            }
            // создать отрезок
            if (e.getSource() == btnCreateLine) {
                if(line != null) return;

                line = new lab1.figure.Line(400, 200, 70, 90);
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
        }
    }

    // запуск программы
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Canvas::new);
    }
}