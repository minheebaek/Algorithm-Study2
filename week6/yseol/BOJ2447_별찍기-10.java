import java.io.*;

public class Main {

    /** 6주차
     * 1.BOJ 2447 별찍기
     * 2. 재귀함수
     * 3. 1-1) char[][] = ' '; 초기화하기
     *    1-2) 재귀함수호출
     *    2-1) if n= 1이면 -> 더이상 쪼개지는 크기가 아니면 "*" 표시
     *    2-2) 쪼개진다면 n /= 3
     *    2-3) (i,j) 반복문 돌면서 (1,1)이 아니면 재귀함수 호출 (x+i*n, y+i*n) -> 작은 사각형들의 시작위치
     *    3-1) 반복문 돌면서 chars[i][j] Stringbuffer에 붙이기
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(7^k)
     */

    static int N;
    static StringBuilder sb;

    static char[][] chars;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bfr.readLine());
        //***
        //* *
        //***
        chars = new char[N][N];
        sb = new StringBuilder();

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                chars[i][j] = ' ';
            }
        }
        recursive_fun(0,0,N);

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(chars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void recursive_fun(int x, int y,int n){
        if (n == 1){
            chars[x][y] = '*';
            return;
        }
        n /= 3;
        for (int i = 0; i <3 ; i++) { //최소 단위 3*3이 될때까지
            for (int j = 0; j < 3; j++) {
                if (!(i==1 && j==1)){ //공백 칸이 아닌경우
                    recursive_fun(x+i*n,y+j*n,n);
                }
            }
        }
    }
}