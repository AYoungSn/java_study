package prob17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Pr1_Server {
    static int i=0;
    public static void main(String[] args) {
        System.out.println("대문자 변환 서버 실행 중...");
        try (ServerSocket server = new ServerSocket(9000);
             Socket connection = server.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
             PrintWriter out = new PrintWriter(connection.getOutputStream(), true);) {
            System.out.println("클라이언트 " + i + "번과 포트 " + connection.toString() + "번에서 새로운 연결");

            out.println("안녕, 너는 클라이언트 " + i + "번이야.");
            out.println("종료하려면 그냥 .을 입력해.");
            String str=in.readLine();
            while(!str.equals(".")) {
                out.println(str.toUpperCase());
                str = in.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("클라이언트 0번과 연결 종료");
    }
}
