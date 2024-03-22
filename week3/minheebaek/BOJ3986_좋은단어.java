package week3.minheebaek;

import java.util.*;
/** 3주차
 * 1.BOJ 3986
 * 2.스택
 * 3.원소 앞부분만 비교 후 삭제하는 것을 보아 스택을 활용했다
 * 4.O(N) O(모든 단어 길이의 합)
 */

/** 보완할 점
 * 1.이중 if문 하지 말고 별다른 수식 없으면 하나로 합치기
 * 2.예시 직접 활용하면서 생각하자
 */
public class BOJ3986_좋은단어 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int ans =0;
        for(int i=0; i<N; i++) {
            String str = scan.next();
            Stack<Character> stack = new Stack<>();
            for (char token : str.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == token) {
                    stack.pop();

                } else {
                    stack.add(token);
                }
            }
            if (stack.isEmpty()) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}