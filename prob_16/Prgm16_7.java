package prob_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Prgm16_7 extends JFrame {
    public static void main(String[] args) {
        new Prgm16_7();
    }
    int x1, x2,y1, y2;
    Prgm16_7(){
        setTitle("마우스로 사각형");

        JPanel p1=new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
            }
        };
        MyListener listener = new MyListener();
        p1.addMouseListener(listener);
        p1.addMouseMotionListener(listener);
        JPanel p2 = new JPanel();

        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        JButton b4 = new JButton();
        JButton b5 = new JButton();

        b1.setBackground(Color.BLACK);
        b1.addActionListener(e -> {
            p1.setForeground(Color.BLACK);
            repaint();
        });
        b2.setBackground(Color.RED);
        b2.addActionListener(e -> {
            p1.setForeground(Color.RED);
            repaint();
        });
        b3.setBackground(Color.GREEN);
        b3.addActionListener(e -> {
            p1.setForeground(Color.GREEN);
            repaint();
        });
        b4.setBackground(Color.BLUE);
        b4.addActionListener(e -> {
            p1.setForeground(Color.BLUE);
            repaint();
        });
        b5.setBackground(Color.YELLOW);
        b5.addActionListener(e -> {
            p1.setForeground(Color.YELLOW);
            repaint();
        });
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);

        add("Center", p1);
        add("South", p2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setVisible(true);
    }
    class MyListener implements MouseMotionListener, MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
            x2 = x1;
            y2 = y1;
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            x2 = e.getX();
            y2 = e.getY();
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
}
