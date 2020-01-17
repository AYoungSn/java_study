package prob_14;

import javax.swing.*;
import java.awt.*;

//섭씨온도를 화씨온도로 변환시키는 프로그램의 외형
public class Prgm14_3 extends JFrame {
    Prgm14_3(){
        setTitle("섭씨 -> 화씨 변환");
        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);
        JLabel l1 = new JLabel("섭씨");
        JLabel l2 = new JLabel("화씨");

        JPanel bp = new JPanel();
        JButton b = new JButton("변환");
        bp.add(b);

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel panel = new JPanel(new GridLayout(3, 0));
//        JPanel panel = new JPanel();

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
    public static void main(String[] args) {
        new Prgm14_3();
    }
}
