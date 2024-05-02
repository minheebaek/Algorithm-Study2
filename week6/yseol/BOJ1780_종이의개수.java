import java.io.*;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class Main {

    /** 6주차
     * 1.BOJ 1780 종이의 개수
     * 2. 재귀함수
     * 3.
     * 1) check() -> return boolean
     * 1-1)) 반복문 int i = r, int j = c 부터 r+size까지,  c+size까지
     * 1-2) 처음 숫자와 같지 않다면 return false
     * 2) solve()
     * 2-1) if(check()) 이면 카운트한다
     * 2-2) 그렇지 않다면 /3를해서 9등분하여 재귀 호출
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(9^k * n^2)
     */
    static int N, zero=0, minus=0,one=0;
    static int[][] paper;

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());
        StringTokenizer st ;
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bfr.readLine());
            for (int j = 0; j <N ; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0,0,N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
    static void solve(int r,int c, int n){
        if (check(r,c,n)){
            if (paper[r][c] == 1) one++;
            else if (paper[r][c] == 0) zero++;
            else minus++;
        }else {
            int newsize = n/3;

            solve(r,c,newsize); //1사분면
            solve(r,c+newsize,newsize);//2사분면
            solve(r,c+newsize*2,newsize);//3사분면

            solve(r+newsize,c,newsize);//4사분면
            solve(r+newsize,c+newsize,newsize);//5사부면
            solve(r+newsize,c+newsize*2,newsize);//6사부면

            solve(r+newsize*2,c,newsize);//7사분면
            solve(r+newsize*2, c+newsize,newsize); //8사분면
            solve(r+newsize*2, c+newsize*2,newsize);//9사분면
        }
    }

    static boolean check(int r,int c, int size) {
        int var = paper[r][c];
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (var != paper[i][j]) return false;
            }
        }
        return true;
    }
}