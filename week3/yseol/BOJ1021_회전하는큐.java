import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        /** 2주차
         * 1.BOJ 1021 회전하는 큐
         * 2. 큐 -> LinkedList활용 / Deque<Integer> q = new LinkList / ArrayDeque<>(); 가능
         * 3.  (다른 사람 풀이 참고함)
         * 뽑고자 하는 원소가 덱의 중앙에서 끝쪽에 가까운 쪽 방향으로
         * 이동(연산)하여 뽑고자 하는 원소가 첫 번째 위치에 갈 때까지 반복
         * 4. O(n)
         */

        Scanner in = new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<Integer>();

        int count = 0;

        int N = in.nextInt();
        int M = in.nextInt();

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];

        for(int i = 0; i < M; i++) {
            seq[i] = in.nextInt();
        }


        for(int i = 0; i < M; i++) {

            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if(deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            }
            else {
                half_idx = deque.size() / 2;
            }
            if(target_idx <= half_idx) {
                for(int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {

                for(int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }

            }
            deque.pollFirst();
        }

        System.out.println(count);
    }
}
