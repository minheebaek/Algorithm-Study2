package minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    stack.pop();
                    result += stack.size();
                } else if (str.charAt(i - 1) != '(') {
                    result += 1;
                    stack.pop();
                }
            }
        }
        System.out.print(result);
    }
}
