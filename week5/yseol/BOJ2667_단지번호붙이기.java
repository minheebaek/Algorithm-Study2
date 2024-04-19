
import java.io.*;
import java.util.*;

public class Main {

    /** 5주차
     * 1.BOJ 2667 단지번호 붙이기
     * 2. DFS
     * 3. 1) 중요 포인트**> 입력 받기!
     *                  String[] str = bfr.readLine().split("");
     *    2) map[i][j] == 1이면 dfs() 호출, dfs() 종료되면 인접한 집 count 완료한 것이므로 result++
     *    3) dfs() 함수
     *    3-1) map[i][j] = 0 -> 방문처리
     *    3-2) 반복문 돌면서 상하좌우 인접한 곳에 1이 있으면 dfs()호출
     * 4. 시간복잡도
     *    DFS :  인접한 정점을 한 번씩 방문하므로 인접한 정점을 탐색하는데 O(1) 소요,
     *    모든 정점을 방문해야 하므로 최악의 경우 O(n * n)
     * 5. 공간복잡도
     *    DFS 호출 시 스택 사용-> DFS 호출이 재귀적
     *    최악의 경우 스택에는 O(n * n)만큼의 공간이 필요
     */

    static int n, count, result;
    static int[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bfr.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = bfr.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1){
                    count = 0;
                    dfs(i,j);
                    result++;
                    answer.add(count);
                }
            }
        }
        Collections.sort(answer);
        System.out.println(result);
        for (int i : answer) System.out.println(i);

    }

    static void dfs(int x, int y){
        map[x][y] = 0; //방문처리
        count++; //개수 더하기

        //주변에 집이 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx <0 || ny<0 || nx>=n || ny>= n) continue;

            if (map[nx][ny] == 1){
                dfs(nx,ny);
            }
        }
    }
}