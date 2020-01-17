package prob_14;

import javax.swing.*;
import java.util.Random;

//난수를 발생해 임의의 자리에 알파벳 표시
public class Prgm14_5 extends JFrame {
    Prgm14_5(){
        setTitle("난수 알파벳");
        JPanel p = new JPanel();
        p.setLayout(null);
        String[] ap = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        JLabel[] label = new JLabel[ap.length];
        int i=0;
        Random r = new Random();
        for (String s : ap) {
            label[i++] = new JLabel(s);
            label[i - 1].setBounds(r.nextInt(300), r.nextInt(200), 10, 15);
            p.add(label[i - 1]);
        }
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Prgm14_5();
    }
}
