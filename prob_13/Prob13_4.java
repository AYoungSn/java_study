package prob;

//세 사람이 산속에서 메아리치는 상황을 비동기화 - 동기화 프로그램으로 작성
//echo()메서드로 구성된 Echo 클래스 -> 0.1초마다 메시지를 세번 출력
//Thread의 자식 클래스 Echoer 클래스 -> String 타입 메세지, Echo 타입 객체 필드를 가짐
//세 사람이 메아리치는 테스트 프로그램을 작성
public class Prob13_4 {
    public static void main(String[] args) {
        Echo echo = new Echo();
        new Echoer("환영", echo).start();
        new Echoer("자바", echo).start();
        new Echoer("야호~~~~", echo).start();
    }
}

class Echoer extends Thread {
    String msg;
    Echo echo;

    public Echoer(String msg, Echo echo) {
        this.msg = msg;
        this.echo= echo;
    }

    public void run(){
        echo.echo(msg);
    }
}
class Echo {
    synchronized void echo(String m){
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(100);
                System.out.println(m);
            } catch (InterruptedException e) {

            }
        }
    }
}