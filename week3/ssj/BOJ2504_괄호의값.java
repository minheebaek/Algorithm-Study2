package barkingDog.stack2;

import java.util.Scanner;
import java.util.Stack;

public class BOJ2504_괄호의값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tmp = 1;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() == '[') {
                    answer = 0;
                    break;
                }
                if (i > 0 && input.charAt(i - 1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
            } else {
                if (stack.isEmpty() || stack.peek() == '(') {
                    answer = 0;
                    break;
                }
                if (i > 0 && input.charAt(i - 1) == '[') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }

        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);
    }
}