package prob;


import java.util.Random;
//메인 스레드 외에 2개의 작업 스레드로 구성
//메인 스레드는 작업 스레드가 연산한 2개의 결과 값을 합해서 출력
//작업 스레드는 0-9사이 임의의 정수를 누적, 스레드 이름과 임의의 정수를 출력
//작업 스레드의 생성자는 정수 매개변수가 있음 -> 임의의 정수 개수

public class Prob13_3 {
    public static void main(String[] args) {
        WThread t1 = new WThread(3);
        WThread t2 = new WThread(2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
            System.out.println("누적 값: "+(t1.sum+t2.sum));
        } catch (InterruptedException e) {

        }
    }
}
class WThread extends Thread{
    int sum=0;
    int count;
    public WThread(int count) {
        this.count=count;
    }
    public void run(){
        int a;
        for (int i = 0; i < count; i++) {
            a=new Random().nextInt(10);
            sum+=a;
            System.out.println(Thread.currentThread().getName()+": "+a);
        }
    }
}