import java.util.Scanner;
import java.util.Stack;

public class BOJ2504_괄호의값 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if(cur == '(') {
                stack.push(cur);
                value *= 2; // tmp 변수에 2를 곱함
                continue;
            }

            if(cur == '[') {
                stack.push(cur);
                value *= 3; // [ 이면 3을 곱함 
                continue;
            }

            if(cur == ')') {
                if(stack.isEmpty() || stack.peek() != '(') { // 스택이 비어있거나, (가 아니면 
                    result = 0; // 잘못된 입력으로 종료
                    break;
                }

                if(input.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
                continue;
            }

            if(cur == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }

                if(input.charAt(i-1) == '[') { // 이전문자가 [이면
                    result += value; // tmp를 더해준다.
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);

    }
}