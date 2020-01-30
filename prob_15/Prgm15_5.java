package prob_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Prgm15_5 extends JFrame {
    Prgm15_5(){
        setTitle("임의의 배경색");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(new Random().nextInt(256), new Random().nextInt(256),
                new Random().nextInt(256)));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                Prgm15_5.this.getContentPane().setBackground(new Color(new Random().nextInt(256),
//                        new Random().nextInt(256), new Random().nextInt(256)));
                panel.setBackground(new Color(new Random().nextInt(256), new Random().nextInt(256),
                        new Random().nextInt(256)));
            }
        });
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }


    public static void main(String[] args) {
        new Prgm15_5();
    }
}
