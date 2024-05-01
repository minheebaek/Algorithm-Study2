
import java.io.*;
import java.util.*;

public class Main {

    /** 5주차
     * 1.BOJ 6593 상범 빌딩
     * 2. BFS - 최단 경로
     * 3. 중요 포인트**> building[h][y][x] = str.charAt(x); 입력 받기
     *    1) 삼중 for문으로 입력을 받는다. String str = bfr.readLine() 열을 입력 받고 str.chatAt()로 char로 변환함
     *    1-1) 'S' 시작 지점을 저장함
     *    2) 입력을 다 받으면 bfs()호출하고,시작점을 변수로 넘김
     *    3) bfs() 함수
     *    3-1) queue 초기화, 시작점과 time을 삽입함
     *    3-2) for문 돌면서 상하좌우위아래를 확인함
     *    3-3) 만약 '.'&& 방문X => queue삽입, time+1 함
     *    3-4) 만약 'E'&& 방문X => time+1 출력, return함수 종료
     *    3-5) queue가 비었을 떄까지 탈출하지 못했으면 "Trapped!"출력
     *
     * 4. 시간복잡도
     *    BFS : O(L * R * C) // 모든 칸을 방문하는 최악의경우
     */
    static int L,R,C;
    static char[][][] building;
    static boolean[][][] visited;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        // L층 수,R행,C열
       /* 금으로 막혀있어 지나갈 수 없는 칸은 '#'으로 표현되고, 비어있는 칸은 '.'으로 표현된다.
       당신의 시작 지점은 'S'로 표현되고,  탈출할 수 있는 출구는 'E'로 표현된다.
        각 층 사이에는 빈 줄이 있으며, 입력의 끝은 L, R, C가 모두 0으로 표현된다. 시작 지점과 출구는 항상 하나만 있다.*/

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){

            st = new StringTokenizer(bfr.readLine());
            L = Integer.parseInt(st.nextToken()); //층 3
            R = Integer.parseInt(st.nextToken()); //행 4
            C = Integer.parseInt(st.nextToken()); //열 5

            if (L == 0 && R == 0 && C==0) break;

            building = new char[L][R][C];
            visited = new boolean[L][R][C];

            int sx = 0,sy = 0,sh = 0;
            for (int h = 0; h < L; h++) {
                for (int y = 0; y < R; y++) {
                    String str = bfr.readLine();
                    for (int x = 0; x < C; x++) {
                        building[h][y][x] = str.charAt(x);
                        if (building[h][y][x] == 'S'){ //시작위치
                            sh = h;
                            sy = y;
                            sx = x;
                        }
                    }
                }
                bfr.readLine();
            }
            bfs(sh,sy,sx);
        }
    }
    static void bfs(int h,int y, int x){
        queue = new LinkedList<>();
        queue.add(new int[]{h,y,x,0});
        visited[h][y][x] = true;

        while (!queue.isEmpty()){
            int[] data = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = data[2] + dx[i];
                int ny = data[1] + dy[i];
                int nz = data[0] + dz[i];
                int time = data[3];

                if (nx<0 || nx>=C || ny<0 || ny>=R || nz<0 || nz>=L) continue;

                if (building[nz][ny][nx] == '.' && !visited[nz][ny][nx]){
                    visited[nz][ny][nx] = true;
                    queue.offer(new int[]{nz,ny,nx,time+1});
                }
                if (building[nz][ny][nx] == 'E' && !visited[nz][ny][nx]){
                    time++;
                    System.out.println("Escaped in "+time+" minute(s).");
                    return;
                }
            }
        }
        System.out.println("Trapped!");
    }
}