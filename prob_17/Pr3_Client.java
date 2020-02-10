package prob17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Pr3_Client extends JFrame {
    Pr3_Client(){
        setTitle("클라이언트");
        JTextField field = new JTextField(30);
        JTextArea area = new JTextArea(10, 30);

        try {
            area.setText("연결 시도\n");
            Socket client = new Socket("localhost", 9000);
            area.append(client.getInetAddress() + "와 연결 성공\n");
            PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));

            field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                        pw.println("클라이언트>>> " + field.getText());
                        area.append("클라이언트>>> " + field.getText() + "\n");
                        area.setCaretPosition(area.getDocument().getLength());
                        try {
                            if (field.getText().equals("잘 있어")) {
                                client.close();
                                pw.close();
                                br.close();
                                System.exit(0);
                            }
                        } catch (IOException e1) {

                        }
                        field.setText("");
                    }
                }
            });
            Thread receive = new Thread(() -> {
                String string;
                try {
                    while ((string = br.readLine()) != null) {
                        area.append(string + "\n");
                        area.setCaretPosition(area.getDocument().getLength());
                    }
                } catch (IOException e) {
                }
            });
            receive.start();

        } catch (IOException e) {

        }

        JScrollPane sp = new JScrollPane(area);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(field, BorderLayout.NORTH);
        add(sp, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Pr3_Client();
    }
}
