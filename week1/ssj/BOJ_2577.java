package array;

import java.util.Scanner;

public class BOJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int value = (sc.nextInt() * sc.nextInt() * sc.nextInt());
        String str = Integer.toString(value);
        sc.close();

        // 0~9까지 숫자 개수 저장
        int[] cnt = new int[10];

        for (int j = 0; j < str.length(); j++) {
            // 문자 -> 정수
            cnt[str.charAt(j) - '0']++;
        }

        for (int i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i]);
        }
    }
}