import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

class Top{
    int index;
    int height;

    Top(int index, int height){
        this.index = index;
        this.height = height;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        /** 2주차
         * 1.BOJ 2493
         * 2. 스택
         * 3. 1) Scanner -> BufferedReader 사용
         *      : 한 번에 여러문자를 읽어 버퍼에 저장후 읽음-> 메모리 사용량 감소, 입출력 속도 향상
         *    2) 탑들을 배열이 아닌 StringTokenizer 사용 -> 메모리 사용량 감소
         *    3) 스택 활용
         *      : 1-1) 현재 탑의 hegiht와 스택 안에 있는 가장 가까운 탑의 height를 비교함
         *        1-2) 스택 안에 있는 가장 가까운 탑의 height 더 크다면 출력하고 현재 탑 push
         *        1-3) 그렇지 않다면 스택 안에 있는 가장 가까운 탑 제거
         *        1-4) 스택 비어있지 않으면 while 돔
         *        1-5) while 종료 후 스택이 비어있으면 push하고 0출력
         *
         * 4. 주어진 입력 N번의 루프 실행 -> 각 루프에서 스택 연산은 상수이므로 O(n) 시간 복잡도
         */

        /**
         *  테스트케이스 통과, 메모리 초과 (배열과 반복문으로 접근함)
         *
         *         Scanner scanner = new Scanner(System.in);
         *         int n = scanner.nextInt();
         *
         *         int[] heights = new int[n+1];
         *         int[] answer = new int[n+1];
         *
         *         answer[1] = 0; //항상 맨 처음 탑은 0
         *
         *         for (int i = 1; i < n+1; i++) {
         *             heights[i] = scanner.nextInt();
         *         }
         *
         *         for (int i = n; i >1 ; i--) {
         *             int current_height =  heights[i];
         *             int currentTower = i;
         *             int receiveTower = i-1;
         *             while(receiveTower>0){
         *
         *                 if (current_height <= heights[receiveTower]){
         *                     answer[currentTower] = receiveTower;
         *                     break;
         *                 }
         *                 else if (receiveTower==1){
         *                     answer[currentTower] = 0;
         *                     break;
         *                 }
         *                 receiveTower--;
         *             }
         *         }
         *
         *         for (int i = 1; i < n+1; i++) {
         *             System.out.printf("%d ",answer[i]);
         *         }
         * */

        /** 2. 스택 이용*/
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());
        String string = bfr.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(string," ");

        Stack<Top> towers = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(stringTokenizer.nextToken());


            //비어있지 않다면 비교
            while (!towers.isEmpty()) {

                if (height <= towers.peek().height) {
                    answer.append(towers.peek().index+1);
                    answer.append(" ");
                    towers.push(new Top(i, height));

                    break;
                } else {
                    towers.pop();
                }

            }
            if (towers.isEmpty()) {
                towers.push(new Top(i,height));
                answer.append("0 ");
            }

        }
        System.out.println(answer);
    }
}

