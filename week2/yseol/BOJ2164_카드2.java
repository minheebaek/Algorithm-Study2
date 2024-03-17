import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        /** 2주차
         * 1.BOJ 2164 카드2
         * 2. 큐 -> LinkedList활용 / Deque<Integer> q = new LinkList / ArrayDeque<>(); 가능
         * 3. 1) 큐를 사용해 맨 앞에 요소를 버리고, 그 다음 요소를 맨 뒤로 보냄

         * 4.  O(n) 시간 복잡도
         * -> 입력 크기에 선형적으로 비례하여 시간이 증가
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1){
            queue.poll();
            queue.offer(queue.poll());
        }
        System.out.println(queue.peek());
    }
}
