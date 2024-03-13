import java.io.*;
import java.util.*;

// 2493 스택 탑

/** 이중 루프 사용하는 대신 스택을 활용(루프 1회)
 * 배열을 거꾸로 탐색하면서 스택에 탑의 높이와 인덱스를 저장
 *
 */
public class BOJ2493_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] < heights[i]) {
                stack.pop();
            }
            answer[i] = stack.isEmpty() ? 0 : stack.peek() + 1; // 비어있는 경우 0, false인 경우 현재 탑의 인덱스 반환
            stack.push(i);// 배열을 거꾸로 탐색하면서 스택에 탑의 높이와 인덱스를 저장
            // 스택에 저장된 값들은 탑의 높이가 감소하는 순서대로 저장
        }

        for (int j = 0; j < n; j++) {
            sb.append(answer[j]);
            if (j != n - 1) {
                sb.append(" ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
    /* 시간초과된 문제
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] answer = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0){
                answer[i] = 0;
                continue;
            }else{
                for(int k = i-1; k >= 0; k--){
                    if(Integer.parseInt(s[i]) < Integer.parseInt(s[k])){
                        answer[i] = k+1;
                        break;
                    }
                }
            }

        }
        for(int j = 0; j< n; j++){
            if(j == n-1){
                sb.append(answer[j]);
            }else{
                sb.append(answer[j] + " ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }*/
