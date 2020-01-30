package prob_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm15_3 extends JFrame implements ActionListener {
    JTextField t1, t2;
    Prgm15_3(){
        setTitle("섭씨 -> 화씨 변환");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        JLabel l1 = new JLabel("섭씨");
        JLabel l2 = new JLabel("화씨");

        JPanel bp = new JPanel();
        JButton b = new JButton("변환");
        b.addActionListener(this);
        bp.add(b);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel panel = new JPanel(new GridLayout(3, 0));


        p1.add(l1);
        p1.add(t1);
        p2.add(l2);
        p2.add(t2);

        panel.add(p1);
        panel.add(p2);
        panel.add(bp);
        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (t1.getText().isEmpty()) {
            t2.setText("?");
        } else {
            double h=Double.parseDouble(t1.getText());
            h = (h * 9 / 5) + 32;
            t2.setText(""+h);
        }
    }

    public static void main(String[] args) {
        new Prgm15_3();
    }
}
