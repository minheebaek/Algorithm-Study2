import java.util.Scanner;

/* 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
  예를 들어 A = 150, B = 266, C = 427 이라면
  A × B × C = 150 × 266 × 427 = 17037300 이 되고,
  계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다. */

public class BOJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        String value = String.valueOf((A * B * C)); // 세 int 값을 곱한 value를 String으로 바꾼다.
        sc.close();


        for(int i = 0; i <10; i++){
            int count = 0;
            for(int k = 0; k < value.length(); k++){
                if(value.charAt(k)-'0' == i){ // charAt 이 Character 형태라 타입을 맞춰준다.
                    count++;
                }
            }
            System.out.println(count);
        }


    }
}
