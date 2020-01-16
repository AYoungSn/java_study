package prob;

import java.util.Scanner;

public class Prob13_2 {
    public static void main(String[] args) {
//        작업 스레드는 메인 스레드로부터 인터럽트를 받을 때까지 1초마다 실행중임을 출력
//        키보드에서 입력된 값이 1이면 작업 스레드에 인터럽트를 건다
        Thread t=new Thread(()->{
            try {
                while (true) {
                    System.out.println("작업 실행 중...");
                    Thread.sleep(1000);
                }
            }catch (InterruptedException e) {
            }
            System.out.println("작업 완료.");
        });
        t.start();
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();

        if (i == 1) {
            t.interrupt();
        }
    }
}
