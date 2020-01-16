package prob;

import java.util.Random;

public class Prob13_6 {
    public static void main(String[] args) {
        String s = "Time is money";
        Word2 w1 = new Word2(1, s);
        Word2 w2 = new Word2(2, s);
        w1.start();
        w2.start();
    }
}

class Word2 extends Thread {
    String s;
    int n;

    public Word2(int n, String s) {
        this.n = n;
        this.s = s;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            Thread.sleep(r.nextInt(5));
            print(n, s.substring(0, 4));
            print(n, s.substring(5, 7));
            print(n, s.substring(8));
        } catch (InterruptedException e) {

        }
    }
//    속담 출력하는 메서드를 동기화
    synchronized void print(int num, String ss) {
        System.out.println("속담" + num + " : " + ss);
    }
}