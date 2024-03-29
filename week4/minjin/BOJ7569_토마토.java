package week4.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569_토마토 {

    static int M, N, H; // 가로, 세로, 높이
    static int[][][] map;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, 0, -1, 0};
    static int[] dz = {0, 0, 0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }
        
        System.out.println(bfs());
    }

    static int bfs() {

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int nowZ = temp[0];
            int nowY = temp[1];
            int nowX = temp[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = nowZ + dz[i];
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                if(nextZ >= 0 && nextY >= 0 && nextX >= 0 &&
                        nextZ < H && nextY < N && nextX < M) {
                    if(map[nextZ][nextY][nextX] == 0) {
                        queue.offer(new int[] {nextZ, nextY, nextX});
                        map[nextZ][nextY][nextX] = map[nowZ][nowY][nowX] + 1;
                    }
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i <H; i++) {
            for (int j = 0; j <N; j++) {
                for (int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0) return -1;
                    maxValue = Math.max(maxValue, map[i][j][k]);
                }
            }
        }

        return maxValue == 1 ? 0 : maxValue - 1;
    }
}
