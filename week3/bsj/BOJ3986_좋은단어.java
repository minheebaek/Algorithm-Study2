import java.util.Scanner;
import java.util.Stack;

/* ABAB가 있으면, 내부 for문의 if문의 false가 되므로 우선 stack에 push,
 * 그 다음부터 stack의 peek과, 현재 문자의 값과 같은지를 비교하고 같으면, 스택에서 pop
 * 내부 for문 마치고 스택의 크기가 0(짝을 이룸)이면 좋은 단어, 아닐 경우 안 좋은 단어가 된다.
 */
public class BOJ3986_좋은단어 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Character> stack = new Stack<>();
        int goodWords = 0;

        for (int i = 0; i < N; i++) {
            String word = sc.next();
            for (int j = 0; j < word.length(); j++) {
                if(!stack.isEmpty() && word.charAt(j) == stack.peek()) // 현재 문자의 값과 stack의 top 값이 같을경우 => 짝을이루어 제거
                    stack.pop();	// 현재 문자의 값과 stack의 top 값이 같을경우 => 짝을이루어 제거
                else
                    stack.push(word.charAt(j));	// 두 문자가 다를경우 => 스택에 쌓기.
            }

            if(stack.size() == 0){
                goodWords++;
            }
            stack.clear(); // 스택 초기화
        }
        System.out.println(goodWords);
        sc.close();
    }
}
