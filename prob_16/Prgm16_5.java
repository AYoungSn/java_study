package prob_16;

import javax.swing.*;
import java.awt.*;

public class Prgm16_5 extends JFrame {
    Prgm16_5() {
        setTitle("3개의 팬");

        add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.fillArc(50, 50, 80, 80, 0, 30);
                g.fillArc(50, 50, 80, 80, 120, 30);
                g.fillArc(50, 50, 80, 80, 240, 30);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm16_5();
    }
}
