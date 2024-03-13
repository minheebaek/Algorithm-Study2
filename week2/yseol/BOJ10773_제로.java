import java.util.Scanner;
import java.util.Stack;
public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        /** 2주차
         * 1.BOJ 10773
         * 2.스택
         * 3. " 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다."
         *     문장을 보고 스택 고려
         * 4. O(1) -> 삭입이나 삭제 시 맨 위에 데이터만을 처리하기에 시간복잡도 O(1)
         *      단) 특정 값을 찾을 때는 O(n) 시간 복잡도
         */


        for (int i = 0; i < k; i++) {
            int money = scanner.nextInt();
            if(money == 0 && !stack.isEmpty()){
                stack.pop();
            }else {
                stack.push(money);
            }
        }

        if (stack.isEmpty()){
            System.out.println(0);
        }else {
            int count = 0;
            for (int i = 0; i < stack.size(); i++) {
                count += stack.elementAt(i);
            }
            System.out.println(count);
        }

    }
}