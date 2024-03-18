package barkingDog.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1021_회전하는큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> data = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            data.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] index = new int[m];
        for (int i = 0; i < m; i++) {
            index[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int num : index) {
            while (true) {
                if (data.getFirst() == num) {
                    data.pollFirst();
                    break;
                } else {
                    int dataIndex = 0;
                    for (int j = 0; j < data.size(); j++) {
                        if (data.toArray()[j].equals(num)) {
                            dataIndex = j;
                            break;
                        }
                    }
                    if (dataIndex <= data.size() / 2) {
                        for (int j = 0; j < dataIndex; j++) {
                            int first = data.pollFirst();
                            data.addLast(first);
                            cnt++;
                        }
                    } else {
                        for (int j = 0; j < data.size() - dataIndex; j++) {
                            int last = data.pollLast();
                            data.addFirst(last);
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
