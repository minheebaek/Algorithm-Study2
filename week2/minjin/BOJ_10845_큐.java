package week2.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. BOJ 10845
 * 2. 큐
 * 3. 문제에서 큐를 구현하라고 했다.
 * 4. 시간복잡도: O(N)
 */
public class BOJ_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int last = -1;
        for (int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");
            switch (order[0]) {
                case "push":
                    last = Integer.parseInt(order[1]);
                    queue.add(last);
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.remove()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peek()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : last).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
