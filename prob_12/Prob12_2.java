package prob;

import java.io.*;

public class Prob12_2 {
    public static void main(String[] args) {
        //BufferedReader 스트림을 사용해 키보드에서 행 단위로 읽은 후 콘솔 뷰로 출력하는 프로그램
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(br.readLine());

            //위와 같은 역할
            InputStream is = new DataInputStream(System.in);
            char c = (char) is.read();
            System.out.println(c);

        } catch (IOException e) {
        }
    }
}
