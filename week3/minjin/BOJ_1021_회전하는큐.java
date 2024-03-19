package minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] position = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        for (int i = 0; i < M; i++) {
            while(deque.peekFirst() != position[i]) {
                que.offer(deque.poll());
            }

            if (que.size() < deque.size()) {
                cnt += que.size();
            } else {
                cnt += deque.size();
            }

            deque.poll();
            while (!que.isEmpty()) {
                deque.addLast(que.poll());
            }
        }
        System.out.print(cnt);
    }
}
