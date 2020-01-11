package prob;

import java.io.DataOutputStream;
import java.io.IOException;

public class Prob12_5 {
    public static void main(String[] args) {
        try {
            DataOutputStream dos = new DataOutputStream(System.out);
            for (char i = '0'; i <= '9'; i++) {
                dos.write(i);
            }
            dos.flush();
            System.out.println();
            for(char c='A';c<='Z';c++){
                dos.write(c);
            }
            dos.flush();
        } catch (IOException e) {

        }
    }
}
