package prob_15;

import javax.swing.*;
import java.util.Calendar;

public class Prgm15_6 extends JFrame {
    Prgm15_6(){
        setTitle("디지털 시계");

        Calendar cal = Calendar.getInstance();
        JPanel panel = new JPanel();
        JLabel label = new JLabel(""+cal.get(Calendar.HOUR)+":"+
                cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));

        panel.add(label);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Prgm15_6();
    }
}
