package week3.minheebaek;
/** 3주차
 * 1.BOJ 10799
 * 2.스택
 * 3.() 짝 문제로 스택의 괄호를 이용하는 문제였다. 레이저가 나올때 그 순간의 스택의 길이를 구하면 되는 문제, 레이저와 구현 중에 생기는 () 짝을 구분하기
 * 위해서 str.charAt(i)의 i를 이용했다.
 * 4.O(N)
 */
/** 배운점 보완할점
 * 1.원래는 toCharArray를 이용하려고 했는데 바로 앞의 원소를 알아내야해서 str.charAt을 이용했다. 바로 다른 방법을 이용해서 푼 것이 잘했다고 생각
 * 2.레이저가 생길때 그 순간 스택의 길이가 정답이라는 것을 바킹독의 힌트를 보고 알았다. 이용해야하는 자료구조를 알았다면 자료구조의 특성을 다시 곰곰히
 * 생각해보면 좋을 것 같다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char token = str.charAt(i);
            if (i != 0) {//레이저
                if (str.charAt(i - 1) == '(' && token == ')') {
                    stack.pop();
                    ans += stack.size();
                }

                if (str.charAt(i - 1) != '(' && token == ')') {
                    if (stack.peek() == '(') {
                        stack.pop();
                        ans += 1;
                    }
                }
            }
            if (token == '(') {
                stack.push(token);
            }
        }
        System.out.println(ans);
    }
}