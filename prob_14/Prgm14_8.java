package prob_14;

import javax.swing.*;
import java.awt.*;

//5개의 카드 돌리기 프로그램 외형을 구현
public class Prgm14_8 extends JFrame {
    public Prgm14_8() {
        setTitle("카드 레이아웃");

        JPanel panel = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(0, 4, 5, 5));
        JPanel p2 = new JPanel(new CardLayout());

        JButton b1 = new JButton("<<");
        JButton b2 = new JButton("<");
        JButton b3 = new JButton(">");
        JButton b4 = new JButton(">>");
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);
        panel.add(p1, BorderLayout.NORTH);

        p2.add("1", new JButton("카드번호 1"));
        p2.add("2", new JButton("카드번호 2"));
        p2.add("3", new JButton("카드번호 3"));
        p2.add("4", new JButton("카드번호 4"));
        p2.add("5", new JButton("카드번호 5"));
        panel.add(p2, BorderLayout.CENTER);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm14_8();
    }
}
