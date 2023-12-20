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
    private JPanel layout;
    private JPanel btnLayout;
    /** кнопки **/
    private JButton btnCreateRectangle, btnCreateCircle, btnDelete, btnMoveToRectangle, btnMoveToCircle,
            btnSetRectangleWidth, btnSetRectangleHeight, btnSetCircleRadius;

    /** конструктор **/
    public Canvas() {
        // создания места отрисовки фигур
        layout = new JPanel();
        layout.setLayout(new BorderLayout());

        // создание места отображения кнопок
        btnLayout = new JPanel();
        btnLayout.setLayout(new FlowLayout());

        // создание кнопок
        btnCreateRectangle = new JButton("Создать прямоугольник");
        btnCreateCircle = new JButton("Создать круг");
        btnMoveToRectangle = new JButton("переместить прямоугольник");
        btnMoveToCircle = new JButton("переместить круг");
        btnSetRectangleWidth = new JButton("ширина");
        btnSetRectangleHeight = new JButton("высота");
        btnSetCircleRadius = new JButton("радиус");

        // listener - реагирование на нажатие кнопок
        btnCreateRectangle.addActionListener(new BListener(this));
        btnCreateCircle.addActionListener(new BListener(this));
        btnMoveToRectangle.addActionListener(new BListener(this));
        btnMoveToCircle.addActionListener(new BListener(this));
        btnSetRectangleWidth.addActionListener(new BListener(this));
        btnSetRectangleHeight.addActionListener(new BListener(this));
        btnSetCircleRadius.addActionListener(new BListener(this));

        // добавление кнопок в место их отображения
        btnLayout.add(btnCreateRectangle);
        btnLayout.add(btnCreateCircle);
        btnLayout.add(btnMoveToRectangle);
        btnLayout.add(btnMoveToCircle);
        btnLayout.add(btnSetRectangleWidth);
        btnLayout.add(btnSetRectangleHeight);
        btnLayout.add(btnSetCircleRadius);

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

        circle = null;
        rectangle = null;
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
        }
    }

    // запуск программы
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Canvas::new);
    }
}