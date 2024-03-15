package week2.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1. BOJ 2493
 * 2. 스택
 * 3. 현재 탑 기준으로 가장 왼쪽에 있는 탑과 비교하기 때문
 * 4. 시간복잡도: O(N)
 */
public class BOJ_2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= n; i++) {
            int top = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않다면,
            while(!stack.isEmpty()) {
                if (stack.peek()[1] < top) {
                    // 자기보다 작으면 빼다가
                    stack.pop();
                } else {
                    // 큰 값을 찾으면 저장한다.
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
            }
            // 스택이 비어있다면 0 출력하고, 자기를 스택에 저장한다.
            if(stack.isEmpty()) {
                sb.append("0 ");
            }
            stack.push(new int[] {i, top}); // {탑 순번, 탑 높이}
        }
        System.out.println(sb);
    }
}
