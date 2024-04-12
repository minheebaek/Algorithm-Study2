import java.io.*;
import java.util.*;

public class Main {
    static int m,n,k,count;
    static int x1,y1,x2,y2;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] board;
    static ArrayList<Integer> result = new ArrayList<>();

    static void dfs(int x, int y){
        count++;
        board[y][x] = 1; //방문 처리

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx<0 || ny <0 || nx>= n || ny >= m) continue;
            if (board[ny][nx] == 0)  dfs(nx,ny);
        }
    }

    public static void main(String[] args) throws IOException {
        /** 5주차
         * 1.BOJ 2583 영역 구하기
         * 2. DFS
         * 3. 1) 중요 포인트**> x1,y1/x2,y2를 입력받고 이중 반복문을 돌려 사각형 부분을 1로 만든다!
         *    2) 반복문 돌려 board가 0이면 dfs()호출! count = 0 초기화 해야함
         * 4. 시간복잡도
         *    DFS :  인접한 정점을 한 번씩 방문하므로 인접한 정점을 탐색하는데 O(1) 소요,
         *    모든 정점을 방문해야 하므로 최악의 경우 O(m * n)
         * 5. 공간복잡도
         *    DFS 호출 시 스택 사용-> DFS 호출이 재귀적
         *    최악의 경우 스택에는 O(m * n)만큼의 공간이 필요
         */
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bfr.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(bfr.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for (int y = y1; y < y2 ; y++) {
                for (int x = x1; x <x2 ; x++) {
                    board[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0){
                    count = 0;
                    dfs(j,i);
                    result.add(count);
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for (Integer i : result) System.out.printf("%d ",i);

    }
}