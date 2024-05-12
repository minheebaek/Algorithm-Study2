import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /** 7주차
     * 1.BOJ 15650 N과M(2)
     * 2. 백트래킹
     * 3. 1) nums= new int[M]; M크기의 배열 생성
     *    2) bactracking(1,0); idx -> 시작 숫자, depth ->배열 크기
     *    3) backtracking() 호출
     *    3-1) 종료 조건 : M== depth이면 배열 요소 출력
     *    3-2) 종료 조건X 라면 for문 호출 i= idx, i<=N까지
     *    3-3) 배열 nums[depth] = i
     *    3-4) 재귀 호출 -> backtracking(i+1, depth+1)
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(N^M)
     */
    static int[] nums;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
//        1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//        고른 수열은 오름차순이어야 한다.
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        nums= new int[M];

        bactracking(1,0);
    }
    static void bactracking(int idx,int depth){
        if (M == depth){
            for (int num : nums){
                System.out.print(num+" ");
            }
            System.out.println();
            return;
        }
        for (int i = idx; i <=N ; i++) {
            nums[depth] = i;
            bactracking(i+1,depth+1);
        }

    }
}