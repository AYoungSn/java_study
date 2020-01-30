package prob_15;

import org.w3c.dom.css.Counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prgm15_4 extends JFrame implements ActionListener {
    public static void main(String[] args) {
        new Prgm15_4();
    }
    JLabel l1;
    JButton b1, b2;
    int i;
    Thread thread;
    Prgm15_4(){
        setTitle("카운터 - 초");
        setLayout(new BorderLayout());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        i = 0;
        l1 = new JLabel("개수 = " + i);
        b1 = new JButton("시작");
        b1.addActionListener(this);
        b2 = new JButton("리셋");
        b2.addActionListener(this);

        p1.add(l1);
        p2.add(b1);
        p2.add(b2);

        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            if (thread == null || thread.isAlive() == false) {
                thread = new Thread(new Counter());
                thread.start();
                b1.setText("중지");
            } else {
                thread.interrupt();
                b1.setText("시작");
            }
        }else{
            if (thread != null) {
                thread.interrupt();
                i = 0;
                l1.setText("개수 = " + i);
            }
        }
    }
    class Counter implements Runnable {
        public void run() {
            try {
                while (true) {
                    l1.setText("개수 = " + ++i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e1) {
            }
        }
    }
}
