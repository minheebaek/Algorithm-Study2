import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visit;
    static int[][] cabbage;
    static int m,n,k;

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while (!queue.isEmpty()){
            x = queue.peek()[0];
            y = queue.peek()[1];
            visit[x][y] = true;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int cx = x+dx[i];
                int cy = y+dy[i];

                if (cx>=0 && cy>=0 && cx<m &&cy<n){
                    if (!visit[cx][cy]&& cabbage[cx][cy] ==1){
                        queue.add(new int[]{cx, cy});
                        visit[cx][cy] =true;
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        /** 4주차
         * 1.BOJ 1012 유기농 배추
         * 2. BFS
         * 3. 1) 이중배열로 배추 위치를 받음, 방문 여부도 생성
         *      2) m,n 크기만큼 반복문을 돌면서 배추가 심어져 있고 방문하지 않았으면
         *      bfs함수 호출, count +1 시행
         *      3) bfs함수
         *        3-1) queue 생성
         *        3-2) 해당 위치에서 상하좌우를 돌면서 1이 있고 방문여부 확인
         *              만약 1이 있고 방문하지 않았다면 queue.add
         * 4. O(m*n) => 이중 반복분
         *    BFS 인접리스트 구현 => O(V+E)
         *    V : 정점의 수 E: 간선의 수
         *    해당 코드에서 인접한 4개의 방향으로 탐색하므로 O(v) 상수시간 처리
         */

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {

            m = scanner.nextInt(); //가로길이
            n = scanner.nextInt(); //세로길이
            k = scanner.nextInt(); //배추 위치 개수

            cabbage = new int[m][n];
            visit = new boolean[m][n];
            int count = 0;

            for (int j = 0; j < k; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                cabbage[x][y] = 1;
            }

            for (int x=0;x<m;x++){
                for (int y = 0; y < n; y++) {
                    if (cabbage[x][y]==1& !visit[x][y]){
                        bfs(x,y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }


    }
}
