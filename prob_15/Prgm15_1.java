package prob_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm15_1 extends JFrame implements ActionListener {
    JButton b1;
    JPanel p;
    Prgm15_1(){
        setTitle("배경색 바꾸기");

        p = new JPanel();
        b1 = new JButton("클릭");
//        패널에 대해서만 배경색 변경됨
        p.setBackground(Color.YELLOW);
        b1.addActionListener(this);
        p.add(b1);
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (p.getBackground() == Color.YELLOW) {
            p.setBackground(null);
        }else
            p.setBackground(Color.YELLOW);
    }

    public static void main(String[] args) {
        new Prgm15_1();
    }
}
