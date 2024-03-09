package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int index = 0;
        while (!list.isEmpty()) {
            index = (index + K - 1) % list.size();
            sb.append(list.remove(index));
            if (!list.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");

        System.out.println(sb.toString());
    }
}
