package barkingDog.stack2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ10799_쇠막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    cnt += stack.size();
                } else {
                    stack.pop();
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
