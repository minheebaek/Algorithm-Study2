import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    /** 6주차
     * 1.BOJ 1992 쿼드트리
     * 2. 재귀함수
     * 3. 1) check() -> 사분면 숫자가 같으면 return true, 그렇지 않으면 return false
     *    2) 사분면 숫자가 같지 않으면 /2를 하고 '('를 붙인다.
     *    3) 사분면을 나눠 재귀함수를 호출하고 다 호출하면 ')' 닫는다
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(4^k * n^2)
     */

    static int N, blue=0, white=0;
    static int[][] video;

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());

        video = new int[N][N];
        for (int i = 0; i <N ; i++) {
            String str = bfr.readLine();
            for (int j = 0; j <N; j++) {
                video[i][j] =str.charAt(j)-'0';
            }
        }
        sb = new StringBuilder();
        solve(0,0,N);
        System.out.println(sb);
    }

    static void solve(int r, int c, int size){

        if (check(r,c,size)){
            if (video[r][c]== 1) sb.append(1);
            else sb.append(0);
        }else { // 같지 않다면 /2를 한다
            int newsize = size/2;
            sb.append('(');
            solve(r,c,newsize);//1
            solve(r,c+newsize,newsize);//2
            solve(r+newsize,c,newsize);//3
            solve(r+newsize,c+newsize,newsize);//4
            sb.append(')');
        }
    }

    static boolean check(int r, int c, int size){
        int var = video[r][c];
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (var != video[i][j]) return false;
            }
        }
        return true;
    }
}