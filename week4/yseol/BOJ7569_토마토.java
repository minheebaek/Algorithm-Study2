import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int m,n,h;
    static int[][][] box;
    static boolean[][][] visit;
    static int[] dx={1,0,-1,0,0,0};
    static int[] dy={0,1,0,-1,0,0};
    static int[] dz={0,0,0,0,1,-1};

    static Queue<int[]> queue = new LinkedList<>();

    static int bfs(){

        while (!queue.isEmpty()){

            int nowx = queue.peek()[2];
            int nowy = queue.peek()[1];
            int nowz = queue.peek()[0];

            queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextz = nowz+dz[i];
                int nexty = nowy+dy[i];
                int nextx = nowx+dx[i];

                if (nextz >=0 && nextz<h && nexty >=0 && nexty<n
                        && nextx>=0 && nextx<m){
                    if (box[nextz][nexty][nextx] == 0){
                        queue.offer(new int[]{nextz,nexty,nextx});
                        box[nextz][nexty][nextx] = box[nowz][nowy][nowx]+1; // 토마토가 익을때마다 +1
                    }
                }
            }
        }

        int maxValue = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (box[i][j][k] == 0) return -1;
                    maxValue = Math.max(maxValue, box[i][j][k]);
                }
            }
        }

        if (maxValue == 1){
            return 0;
        }else {
            return maxValue -1 ; //가장 마지막 토마토가 익을 때는 가장 큰 일수 - 1임
        }
    }

    public static void main(String[] args) throws IOException {
        /** 4주차
         * 1.BOJ 7569 토마토
         * 2. BFS
         * 3. 1) 삼중 반복문으로 input를 받고, 1 -> 익은 토마토 라면 queue에 담기
         *    1-1) ** 주의 ** 3차원으로 m*n*h (가로 * 세로 * 높이) 을 배열에 담을 때
         *                  반대로 담는다 (h->n->m 순서대로!!!)
         *             2) bfs()를 호출한다.
         *    2-1) queue가 비어 있을 때 까지
         *    2-2) 다음 위치 토마토가 0이라면 queue.offer()
         *         다음위치 = 현재 위치 + 1 => 일수를 더함!!!!!
         *            3) 삼중 반복문으로 상자를 확인해서 출력한다
         *    3-1) 0이 존재하면 -1 출력 / 가장 큰 값을 구함
         *    3-2) 가장 큰 값이 1 이면 0 출력 => 이미 다 익었음
         *    3-3) 가장 큰 값이 1 이 아니면 (maxValue - 1)를 출력함
         *
         * 4. O(n*n*n) => 삼중 반복분
         *    N의 범위가 0~100이므로 시간 초과X
         *    BFS 인접리스트 구현 => O(V+E)
         *    V : 정점의 수 E: 간선의 수
         *    해당 코드에서 인접한 4개의 방향으로 탐색하므로 O(v) 상수시간 처리
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(bfr.readLine());
        m =  Integer.parseInt(tokenizer.nextToken());
        n =  Integer.parseInt(tokenizer.nextToken());
        h =  Integer.parseInt(tokenizer.nextToken());

        // 상하좌우위아래
        // 1 익은 토마토, 0 익지 않은 토마토, -1 토마토 X

        box = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                tokenizer = new StringTokenizer(bfr.readLine());
                for (int k = 0; k < m; k++) {
                    box[i][j][k] = Integer.parseInt(tokenizer.nextToken());
                    if (box[i][j][k] == 1) queue.offer(new int[]{i,j,k});
                }
            }
        }

        System.out.println(bfs());
    }
}
