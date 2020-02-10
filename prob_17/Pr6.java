package prob17;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Pr6 extends JFrame {
    JTextField[] text=new JTextField[3];
    JButton[] buttons = new JButton[8];
    Connection con = null;
    Pr6(){
        setTitle("연락처");
        String url = "jdbc:mysql://localhost/contacts";
        JLabel[] labels = {new JLabel("이름"), new JLabel("전화번호"), new JLabel("이메일")};

        JPanel[] panels = {new JPanel(new GridLayout(3, 2,5,5)),
                new JPanel(new GridLayout(3, 3,5,5))};

        for (int i = 0; i < 3; i++) {
            panels[0].add(labels[i]);
            text[i] = new JTextField("",20);
            panels[0].add(text[i]);
        }

        buttons[0] = new JButton("추가");
        buttons[1] = new JButton("삭제");
        buttons[2] = new JButton("갱신");
        buttons[3] = new JButton("<<");
        buttons[4] = new JButton("탐색");
        buttons[5] = new JButton(">>");
        buttons[6] = new JButton("백지화");
        buttons[7] = new JButton("종료");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("데이터베이스 연결 중...");
            con = DriverManager.getConnection(url, "root", "password");
            System.out.println("데이터베이스 연결 성공");

            ButtonL l=new ButtonL();
            for (int i = 0; i < 7; i++) {
                buttons[i].addActionListener(l);
                panels[1].add(buttons[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        panels[1].add(new JLabel());
        panels[1].add(buttons[7]);

        JPanel jpanel = new JPanel(new GridLayout(2,0,5,5));
        jpanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        jpanel.add(panels[0]);
        jpanel.add(panels[1]);

        add(jpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        pack();
        setVisible(true);
    }
    class ButtonL implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String sql;
                PreparedStatement pstmt;
                if (e.getSource() instanceof JButton) {
                    JButton b = (JButton) e.getSource();
                    if (text[0].getText() == "" && text[1].getText() == "" && text[2].getText() == "")
                        System.out.println("입력하세요");
                    ResultSet rs;
                    switch (b.getText()) {
                        case "추가":
                            sql = "insert into person (name, phone, email) values (?,?,?)";
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, text[0].getText());
                            pstmt.setString(2, text[1].getText());
                            pstmt.setString(3, text[2].getText());
                            pstmt.execute();
                            break;
                        case "삭제":
                            sql = "delete from person where phone=?";
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, text[1].getText());
                            pstmt.execute();
                            text[0].setText("");
                            text[1].setText("");
                            text[2].setText("");
                            break;
                        case "갱신":
                            sql = "update person set phone=? where name=?";
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, text[1].getText());
                            pstmt.setString(2, text[0].getText());
                            pstmt.execute();
                            break;
                        case "백지화":
                            for(int i=0;i<3;i++)
                                text[i].setText("");
                            break;
                        case "종료":
                            con.close();
                            System.exit(0);
                            return;
                    }
                    if (b.getText().equals("탐색")||b==buttons[3]||b==buttons[5]) {
                        if(b==buttons[4]) {
                            sql = "select * from person where name=?";
                            pstmt = con.prepareStatement(sql);
                            pstmt.setString(1, text[0].getText());
                            rs = pstmt.executeQuery();
                            if(rs.next()) {
                                text[0].setText(rs.getString(1));
                                text[1].setText(rs.getString(2));
                                text[2].setText(rs.getString(3));
                            }
                            buttons[3].addActionListener(e1->{
                                try {
                                    if(rs.previous()) {
                                        text[0].setText(rs.getString(1));
                                        text[1].setText(rs.getString(2));
                                        text[2].setText(rs.getString(3));
                                    }
                                } catch (SQLException e2) {
                                    e2.printStackTrace();
                                }
                            });
                            buttons[5].addActionListener(e1 -> {
                                try {
                                    if(rs.next()) {
                                        text[0].setText(rs.getString(1));
                                        text[1].setText(rs.getString(2));
                                        text[2].setText(rs.getString(3));
                                    }
                                } catch (SQLException e2) {
                                    e2.printStackTrace();
                                }
                            });
                        }
                    }
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        new Pr6();
    }
}
