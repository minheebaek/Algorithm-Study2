package week2.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. BOJ 10773
 * 2. 스택
 * 3. 가장 최근에 저장된 원소를 지우는 조건이 있어서 스택을 생각했다.
 * 4. 시간복잡도: O(N)
 */
public class BOJ_10773_제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int K = Integer.parseInt(br.readLine());

        // util 패키지에 있는 Stack 클래스 이용
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int number = Integer.parseInt(br.readLine());
            // 0이 나오면, 스택에 가장 최근에 저장된 수를 지운다.
            if (number == 0) {
                stack.pop();
            } else {
                // 아니면 스택에 수를 추가한다.
                stack.push(number);
            }
        }

        int sum = 0;
        for (int el : stack) {
            sum += el;
        }
        System.out.println(sum);
    }
}
