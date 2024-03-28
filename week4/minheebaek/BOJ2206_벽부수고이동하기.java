import java.util.*;
import java.io.*;

/** 4주차
 * 1.BOJ 2206
 * 2.BFS
 * 3.가중치 없는 최단거리 -> bfs // dfs 안됨
 */


/** 메모
 * 1.가중치 없는 최단거리 ->bfs
 * 2.모든 경우의 수를 구하고 3차원 다중배열
 * 3.너무 어려워서 한달뒤에 풀어보자
 */
class Point{
    int x;
    int y;
    int cnt;
    boolean destroyed;

    public Point(int x, int y, int cnt, boolean destroyed){
        this.x=x;
        this.y=y;
        this.cnt=cnt;
        this.destroyed=destroyed;
    }
}

public class Main {
    static int n,m;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dirx={-1,0,1,0};
    static int[] diry={0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited=new boolean[n][m][2];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j]=str.charAt(j)-'0';
            }

        }

        bfs(new Point(0,0,0,false));
    }

    static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        visited[point.x][point.y][0] = true;

        while (!queue.isEmpty()) {
            Point nowPoint = queue.poll();
            if (nowPoint.x == n - 1 && nowPoint.y == m - 1) {
                System.out.println(nowPoint.cnt + 1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = nowPoint.x + dirx[i];
                int ny = nowPoint.y + diry[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (arr[nx][ny] == 0) {//움직일 수 있는경우
                    //벽을 안부신 상태
                    if (!nowPoint.destroyed && !visited[nx][ny][0]) {//벽을 안부신상태로 방문하지 않음 && 그전 객체 안부심
                        visited[nx][ny][0] = true;
                        queue.add(new Point(nx, ny, nowPoint.cnt + 1, false));
                    }
                    //벽을 부신 상태
                    if (nowPoint.destroyed && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Point(nx, ny, nowPoint.cnt + 1, true));
                    }
                }
                if (arr[nx][ny] == 1) {
                    //벽을 부신 상태 ->할수있는게 없음 pass
                    //벽을 안부신 상태 -> 벽 부시기
                    if (!nowPoint.destroyed && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.add(new Point(nx, ny, nowPoint.cnt + 1, true));
                    }

                }
            }
        }
        System.out.println("-1");
    }

}

/**참고
 *  * https://www.acmicpc.net/board/view/27386
 *  * https://www.acmicpc.net/board/view/90597
 *  * https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-2206-%EB%B2%BD-%EB%B6%80%EC%88%98%EA%B3%A0-%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0-JAVA%EC%9E%90%EB%B0%94#%ED%92%80%EC%9D%B4
 *  * https://velog.io/@silver_star/%EB%B0%B1%EC%A4%80-12851-%EB%B2%BD-%EB%B6%80%EC%88%98%EA%B3%A0-%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0-BFS-ziycs5xt
 */