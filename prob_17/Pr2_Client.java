package prob17;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Pr2_Client extends JFrame {
    Pr2_Client(){
        setTitle("파일 탐색 클라이언트");
        JPanel p = new JPanel();
        JLabel l1 = new JLabel("파일 이름은?");
        JLabel l2 = new JLabel("D:\\temp\\print.txt");
        l2.setBackground(Color.GRAY);
        l1.setBackground(Color.white);
        p.add(l1);
        p.add(l2);

        JTextArea area = new JTextArea("",30, 30);
        area.setEditable(false);
        try {
            Socket client = new Socket("localhost", 9000);
            BufferedReader brin = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            pw.println("D:\\temp\\print.txt");
            String str;
            while ((str = brin.readLine()) != null) {
                area.append(str+"\n");
            }

            client.close();
            brin.close();
            pw.close();
        } catch (IOException e) {

        }

        add(p, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new Pr2_Client();
    }
}
