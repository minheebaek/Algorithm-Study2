import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ10773_제로 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.offer(sc.nextInt()); // 한 줄씩 숫자 입력
        }
        Stack<Integer> stack = new Stack<>(); // 0으로 최근 값이 지워진 숫자들 저장

        while(!queue.isEmpty()){
            if(queue.peek() != 0 ){
                stack.push(queue.poll()); // 0이 아니면 queue에서 맨 앞 요소 제거
            }else{ // peek했을 때 0이면
                queue.poll(); // 0을 빼고
                stack.pop(); // stack에 담겨있던 0도 빼준다.
            }
        }
        // 스택 내의 요소를 순회하면서 더하기
        int sum = 0;
        while (!stack.isEmpty()) {
            int element = stack.pop();
            sum += element;
        }
        System.out.println(sum);

    }
}
