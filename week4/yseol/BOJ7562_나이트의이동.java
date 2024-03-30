import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int tc;
    static int l;
    static int[][] board;
    static boolean[][] visit;

    static int[] dx = {-1,-2,-2,-1,1,2,2,1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static int x1,x2,y1,y2;
    static Queue<int[]> queue;

    static void bfs(){
        queue = new LinkedList<>();
        queue.add(new int[]{x1,y1});
        visit[x1][y1] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];

            for (int i = 0; i < 8; i++) {
                int nextx = now[0]+dx[i];
                int nexty = now[1]+dy[i];

                if (nextx<0 || nextx>=l || nexty<0 || nexty>=l) continue;

                if (!visit[nextx][nexty]){
                    queue.offer(new int[]{nextx,nexty});
                    visit[nextx][nexty] = true;
                    board[nextx][nexty] = board[nx][ny] +1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        /** 4주차
         * 1.BOJ 7562 나이트의 이동
         * 2. BFS
         * 3. 1) BFS로 최단 경로 구하기
         *    1-1) 입력을 받고 bfs()함수 호출
         *    2-1) while문 안에 queue가 비어 있을 때 까지 무한 반복
         *    2-2) ** 방문하지 않았다면 board(체스판) 좌표에 +1를 함
         *    3) 도달해야할 위치 좌표를 출력함
         * 4. BFS 인접리스트 구현 => O(V+E)
         *    V : 정점의 수 E: 간선의 수
         *    V : 보드 한 칸 => l*l , E : 간선의 수 => 8
         *    O(l*l)
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        tc = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < tc; i++) {
            l = Integer.parseInt(bfr.readLine());

            board = new int[l][l];
            visit = new boolean[l][l];

            st = new StringTokenizer(bfr.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bfr.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(board[x2][y2]);
        }

    }
}
