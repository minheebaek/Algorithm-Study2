package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int cnt = 0;

        while (left < right) {
            int tmp = arr[left] + arr[right];
            if (tmp == x) {
                cnt += 1;
                left += 1;
            } else if (tmp < x) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        System.out.println(cnt);
    }
}
