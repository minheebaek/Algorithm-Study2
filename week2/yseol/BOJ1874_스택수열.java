import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static void main(String[] args)  {
        /** 2주차
         * 1.BOJ 1874
         * 2.스택
         * 3. 스택으로 입력값이 그 전 입력된 가장 큰값과 비교하여 pop/push 연산 수행
         * 4. 주어진 입력 N번의 루프 실행 -> 각 루프에서 스택 연산은 상수이므로 O(n) 시간 복잡도
         */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> answerList = new ArrayList<>(); // 정답 출력을 위해

        int currentNumber = 1;
        int maxValue = 1;

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();

            while (true){

                if (currentNumber > number){ // 입력값보다 currentNumber가 크다면 pop() 하고 break

                    if (maxValue <= number){ // 입력값 중 가장 큰값 유지
                        maxValue = number;
                    }
                    if (stack.peek() == number){
                        stack.pop();
                        currentNumber = maxValue; //currentNumber 입력된 값중 가장 큰값 유지
                        currentNumber++;
                        answerList.add("-");
                    }else {
                        answerList.add("NO");
                    }
                    break;
                }
                stack.add(currentNumber); // 입력값보다 curreuntNumber가 작다면 push()
                answerList.add("+");
                currentNumber++;

            }
        }

        /** 정답 출력*/
        if (answerList.contains("NO")){
            System.out.println("NO");
        }else {
            for (Object o : answerList){
                System.out.println(o);
            }
        }
    }
}
