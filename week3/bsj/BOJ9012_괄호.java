import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class BOJ9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String input = br.readLine();

            // 문자열 각 자리의 값을 확인할 때는 char로
            Stack<Character> stack = new Stack<>();

            for (int j = 0; j < input.length(); j++) {
                if(input.charAt(j) == '('){
                    stack.push(input.charAt(j));
                }else{
                    // 비어있는지 먼저 본다.
                    if(stack.empty()){ // 비어있다면, 여는 괄호가 없다는 것
                        stack.push(input.charAt(j));// 닫는괄호를 스택에 저장하고, 반복을 종료한다.
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(stack.empty()) System.out.println("YES");
            else System.out.println("NO");
        }

    }
}
