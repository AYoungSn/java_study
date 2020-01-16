package prob;

import java.util.Random;

//임의의 시간을 대기한 후 속담을 단어단위로 출력하는 2개의 스레드를 테스트하는 프로그램

public class Prob13_5 {
    public static void main(String[] args) {
        String s = "Time is money";
        Word w1 = new Word(1, s);
        Word w2 = new Word(2, s);
        w1.start();
        w2.start();

    }
}
class Word extends Thread{
    String s;
    int n;

    public Word(int n, String s) {
        this.n = n;
        this.s = s;
    }

//    run 메서드 내부에서 코드 영역을 동기화
    @Override
    public void run() {
        Random r = new Random();
        synchronized (s) {
            try {
                Thread.sleep(r.nextInt(5));
                print();
            } catch (InterruptedException e) {

            }
        }

    }
    void print() {
        System.out.println("속담" + n + " : " + s.substring(0, 4));
        System.out.println("속담" + n + " : " + s.substring(5, 7));
        System.out.println("속담" + n + " : " + s.substring(8));
    }
}