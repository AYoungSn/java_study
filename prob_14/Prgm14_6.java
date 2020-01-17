package prob_14;

import javax.swing.*;

//여러개의 버튼을 하나의 그룹으로 묶어서 1개의 버튼만 선택하도록
public class Prgm14_6 extends JFrame {
    public Prgm14_6(){
        setTitle("애완 동물");
        JPanel p = new JPanel();
        JRadioButton r1 = new JRadioButton("강아지");
        JRadioButton r2 = new JRadioButton("고양이");
        JRadioButton r3 = new JRadioButton("금붕어");
        p.add(r1);
        p.add(r2);
        p.add(r3);

        ButtonGroup group = new ButtonGroup();
        group.add(r1);
        group.add(r2);
        group.add(r3);

        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm14_6();
    }
}
