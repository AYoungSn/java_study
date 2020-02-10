package prob17;

import java.sql.*;

public class Pr4 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/contacts";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//드라이버 메모리에 로드

            System.out.println("데이터베이스 연결 중...");
            con = DriverManager.getConnection(url, "root", "password");
            System.out.println("데이터 베이스 연결 성공");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("show databases");

            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            con.close();
            stmt.close();
            rs.close();
        } catch (ClassNotFoundException e) {

        } catch (SQLException e) {

        }
    }
}
