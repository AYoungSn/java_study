package prob_16;

import javax.swing.*;
import java.awt.*;

public class Prgm16_1 extends JFrame {
    class CustomPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.RED);

            g.fillRect(0, 0, 220, 1);
            g.setColor(Color.BLACK);
            g.drawRect(10, 10, 200, 50);
            g.fillOval(100, 25, 20, 20);
        }
    }

    Prgm16_1() {
        setTitle("원과 사각형");
        CustomPanel customPanel = new CustomPanel();
        add(customPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(230, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm16_1();
    }
}
