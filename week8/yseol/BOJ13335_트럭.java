import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    /** 8주차
     * 1.BOJ 13335 트럭
     * 2. 시뮬레이션
     * 3. 1) truck과 다리 지나가는 것을 queue로 만듦
     *    2) !list.isempty() 라면
     *    2-1) weight+list.peek() <= l  라면
     *    2-2) weight += list.peek()
     *    2-3) queue.offer(list.poll()) //해당 트럭이 다리에 건너게 queue에 삽입
     *    3-1) weight+list.peek() > l  라면
     *    3-2) queue.offer(0)
     * 4. 시간복잡도
     *    큐가 비어 있을 떄까지 loof 실행-> O(n)
     */

    static int n,w,l, time;
    static LinkedList<Integer> list = new LinkedList<>();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        w = Integer.parseInt(str[1]);
        l = Integer.parseInt(str[2]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.offer(Integer.parseInt(st.nextToken()));
        }
        time= 0; int weight= 0; //다리의 올라간 무게
        //n: 트럭개수, w: 다리길이, l;최대하중,

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        while (true){
            if (queue.isEmpty()) {
                System.out.println(time);
                break;
            }
            time++;
            weight -= queue.poll();

            if (!list.isEmpty()){
                if (weight+list.peek() <=l){
                    weight+= list.peek();
                    queue.offer(list.poll());
                }else {
                    queue.offer(0);
                }
            }
        }
    }
}


