package prob_16;

import javax.swing.*;
import java.awt.*;

public class Prgm16_3 extends JFrame {
    class Signal extends JPanel{
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.DARK_GRAY);
            g.fillRoundRect(50, 30, 150, 50, 30, 30);

            g.setColor(Color.RED);
            g.fillOval(50, 30, 50, 50);

            g.setColor(Color.YELLOW);
            g.fillOval(100, 30, 50, 50);

            g.setColor(Color.GREEN);
            g.fillOval(150, 30, 50, 50);
        }
    }
    Prgm16_3(){
        setTitle("신호등");

        add(new Signal());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm16_3();
    }
}
