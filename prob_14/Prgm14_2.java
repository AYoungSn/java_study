package prob_14;

import javax.swing.*;

//이미지를 포함한 레이블이 있는 형태의 프로그램 작성
public class Prgm14_2 extends JFrame {
    Prgm14_2(){
        setTitle("이미지를 포함한 레이블");

        JLabel j = new JLabel(new ImageIcon("D:\\성신\\java_practice\\javaThree\\ch14\\src\\prob_14\\image.jpeg"));
        j.setText("곰인형");
        add(j);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Prgm14_2();
    }
}
