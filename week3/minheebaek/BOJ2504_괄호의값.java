package week3.minheebaek;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.*;

public class BOJ2504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int value =1;
        int ans =0;

        for(int i=0; i<str.length(); i++){
            if (str.charAt(i) == '(') {
                stack.push(str.charAt(i));
                value *= 2;
            } else if (str.charAt(i) == '[') {
                stack.push(str.charAt(i));
                value *= 3;
            } else if (str.charAt(i) == ')') {
                if(stack.isEmpty()||stack.peek()!='('){
                    ans =0;
                    break;
                }else if(str.charAt(i-1)=='('){
                    ans+=value;
                }
                stack.pop();
                value/=2;
            } else if (str.charAt(i) == ']') {
                if(stack.isEmpty()||stack.peek()!='['){
                    ans =0;
                    break;
                }else if(str.charAt(i-1)=='['){
                    ans+=value;
                }
                stack.pop();
                value/=3;
            }


        }
        if(stack.isEmpty()){
            System.out.println(ans);
        }else{
            System.out.println(0);
        }

    }
}