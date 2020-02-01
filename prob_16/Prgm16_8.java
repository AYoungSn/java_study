package prob_16;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Prgm16_8 extends JFrame {
    int x1, y1,x2, y2;

    public static void main(String[] args) {
        new Prgm16_8();
    }
    Prgm16_8(){
        setTitle("클리핑 영역 움직이기");

        Move p = new Move();
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }
    class Move extends JPanel implements MouseListener, MouseMotionListener{
        BufferedImage dog;
        int a = 0, b = 0;
        boolean isDragged;
        Move(){
            addMouseListener(this);
            addMouseMotionListener(this);
            isDragged=false;
            try {
                dog = ImageIO.read(new File("D:\\temp\\dog.jpg"));
            } catch (IOException e) {
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setClip(a, b, 100, 100);

            g.drawImage(dog, 0, 0, null);
        }
        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();
            if (x1 >= a && x1 <= a + 100 && y1 >= b && y1 <= b + 100) {
                x1 = e.getX()-a;
                y1 = e.getY()-b;
                isDragged = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            isDragged = false;
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(isDragged) {
                x2 = e.getX();
                y2 = e.getY();
                a = (x2 - x1);
                b = (y2 - y1);
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }
}
