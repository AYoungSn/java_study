package prob_16;

import javax.swing.*;
import java.awt.*;

public class Prgm16_4 extends JFrame {
    class Face extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.ORANGE);
            g.fillOval(20, 20, 200, 200);
            g.setColor(Color.WHITE);
            g.fillOval(50, 40, 30, 50);
            g.fillOval(120, 40, 30, 50);
            g.setColor(Color.YELLOW);
            g.fillOval(80, 80, 30, 25);

            g.setColor(Color.BLACK);
            g.fillOval(55, 45, 13, 25);
            g.fillOval(125, 45, 13, 25);

            g.setColor(Color.RED);
            g.fillArc(40, 120, 150, 20, 0, -180);
        }
    }
    Prgm16_4(){
        setTitle("얼굴");

        add(new Face());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm16_4();
    }
}
