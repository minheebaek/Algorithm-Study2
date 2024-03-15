/** 2주차
 * 1.BOJ 18258
 * 2.큐
 * 3.큐 메서드를 만들어 큐 구현하기때문에 큐 문제
 * 4.O(N)
 */

/**배운점
 * 큐 성질을 이용해서 back함수 구현한 것
 * String 단어 판멸을 위해 switch case 사용한 것
 * N이 엄청 클경우 BufferedReader & StringBuilder 사용할 것
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //N이 2,000,000까지 가능하니까 Scanner 사용 X, System.out.print 사용 X, 시간초과 남
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            switch (str) { //switch-case문으로 단어를 받아서 이에 맞게 작업 수행
                case "push":
                    num = Integer.parseInt(st.nextToken()); //가장 최근 값을 num에 저장하고 이후 back이 실행될때 num을 이용
                    q.add(num);
                    break;
                case "pop":
                    if (!q.isEmpty()) {
                        sb.append(q.remove()+"\n");
                        break;
                    } else {
                        sb.append("-1\n");
                        break;
                    }
                case "size":
                    sb.append(q.size()+"\n");
                    break;
                case "empty":
                    if (q.isEmpty()) {
                        sb.append("1\n");
                        break;
                    } else {
                        sb.append("0\n");
                        break;
                    }

                case "front":
                    if (q.isEmpty()) {
                        sb.append("-1\n");
                        break;
                    } else {
                        sb.append(q.peek()+"\n");
                        break;
                    }

                case "back":
                    if(q.isEmpty()){
                        sb.append("-1\n");
                        break;
                    }else{ //back 함수를 지원하는 queue 메소드는 따로 없어서, 맨 뒤에 있는 원소는 가장 최근에 받은 원소일 것이기 때문에 27줄
                        //처럼 push 값을 받으면서 맨 마지막 원소를 알아내면 된다.
                        sb.append(num+"\n");
                    }
            }
        }
        System.out.println(sb.toString());
    }
}