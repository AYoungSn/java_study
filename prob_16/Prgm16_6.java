package prob_16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm16_6 extends JFrame {
    Prgm16_6(){
        setTitle("파이 돌리기");
        JButton button = new JButton("클릭");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                repaint();
            }
        });
        JPanel p2=new JPanel(){
            int s=0;
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Color color = new Color((int) (Math.random() * 255.0),
                        (int) (Math.random() * 255.0), (int) (Math.random() * 255.0));
                g.setColor(color);
                g.fillArc(40,10,100,100,s,80);
                s += 80;
            }
        };
        JPanel p1 = new JPanel();
        p1.add(button);
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm16_6();
    }
}
