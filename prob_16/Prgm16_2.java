package prob_16;

import javax.swing.*;
import java.awt.*;

public class Prgm16_2 extends JFrame {
    Prgm16_2(){
        setTitle("동심원 무지개");
        add(new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.drawOval(10, 10, 200, 200);

                g.setColor(Color.ORANGE);
                g.drawOval(20, 20, 180, 180);

                g.setColor(Color.YELLOW);
                g.drawOval(30, 30, 160, 160);

                g.setColor(Color.GREEN);
                g.drawOval(40, 40, 140, 140);

                g.setColor(Color.BLUE);
                g.drawOval(50, 50, 120, 120);

                g.setColor(Color.BLACK);
                g.drawOval(60, 60, 100, 100);

                g.setColor(new Color(200, 30, 200));
                g.drawOval(70, 70, 80, 80);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm16_2();
    }
}
