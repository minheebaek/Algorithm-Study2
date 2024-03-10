import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {

        // 13300
        /*
        첫 번째 줄에는 수학여행에 참가하는 학생 수를 나타내는 정수 N(1 ≤ N ≤ 1,000)과
        한 방에 배정할 수 있는 최대 인원 수 K(1 < K ≤ 1,000)가 공백으로 분리되어 주어진다.
        다음 N 개의 각 줄에는 학생의 성별 S와 학년 Y(1 ≤ Y ≤ 6)가 공백으로 분리되어 주어진다.
        성별 S는 0, 1중 하나로서 여학생인 경우에 0, 남학생인 경우에 1로 나타낸다.

        표준 출력으로 학생들을 모두 배정하기 위해 필요한 최소한의 방의 수를 출력한다.

        한 방에 배정할 수 있는 최대 인원 수 K가 주어졌을 때,
        조건에 맞게 모든 학생을 배정하기 위해 필요한 방의 최소 개수를 구하는 프로그램을 작성

        */
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); //학생 수
        k = scanner.nextInt(); //한 방에 배정할 수 있는 최대 인원 수
        // s 성별 0 여자 1 남자,y 학년

        int[][] arr = new int[2][7];

        for (int i = 0; i < n; i++) {
            int s = scanner.nextInt();
            int y = scanner.nextInt();
            arr[s][y]++;
        }
        //System.out.println(arr);

        int count = 0;
        /** 여자 방*/
        for (int i = 1; i < 7; i++) {
            int students = arr[0][i];
            while (students > 0){
                count++;
                students -= k;
            }
        }
        /** 남자 방*/
        for (int i = 1; i < 7; i++) {
            int students = arr[1][i];
            while (students > 0){
                count++;
                students -= k;
            }
        }
        System.out.println(count);
    }
}