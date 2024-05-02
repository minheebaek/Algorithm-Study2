import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    /** 6주차
     * 1.BOJ 2630 색종이 만들기
     * 2. 재귀함수
     * 3. 1) check()함수로 해당 종이가 같은 숫자로 이루어져 있다면 +1, 그렇지 않다면 /2 하여 재귀 호출!!
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(4^k * n^2)
     */

    static int N, blue=0, white=0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(bfr.readLine());

        paper = new int[N][N];
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j <N; j++) {
                paper[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void solve(int r, int c , int size){
        if (check(r,c,size)) {
            if (paper[r][c] == 1) blue++;
            else white++;
        }else {
            int newsize = size/2;

            solve(r,c,newsize ); //1
            solve(r,c+newsize,newsize);//2
            solve(r+newsize,c,newsize); //3
            solve(r+newsize,c+newsize,newsize);//4

        }
    }

    static boolean check(int r, int c, int size ){
        int var = paper[r][c];

        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (var != paper[i][j]) return false;
            }
        }

        return true;
    }
}


