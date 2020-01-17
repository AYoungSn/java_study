package prob_14;

import javax.swing.*;

//BoxLayout을 이용해서 5개의 버튼을 수평으로 나열
public class Prgm14_7 extends JFrame {
    Prgm14_7(){
        setTitle("박스 레이아웃");
        JButton b1 = new JButton("버튼 1");
        JButton b2 = new JButton("버튼 2");
        JButton b3 = new JButton("버튼 3");
        JButton b4 = new JButton("버튼 4");
        JButton b5 = new JButton("버튼 5");
        JPanel p = new JPanel();

        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);

        p.setLayout(new BoxLayout(p, BoxLayout.LINE_AXIS));
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,100);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Prgm14_7();
    }
}
