/** 2주차
 * 1.BOJ 2164
 * 2.큐
 * 3.맨 앞장 카드만 계산하고 있고 맨 앞에 있는 카드를 맨 뒤로 보낸다는 점에서 큐를 생각했다.
 * 4.O(N), 큐 연산 O(1)
 * 큐에 1~n까지 저장 O(N)
 * 큐에 카드 1개 남을때까지 반복 대충 O(N)
 * 총 O(2N), n 최댓값 대입: 2*500,000=1,000,000 <<2억(2초)
 * 5. 생략
 */

/** 아이디어
 * 카드가 1개 남을때까지 i가 홀수면 카드를 버리고 짝수면 카드를 빼서 맨 뒤로 넣는다
 * n=1일 경우 while문 돌지 않고 바로 빼서 출력함
 */

/** 배운점
 * 1.시간복잡도 계산
 * 2.문제에 없는 조건은 따로 만들지 말고 문제 본연의 의미를 파악하기
 * n=1일때 0을 출력하면 된다고 혼자 결정해버리고 코드를 짰는데 문제에서
 * 'N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성'하라고 했으니
 * 마지막 카드인 1을 출력하면 된다.
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(i);

        }
        int i = 1;
        while (queue.size() > 1) {
            if (i % 2 == 1) { //i가 홀수면
                queue.remove();
            }
            if (i % 2 == 0) { //i가 짝수면
                queue.add(queue.remove());
            }
            i++;
        }

        System.out.println(queue.remove());
    }
}