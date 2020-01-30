package prob_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm15_8 extends JFrame implements ActionListener {
    JTextField text;
    Prgm15_8(){
        setTitle("키패드");

        JPanel tp = new JPanel();
        text = new JTextField(15);
        tp.add(text);

        JPanel panel = new JPanel(new GridLayout(4, 3, 5, 5));
        JButton b;
        int[] num = {7, 8, 9, 4, 5, 6, 1, 2, 3, 0};
        for (int i : num) {
            b = new JButton("" + i);
            panel.add(b);
            b.addActionListener(this);
        }

        b = new JButton(".");
        panel.add(b);
        b.addActionListener(this);

        b = new JButton("CE");
        panel.add(b);
        b.addActionListener(this);

        tp.add(panel);
        add(tp);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = ((JButton)e.getSource()).getText();
        if (s.equals("CE")) {
            text.setText("");
        }else{
            text.setText(text.getText() + s);
        }
    }

    public static void main(String[] args) {
        new Prgm15_8();
    }
}
