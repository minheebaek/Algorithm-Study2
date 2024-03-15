package week2.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 1. BOJ 17298
 * 2. 스택
 * 3. 현재 값 기준으로 가장 최신값을 비교한다.
 * 4. 시간복잡도: O(N)
 */
public class BOJ_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N + 1];
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            // 현재 값이 스택의 맨 위 수보다 크다면 해당 값을 현재 값으로 바꾼다.
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                A[stack.pop()] = A[i];
            }
            // 현재 값의 인덱스 저장
            stack.push(i);
        }

        // 반복문 종료 후, 모든 요소들을 pop 하면서 -1로 저장한다.
        while(!stack.isEmpty()){
            A[stack.pop()] = -1;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(A[i]).append(" ");
        }
        System.out.println(sb);
    }
}
