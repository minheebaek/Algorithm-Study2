package minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_5430_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            String cmd = br.readLine();
            char[] chars = cmd.toCharArray();

            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for (int i = 0; i < n; i++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean isReverse = true;

            boolean isError = false;
            for (char ch : chars) {
                if (ch == 'R') {
                    isReverse = !isReverse;
                } else if (ch == 'D') {
                    if (!deque.isEmpty()) {
                        if (isReverse) {
                            deque.pollFirst();
                        } else {
                            deque.pollLast();
                        }
                    } else {
                        isError = true;
                    }
                }
            }

            if (!isError) {
                ArrayList<Integer> arr = new ArrayList<>(deque);
                if (isReverse) {
                    sb.append(arr.toString().replace(" ", ""));
                } else {
                    Collections.reverse(arr);
                    sb.append(arr.toString().replace(" ", ""));
                }
            } else {
                sb.append("error");
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}
