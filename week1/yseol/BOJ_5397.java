import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 5397
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            String password = scanner.next();
            Stack<Character> pre = new Stack<>();
            Stack<Character> post = new Stack<>();

            for (int j = 0; j < password.length(); j++) {
                if (password.charAt(j) == '<'){
                    if (!pre.isEmpty()) post.push(pre.pop());

                } else if (password.charAt(j) == '>') {
                    if (!post.isEmpty()) pre.push(post.pop());

                }else if (password.charAt(j) == '-'){
                    if (!pre.isEmpty()) pre.pop();

                }else {
                    pre.push(password.charAt(j));
                }
            }

            while (!post.isEmpty()){
                pre.push(post.pop());
            }

            StringBuilder answer = new StringBuilder();
            for (int j = 0; j < pre.size(); j++) {
                answer.append(pre.elementAt(j));
            }
            System.out.println(answer);

        }


    }
}