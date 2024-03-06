import java.io.*;
import java.util.*;

//5 12 7 10 9 1 2 3 11
public class BOJ_3273 {
    static int[] num; // 수열 저장하는 배열
    public static void main(String[] args) throws IOException {
        // 입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력값 저장 및 배열 초기화
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); // 수열 오름차순 정렬
        int x = Integer.parseInt(br.readLine());
        int result = sum(n, x); // 함수 실행
        bw.write(result + "\n"); // 경우의 개수 BufferedWriter에 저장
        bw.flush(); // 결과 출력
        bw.close();
        br.close();
    }
    // 경우의 수 구하는 함수
    public static int sum(int n, int x){
        int start = 0; // starter 포인터
        int end = n-1; // end 포인터
        int count = 0; // count
        while(start<end){
            int temp = num[start] + num[end]; // 두 요소를 더한 값
            if(temp > x)	//규칙 1.
                end--;
            else {		//규칙 2, 3
                if(temp == x)		//규칙 2에 Count + 1
                    count++;
                start++;
            }
        }
        return count;
    }
}
