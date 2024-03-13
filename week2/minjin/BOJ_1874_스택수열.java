package week2.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 1. BOJ 1874
 * 2. 스택
 * 3. 스택에 넣고 뺀다는 게 문제 조건에 있다.
 * 4. 시간복잡도: O(N)
 */
public class BOJ_1874_스택수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        
        StringBuilder sb = new StringBuilder();
        
        int highestNum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 입력받은 값이 스택의 마지막 원소보다 작을 경우, push 연산
            while(num > highestNum) {
                stack.push(++highestNum);
                sb.append("+\n");
            }
            
            // 입력 받은 값이 스택의 마지막 원소와 같은 경우, pop 연산
            if (stack.pop() == num) {
                sb.append("-\n");
            } else {
                // 수열이 만들어 질 수 없는 경우
                sb = new StringBuilder();
                System.out.println("NO");
                break;
            }
        }

        System.out.println(sb);
    }
}
