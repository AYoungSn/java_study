package prob;

import java.io.*;

public class Prob12_6 {
    public static void main(String[] args) {
        //매 행마다 문자열의 첫 문자, 콜론, 문자열로 구성된 파일을 생성하는 프로그램
        String[] animals = {"ant", "bat", "cat", "dog"};
        File file = new File("D:\\temp\\prob_12_6.txt");
        try {
            if (!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter(file);
            for (String a : animals) {
                fw.write(a.charAt(0) + " : " + a+'\n');
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getCause());
        }
    }
}
