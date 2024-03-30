import java.util.*;
import java.io.*;

class Island {
    int x;
    int y;
    int cnt;

    public Island(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class BOJ2146_다리만들기 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirx = {1, 0, -1, 0};
    static int[] diry = {0, -1, 0, 1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) { //배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //1.섬끼리 같은 인덱스로 묶기
        //2.섬 최단 거리 구하기
        int islandIndex = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 1) { //방문 안하고 섬
                    dfs(i, j, islandIndex);
                    islandIndex++;
                }
            }
        }

        //최단거리 구하기
        ans = Integer.MAX_VALUE;
        visited = new boolean[n][n]; //배열 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) { //먼저 섬 찾기
                    bfs(i, j, map[i][j]);
                    //탐색 했으면 다른 섬 찾기 위해 배열 초기화
                    visited = new boolean[n][n];
                }
            }
        }

        System.out.println(ans);
    }

    static void bfs(int x, int y, int islandNum) {
        Queue<Island> queue = new LinkedList<>();
        queue.add(new Island(x, y, 0));
        while (!queue.isEmpty()) {
            Island now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dirx[i];
                int ny = now.y + diry[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == islandNum) continue;

                if (map[nx][ny] == 0) { //바다면
                    visited[nx][ny] = true;
                    queue.add(new Island(nx, ny, now.cnt + 1));
                } else { //다른 섬을 만날경우
                    ans = Math.min(ans, now.cnt);
                    return;
                }
            }
        }
    }

    static void dfs(int x, int y, int islandIndex) {
        visited[x][y] = true;
        map[x][y] = islandIndex;

        for (int i = 0; i < 4; i++) {
            int nx = x + dirx[i];
            int ny = y + diry[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (!visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, islandIndex);
            }
        }
    }
}