import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static char[][] picture;
    static boolean[][] visit;
    static int[] dx={0,1,0,-1};
    static int[] dy= {1,0,-1,0};

    static void bfs(int x,int y, char color){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y] = true;

        while (!queue.isEmpty()){
            int curx = queue.peek()[0];
            int cury = queue.peek()[1];
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextx = curx+dx[i];
                int nexty = cury+dy[i];

                if (nextx>=0&& nextx<n&& nexty>=0 && nexty<n){
                    if (!visit[nextx][nexty] && picture[nextx][nexty] == color){
                        queue.offer(new int[]{nextx,nexty});
                        visit[nextx][nexty]= true;
                    }
                }
            }


        }

    }

    public static void main(String[] args) throws IOException {
        /** 4주차
         * 1.BOJ 10026 적록색약
         * 2. BFS
         * 3. 1) 두개의 케이스로 나눠서 처리함 1. 적록색약인 경우 2. 적록색약인 아닌 경우
         *      2. 적록색약이 아닌 경우
         *      2-1) 먼저 이중반복문으로 G인 경우 R로 변환한뒤
         *      2-2) 다시 이중반복문으로 bfs함수 호출 함
         * 4. O(n*n) => 이중 반복분
         *    N의 범위가 0~100이므로 시간 초과X
         *    BFS 인접리스트 구현 => O(V+E)
         *    V : 정점의 수 E: 간선의 수
         *    해당 코드에서 인접한 4개의 방향으로 탐색하므로 O(v) 상수시간 처리
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt( bfr.readLine());
        picture = new char[n][n];
        for (int i = 0; i < n; i++) {
            picture[i] = bfr.readLine().toCharArray();
        }
        int answer1 = 0;
        int answer2 = 0;

        /**색맹 아닌경우*/
        visit = new boolean[n][n]; //초기화 false
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visit[x][y]){
                    bfs(x,y,picture[x][y]);
                    answer1++;
                }
            }
        }

        /**색맹인 경우*/
        visit = new boolean[n][n]; //초기화 false
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (picture[x][y] == 'G'){
                    picture[x][y] = 'R';
                }
            }
        }
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (!visit[x][y]){
                    bfs(x,y,picture[x][y]);
                    answer2++;
                }
            }
        }


        System.out.println(answer1+" "+answer2);



    }
}
