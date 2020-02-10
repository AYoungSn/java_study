package prob17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Pr3_Server extends JFrame {
    JTextField field = new JTextField(30);
    private JTextArea area = new JTextArea(10, 30);
    private Socket connection = null;
    ServerSocket server = null;
    private PrintWriter pw;
    private BufferedReader br;

    Pr3_Server() {
        setTitle("채팅 서버");
        area.setText("");
        area.setEditable(false);
        area.setAutoscrolls(true);

        try {
            server = new ServerSocket(9000);
            Thread connect = new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        while (true) {
                            area.append("연결 대기 중...\n");
                            connection = server.accept();
                            area.append(connection.getInetAddress().getHostAddress() + "와 연결\n");
                            pw = new PrintWriter(connection.getOutputStream(), true);
                            br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                            String string;
                            while ((string = br.readLine()) != null) {
                                area.append(string + "\n");
                                area.setCaretPosition(area.getDocument().getLength());
                                if (string.equals("잘 있어")) {
                                    area.append("클라이언트와 연결 종료\n");
                                    pw.close();
                                    br.close();
                                    connection.close();
                                    break;
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            connect.start();
        } catch (IOException e) {

        }
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    pw.println("서버>>> " + field.getText());
                    area.append("서버>>> " + field.getText() + "\n");
                    area.setCaretPosition(area.getDocument().getLength());
                    field.setText("");
                }
            }
        });

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
        new Pr3_Server();
    }
}
