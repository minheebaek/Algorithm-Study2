package week1.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = Integer.toString(A * B * C);

        int[] count = new int[10];
        for (int i = 0; i < result.length(); i++) {
            count[result.charAt(i) - 48]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}
