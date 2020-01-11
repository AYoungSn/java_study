package prob;

import java.io.File;

public class Prob12_1 {
    public static void main(String[] args) {
        //filename 경로에 위치한 파일의 유무를 출력
        String filename = "D:\\temp\\file.txt";
        File f = new File(filename);
        if(f.exists())
            System.out.println("파일 존재");
        else
            System.out.println("파일 없음");
    }
}
