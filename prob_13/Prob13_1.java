package prob;

//1초 단위의 타이머를 Runnable 인터페이스를 상속한 하나의 클래스로 작성
public class Prob13_1 {
    public static void main(String[] args) {
        Thread t = new Thread(new Timer());
        t.start();

    }
}
class Timer implements Runnable{
    @Override
    public void run() {
        while(true) {
            try {
                System.out.println("1초 - try");
                Thread.sleep(1000);
                System.out.println("1초 - catch");
            } catch (InterruptedException e) {

            }
        }
    }
}