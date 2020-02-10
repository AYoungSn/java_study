package prob17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Pr1_Client extends JFrame {
    static Socket client;
    static BufferedReader in;
    JTextArea area;

    Pr1_Client() throws IOException {
        setTitle("클라이언트");
        setLayout(new BorderLayout());

        JTextField field = new JTextField(50);
        area = new JTextArea(30, 50);

        String serverIP = JOptionPane.showInputDialog("서버의 IP 주소는?");
        try {
            client = new Socket(serverIP, 9000);
            in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            PrintWriter printWriter = new PrintWriter(client.getOutputStream(),true);

            area.setText(in.readLine()+"\n");
            area.append(in.readLine()+"\n");

            field.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        printWriter.println(field.getText());
                        try {
                            if(field.getText().equals(".")) {
                                System.out.println("클라이언트 종료");
                            }else {
                                area.append("\n" + in.readLine());
                            }
                        }catch(IOException i){
                            System.out.println(i.getMessage());
                            i.printStackTrace();
                        }
                    }
                }
            });
        } catch (IOException e) {

        }

        add(field, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new Pr1_Client();
        } catch (IOException e) {

        }
    }
}
