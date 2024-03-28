package week4.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10026_적록색약 {
    
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[][] map;
    static boolean[][] visit;
    static int I, x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            // 체스판의 한 변의 길이
            I = Integer.parseInt(br.readLine());

            map = new int[I][I];
            visit = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();
            sb.append(map[x2][y2]).append("\n");
        }
        System.out.print(sb);
    }

    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x1, y1});
        visit[x1][y1] = true;

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int x = temp[0];
            int y = temp[1];

            if(x == x2 && y == y2)
                break;

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                if (visit[nx][ny] || map[nx][ny] != 0) continue;
                map[nx][ny] = map[x][y] + 1;
                que.offer(new int[] {nx,ny});
            }
        }
    }
}
