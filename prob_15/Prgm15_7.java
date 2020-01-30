package prob_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm15_7 extends JFrame {
    Prgm15_7(){
        JRadioButton[] get = new JRadioButton[3];
        String[] name = {"강아지", "고양이", "금붕어"};
        ImageIcon[] image = {new ImageIcon("D:\\성신\\java_practice\\javaThree\\ch15\\src\\prob_15\\dog.jpg"),
                new ImageIcon("D:\\성신\\java_practice\\javaThree\\ch15\\src\\prob_15\\cat.jpg"),
                new ImageIcon("D:\\성신\\java_practice\\javaThree\\ch15\\src\\prob_15\\goldfish.jpg")};
        JLabel label = new JLabel();

        setTitle("애완 동물");
        int i=0;
        ActionListener al=(e)->{
            if(e.getSource()==get[0])
                label.setIcon(image[0]);
            else if (e.getSource() == get[1]) {
                label.setIcon(image[1]);
            }
            else
                label.setIcon(image[2]);
        };
        add(label, BorderLayout.CENTER);
        JPanel panel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        for (String s : name) {
            get[i] = new JRadioButton(s);
            get[i].addActionListener(al);
            panel.add(get[i]);
            group.add(get[i++]);
        }

        add(panel, BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm15_7();
    }
}
