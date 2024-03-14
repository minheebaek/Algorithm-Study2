/** 2주차
 * 1.BOJ 2493
 * 2.스택
 * 3.바로 앞의 탑과 비교해서 탑의 높이가 크면 출력하고 낮으면 빼야하기 때문에 스택 사용
 * 4.O(N) 스택에 push, pop연산이 n번 이루어지기 때문에
 * 5. 생략
 */

/** 배운점
 * 조건에 따라 메모리제한, 시간초과 생각
 * 관리하는게 여러개일때 객체 사용
 * if-else 말고 효율적으로 짜는 법, 필수 로직은 if-else 넣지 말고 밖으로 빼기 (51줄)
 * 51줄 스택에 넣는 것을 while문에 넣었다가 stack.peek().height = t.height가 되어버려서 무한루프에 갇힌 코드를 짰다.
 * 필수로직과 if-else 코드를 잘 분리해서 작성해야겠다.
 */

import java.util.*;
import java.io.*;

class Top{//height와 num을 한꺼번에 관리하기 위해 객체 생성
    int height;
    int num;

    Top(int height, int num){
        this.height=height;
        this.num=num;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        //N이 500,000이기 때문에 Scanner 사용하면 시간초과나 메모리초과가 날 수 있다. 메모리 제한 128MB
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int top = Integer.parseInt(st.nextToken());
            Top t = new Top(top,i+1);
            while(!stack.empty()){//값이 크다면 break로 빠져나올거고 작다면 pop하면서 계속 비교해야하기 때문에 while문
                if(stack.peek().height>t.height){ //서로 다른 탑이라고 했으므로 같을 경우는 비교 X
                    sb.append(stack.peek().num+" ");
                    break;
                }
                stack.pop();
            }

            if(stack.empty()) //맨 처음이거나, 앞에 있는 탑 높이가 top 보다 적다면 계속 pop할 것이고 그럼 0을 출력할 수 있게 조건을 만듦
                sb.append(0+" ");

            stack.push(t); //비교가 다 끝난 후 맨마지막에 넣음
        }

        System.out.println(sb.toString());
    }
}