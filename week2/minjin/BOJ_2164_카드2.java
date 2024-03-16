package week2.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. BOJ 2164
 * 2. 스택
 * 3. 제일 위에 있는 요소를 버리거나 뒤로 옮기는 로직이 있어서 큐를 선택했다.
 * 4. 시간복잡도: O(N)
 */
public class BOJ_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        boolean flag = true;
        while (queue.size() != 1) {
            if (flag) {
                queue.remove();
                flag = false;
            } else {
                queue.add(queue.remove());
                flag = true;
            }
        }

        System.out.println(queue.poll());
    }
}
