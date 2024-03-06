package week1.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력값 받기
        int n = Integer.parseInt(br.readLine());

        // 수열 오름차순 정렬
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int x = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n - 1;
        int count = 0; // 쌍의 개수

        // 투포인터 구현
        while (start < end) {
            int sum = array[start] + array[end];
            if (sum == x) {
                count++;
                start++;
                end--;
            } else if (sum > x) {
                end--;
            } else {
                start++;
            }
        }

        System.out.println(count);
    }
}
