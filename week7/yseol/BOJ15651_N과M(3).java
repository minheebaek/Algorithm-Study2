import java.io.*;

public class Main {

    /** 7주차
     * 1.BOJ 15650 N과M(2)
     * 2. 백트래킹
     * 3. 1) nums= new int[M]; M크기의 배열 생성
     *    2) backtracking() 호출
     *    2-1) for문 -> int i = 1, int<=N까지 : 중복 허용 되므로
     *
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(N^M)
     */
    static int[] nums;
    static int N,M;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        nums = new int[M];

        backTracking(0);
        System.out.println(sb);
    }

    static void backTracking(int depth){
        if(depth == M){
            for (int i : nums) {
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <=N ; i++) {
            nums[depth] = i;
            backTracking(depth+1);
        }
    }
}