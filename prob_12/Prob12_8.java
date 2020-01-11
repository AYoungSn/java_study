package prob;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class Prob12_8 {
    public static void main(String[] args) {
//        주어진 단어를 문자 하나씩 추측해서 맞추는 행맨 프로그램
//        6번을 초과해서 잘못된 추측을 하면 게임이 종료된다

        String find=new String();
        try {
            List<String> list = Files.readAllLines(new File("D:\\temp\\words.txt").toPath());
            find = list.get(((int) (Math.random() * 10))%10);
        } catch (IOException e) {
        }
        int expcount = 6;
        char[] ch = new char[find.length()];
        for (int i = 0; i < find.length(); i++) {
            ch[i]='-';
        }
        StringJoiner sj = new StringJoiner(", ");
        while (expcount >=0) {
            System.out.print("추측할 단어입니다 : ");
            System.out.println(String.valueOf(ch));
            System.out.printf("지금까지 추측한 내용입니다 : %s\n",sj);
            System.out.print("추측한 문자를 입력하세요 : ");
            String s= new Scanner(System.in).next();
            sj.add(s);
            if (find.contains(s)) {
                System.out.print("정확한 추측입니다");
                for(int i=0;i<ch.length;i++)
                    if(find.charAt(i)==s.charAt(0))
                        ch[i] = s.charAt(0);
                if(find.equals(String.valueOf(ch))){
                    System.out.println("\n정답");
                    break;
                }
                System.out.printf(" - %d번 더 추측할 수 있습니다\n", expcount);
            } else {
                expcount--;
                if(expcount<0){
                    System.out.println("6번 이상 잘못된 추측으로 게임이 종료되었습니다.");
                    break;
                }
                System.out.printf("잘못된 추측입니다 - %d번 더 추측할 수 있습니다\n", expcount);
            }
            System.out.println();
        }
    }
}
