package prob_14;

import javax.swing.*;

// 메시지 창을 사용해 두 정수를 덧셈하는 과정을 보여주는 프로그램
public class Prgm14_1 {
    public static void main(String[] args) {
        String inputValue1 = JOptionPane.showInputDialog("첫 번째 숫자는?");
        String inputValue2 = JOptionPane.showInputDialog("두 번째 숫자는?");
        JOptionPane.showMessageDialog(null,
                "합 = " + (Integer.parseInt(inputValue1) + Integer.parseInt(inputValue2)));
    }
}