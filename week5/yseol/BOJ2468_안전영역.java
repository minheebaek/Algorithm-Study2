import java.io.*;
import java.util.*;

public class Main {

    /** 5주차
     * 1.BOJ 2468 안전 영역
     * 2. DFS
     * 3. 1) 중요 포인트**> 인접 노드를 접근해야함으로 dfs사용
     *    1-1) 높이마다 visit = new boolean[n][n], count = 0으로 초기화
     *    2) dfs() 함수
     *
     * 4. 시간복잡도
     *    DFS :  O(N*N*h)
     */

    static int n, count, min, max;
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static ArrayList<Integer> result = new ArrayList<>();
    static Set<Integer> set_height = new HashSet<>();
    static ArrayList<Integer> list_height ;

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = scanner.nextInt();
                map[i][j] = input;
                set_height.add(input);
            }
        }
        list_height = new ArrayList<>(set_height);
        Collections.sort(list_height);
        min = list_height.get(0);
        max = list_height.get(list_height.size() - 1);
        result.add(1);

        for (int k = 1; k <= max; k++) {
            visit = new boolean[n][n];
            count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] > k && !visit[i][j]) { // k보다 높은 지역을 방문
                        count++;
                        dfs(i, j,k);
                    }
                }
            }
            result.add(count);
        }
        System.out.println(Collections.max(result));
    }

    static void dfs(int x, int y, int h){
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >= n || ny>= n || nx<0 || ny<0) continue;

            if (!visit[nx][ny] && map[nx][ny] >h) dfs(nx,ny,h);
        }
    }

}


