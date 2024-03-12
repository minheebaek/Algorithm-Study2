package week2.minheebaek;

import java.util.*;

/**
 * 2주차
 * 1.BOJ 10773
 * 2.스택, 배열
 * 3.원소를 넣는데 0이면 가장 최근의 수를 지운다는 점에서 스택을 이용해야겠다고 생각
 * 4.O(K)
 */

public class BOJ10773_제로 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();

        int[] arr = new int[k]; //최대원소는 k를 못넘음
        int pos = 0;
        for (int i = 0; i < k; i++) {
            int num = scan.nextInt();

            if (num == 0) {
                pos--; //문제에서 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다고 해서 pos=0일 경우를 생각하지 않음
                arr[pos] = 0;
            } else {
                arr[pos] = num;
                pos++;
            }
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += arr[i];
        }

        System.out.println(ans);

    }
}