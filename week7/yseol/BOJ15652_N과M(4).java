import java.io.*;

public class Main {

    /** 7주차
     * 1.BOJ 15652 N과M(4)
     * 2. 백트래킹
     * 3. 1) BOJ 15651 N과M(3) 과의 차이점!!!!!!
     *    1-1) 재귀함수 for i = num에서 시작!!
     *    1-2) 중복 허용 -> 재귀함수 호출시 (num, depth+1) -> depth+1 해서 호출한다!
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

        backtracking(1,0);
        System.out.println(sb);
    }

    static void backtracking(int num, int depth){
        if (depth == M){
            for (int i : nums){
                sb.append(i).append(' ');
            }
            sb.append("\n");
            return;
        }
        for (int i = num; i <= N ; i++) {
            nums[depth] = i;
            backtracking(i,depth+1);
        }
    }

}


