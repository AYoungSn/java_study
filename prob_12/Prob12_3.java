package prob;

import java.io.*;

public class Prob12_3 {
    public static void main(String[] args) {
        //double 타입 숫자로 구성된 배열을 파일에 DataOutputStream으로 저장
        // DataInputStream으로 읽은 후 콘솔 뷰에 출력
        double[] darr = {3.5, 2.4, 2.8, 9.4, 4.6};
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("D:\\temp\\double.txt"));
            for (double d : darr) {
                dos.writeDouble(d);
            }
            DataInputStream dis = new DataInputStream(new FileInputStream("D:\\temp\\double.txt"));
            double d;
            while((d=dis.readDouble())>0) {
                System.out.print(d+" ");
            }
            dos.close();
            dis.close();
        } catch (IOException e) {

        }
    }
}
