import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /** 7주차
     * 1.BOJ 15655 N과M(6)
     * 2. 백트래킹
     * 3. 1) 중복 되지 않게 visit[]을 생성해 방문 여부를 확인함
     *    2) backtrcking(int idx,int depth) idx부터 반복문 돌도록 매개변수를 넘김
     * 4. 시간복잡도
     *   재귀 함수는 n에 따라 재귀함수 호출 -> O(N^M)
     */
    static int[] nums, arr;
    static boolean[] visit;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        visit = new boolean[N];
        arr = new int[M];
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        backtrcking(0,0);
        System.out.println(sb);
    }

    static void backtrcking(int idx,int depth){
        if (M == depth){
            for (int i : arr) sb.append(i).append(' ');
            sb.append("\n");
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visit[i]){
                visit[i] = true;
                arr[depth] = nums[i];
                backtrcking(i,depth+1);
                visit[i] = false;
            }
        }

    }
}