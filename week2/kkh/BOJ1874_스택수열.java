package week2.minheebaek;

import java.util.*;

/** 2주차
 * 1.BOJ 1874
 * 2.스택
 * 3.스택에 넣고 빼는 문제라서 스택을 이용해야한다.
 * 4.O(N)*O(1)
 */
public class BOJ1874_스택수열 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int cnt = 1;
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int k = scan.nextInt();
            /**
             * 문제에서 같은 정수가 두번 이상 나오는 일은 없다고 했고 1~N까지 스택에 들어갔다 뺀다고 말했으므로
             * cnt를 이용해서 수를 관리했다. 일회성으로만 사용할 수 있게, 판단할 수 있게
             *
             * k가 나왔다는건 즉 스택 최상단에 k가 있었다는 뜻(스택 성질에의해)
             * cnt<=k이면 스택에 들어가지 않았다는 거니까 stack.push
             */
            while (cnt <= k) {
                stack.push(cnt++);
                sb.append("+\n");
            }

            if (stack.peek() == k) {//스택 최상단과 일치하면 빼기
                stack.pop();
                sb.append("-\n");
            }else{ //위에 있는 while문을 거쳐도 스택 최상단과 일치하지 않는다면(ex. cnt>k) 불가능한거니까 NO 출력하고 바로 종료
                System.out.println("NO");
                return;
            }

        }
        System.out.println(sb.toString());

    }
}