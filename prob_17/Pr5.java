package prob17;

import java.sql.*;
import java.util.Scanner;

public class Pr5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/contacts";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("데이터베이스 연결 중...");
            con = DriverManager.getConnection(url, "root", "password");
            System.out.println("데이터베이스 연결 성공");
            Scanner in = new Scanner(System.in);
            String choice;
            PreparedStatement pstmt;


            System.out.print("다음 중 하나를 선택하세요 : s(show), a(add), d(delete) -> ");
            choice = in.nextLine();
            String s;
            if(choice.equals("a")) {
                s = "insert into person (name, phone, email) values (?,?,?)";
                pstmt = con.prepareStatement(s);
                System.out.println("추가할 레코드의 이름, 전화번호, 이메일은?");
                System.out.print("이름: ");
                pstmt.setString(1, in.nextLine());
                System.out.print("전화번호: ");
                pstmt.setString(2, in.nextLine());
                System.out.print("이메일: ");
                pstmt.setString(3, in.nextLine());
                pstmt.execute();
            }else if(choice.equals("d")){
                    s = "delete from person where name=?";
                    pstmt = con.prepareStatement(s);
                    System.out.println("추가할 레코드의 이름, 전화번호, 이메일은?");
                    System.out.print("이름: ");
                    pstmt.setString(1, in.nextLine());
                    pstmt.execute();
            }
            System.out.println("## 연락처 리스트 ##");
            s = "select * from person";
            pstmt = con.prepareStatement(s);
            ResultSet rs = pstmt.executeQuery(s);
            while (rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.println(rs.getString(3));
            }
            pstmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
