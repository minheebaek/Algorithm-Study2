import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        /** 2주차
         * 1.BOJ 18258 큐2
         * 2. 큐 -> LinkedList활용 / Deque<Integer> q = new LinkList / ArrayDeque<>(); 가능
         * 3. 1) 풀이 시 주의 사항
         *       Scanner, println 사용시 시간 초과!
         *       BufferedReader, StringBuffer 사용

         * 4.  O(n) 시간 복잡도
         */

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(bfr.readLine());
        StringTokenizer st;

        StringBuffer answer = new StringBuffer();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bfr.readLine());
            String command = st.nextToken();
            if (command.equals("push")){
                int number = Integer.parseInt(st.nextToken());
                queue.offer(number);
            }else if (command.equals("pop")){
                if (queue.isEmpty()){
                    answer.append(-1).append("\n");
                }else {
                    answer.append(queue.poll()).append("\n");
                }
            }else if (command.equals("size")){
                answer.append(queue.size()).append("\n");

            }else if (command.equals("empty")){
                if (queue.isEmpty()){
                    answer.append(1).append("\n");
                }else {
                    answer.append(0).append("\n");
                }
            }else if (command.equals("front")){
                if (queue.isEmpty()){
                    answer.append(-1).append("\n");
                }else {
                    answer.append(queue.peek()).append("\n");

                }

            }else if (command.equals("back")){
                if (queue.isEmpty()){
                    answer.append(-1).append("\n");
                }else {
                    answer.append(queue.peekLast()).append("\n");
                }
            }
        }

        System.out.println(answer);


    }
}
