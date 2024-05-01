import java.io.*;
import java.util.*;

public class Main {

    /** 6주차
     * 1.BOJ 17478 재귀함수가 뭔가요
     * 2. 재귀함수
     * 3. public static int factorial(int n) {
     *         if (n == 0) { // 기본 케이스
     *             return 1;
     *         } else { // 재귀 케이스
     *             return n * factorial(n - 1);
     *         }
     *     }
     *     ** 중요 포인트 : recursion(0,""); "____" 밑줄 부분을 인자로 넘기는데, 처음에는 빈값을 넣는다
     *     1-1) 재귀함수 호출
     *     1-2) 종료 조건) if (n== count) 라면 끝나는 문장을 출력하고 return함
     *     1-3) 종료 조건이 아니라면 문장을 출력하고 재귀함수 호출
     recursion(count+1, under+"____") => 인자를 넘겨줄때 count +1 , under+"____" 하는게 중요!!
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(n)
     */

    static String first_sentence = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
    static String question = "\"재귀함수가 뭔가요?\"";
    static String content1 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String content2 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String content3 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\" ";
    static String answer1 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
    static String answer2 = "라고 답변하였지.";
    static  int n;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int count = 0;

        System.out.println(first_sentence);
        recursion(0,"");

    }
    static void recursion( int count, String under){
        if (n==count){
            System.out.println(under+question);
            System.out.println(under+answer1);
            System.out.println(under+answer2);
            return;
        }
        System.out.println(under+question);
        System.out.println(under+content1);
        System.out.println(under+content2);
        System.out.println(under+content3);
        recursion(count+1, under+"____");
        System.out.println(under+answer2);
    }

}