package minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_3986_좋은단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                if (!stack.isEmpty() && stack.peek() == str.charAt(j)) {
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }

            if(stack.isEmpty()) {
                result++;
            }
        }
        System.out.println(result);
    }
}
