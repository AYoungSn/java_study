package prob;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Prob12_4 {
    public static void main(String[] args) {
        //키보드로 입력한 이름의 자바 소스파일을 맨 앞에 행번호를 붙여서 출력하는 프로그램
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        try{
            Path p = new File(name).toPath();
            List<String> list = Files.readAllLines(new File(name).toPath());
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i+1 +" "+ list.get(i));
            }

        } catch (IOException e) {
            System.out.println("파일이 없음?");
        }
    }
}
