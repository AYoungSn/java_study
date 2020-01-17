package prob_14;

import javax.swing.*;
import java.awt.*;

//색상을 선택할 수 있는 프로그램의 외형
public class Prgm14_4 extends JFrame {
    Prgm14_4(){
        setTitle("색상 선택기");
        setLayout(new FlowLayout());
        JPanel p1 = new JPanel();
        String[] string = {"빨간색", "초록색", "파란색"};
        JComboBox<String> color = new JComboBox<>(string);
        p1.add(color);

        JPanel p2 = new JPanel();
        JCheckBox c1 = new JCheckBox("배경색");
        JCheckBox c2 = new JCheckBox("전경색");
        p2.add(c1);
        p2.add(c2);

        JPanel p3 = new JPanel(new GridLayout(0, 2, 10, 10));
        JButton b1 = new JButton("예");
        JButton b2 = new JButton("아니오");
        p3.add(b1);
        p3.add(b2);

        add(p1);
        add(p2);
        add(p3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Prgm14_4();
    }
}
