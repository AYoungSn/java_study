package prob;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class Prob12_7 {
    public static void main(String[] args) throws IOException {
        //파일 이름을 나타내는 문자열과 특정 문자가 주어지면 파일 속에 포함된
        //특정 문자의 개수를 찾을 수 있는 CountLetter 클래스를 작성
        Scanner in = new Scanner(System.in);

        System.out.print("파일 이름을 입력하세요: ");
        String fileName = in.nextLine();
        System.out.print("세고자 하는 문자를 입력하세요 : ");
        char lookFor = in.nextLine().charAt(0);

        int count=new CountLetter(lookFor, fileName).count();
        System.out.format("%s 파일에 %c 문자가 %d개 %n", fileName, lookFor, count);
    }
}
class CountLetter{
    String filename;
    char find;

    public CountLetter(char find, String filename) {
        this.filename = filename;
        this.find = find;
    }
    int count()throws IOException{
        FileReader f = new FileReader(filename);
        int count = 0;
        List<String> list=Files.readAllLines(new File(filename).toPath());
        for (String s : list) {
            for(int i=0;i<s.length();i++)
                if(s.contains(String.valueOf(find)))
                    if (s.charAt(i)==find) {
                        count++;
                    }

        }
        return count;
    }
}