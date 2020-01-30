package prob_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm15_2 extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4;
    JPanel p2;
    CardLayout card;

    public Prgm15_2() {
        setTitle("카드 레이아웃");

        JPanel panel = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(0, 4, 5, 5));
        card = new CardLayout();
        p2 = new JPanel(card);

        b1 = new JButton("<<");
        b1.addActionListener(this);
        b2 = new JButton("<");
        b2.addActionListener(this);
        b3 = new JButton(">");
        b3.addActionListener(this);
        b4 = new JButton(">>");
        b4.addActionListener(this);

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
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            card.first(p2);
        } else if (e.getSource() == b2) {
            card.previous(p2);
        } else if (e.getSource() == b3) {
            card.next(p2);
        }else
            card.last(p2);
    }

    public static void main(String[] args) {
        new Prgm15_2();
    }
}
