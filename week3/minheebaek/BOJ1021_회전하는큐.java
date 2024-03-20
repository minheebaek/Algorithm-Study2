import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> deque = new LinkedList<Integer>();

        for(int i=1; i<=n; i++){
            deque.add(i);
        }

        int count=0;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            int k = Integer.parseInt(st.nextToken());

            while(true) {
                if (deque.getFirst() == k) {
                    deque.removeFirst();
                    break;
                }

                int k_index = deque.indexOf(k);
                int mid = 0;
                if (deque.size() % 2 == 1) { //홀수
                    mid = deque.size() / 2;
                }
                if (deque.size() % 2 == 0) { //짝수
                    mid = (deque.size() / 2)-1;
                }

                if (mid - k_index >= 0) { //mid값보다 왼쪽에 있음 - 2번 실행
                    deque.addLast(deque.removeFirst());
                    count++;
                }

                if (mid - k_index < 0) { //mid값보다 오른쪽에 있음 - 3번 실행
                    deque.addFirst(deque.removeLast());
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}