package week4.minheebaek;

import java.util.*;
import java.io.*;

/** 4주차
 * 1.BOJ 5427
 * 2.BFS
 * 3.최단거리, 양방향 탐색 BFS
 * 4.O(NM)
 */

/** 배운점
 * 1.큐 두개를 이용해서 양방향 탐색, 공통 map을 이용하기 때문에 큐 두개 사용해서 따로 bfs 진행해도 상관없음
 * 2.불이 있거나, 번진다면 사람이 갈 필요가 없다는 아이디어 필요
 */

class Pair{
    int x;
    int y;
    int dept;

    public Pair(int x, int y, int dept){
        this.x=x;
        this.y=y;
        this.dept=dept;
    }
}
public class BOJ5427_불 {
    static int h,w,ans;
    static int[] dirx={1,0,-1,0};
    static int[] diry={0,-1,0,1};
    static int[][] map;
    static boolean[][] visited;
    static Queue<Pair> pepole,fire;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            visited = new boolean[h][w];
            pepole = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = str.charAt(j);

                    if (map[i][j] == '*') {//불일경우
                        fire.add(new Pair(i, j, 0));

                    }
                    if (map[i][j] == '@') {//사람일경우
                        pepole.add(new Pair(i, j, 0));

                    }

                }

            }

            ans = 0;
            bfs();
            if (ans == 0) {
                sb.append("IMPOSSIBLE\n");
            } else {
                sb.append(ans+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    static void bfs() {
        while(!pepole.isEmpty()){ //사람이 끝날때까지

            //불부터 함, fireSize만큼 큐 돌리면서 불 확장
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                Pair pair=fire.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = pair.x + dirx[j];
                    int ny = pair.y + diry[j];

                    if(nx<0||ny<0||nx>=h||ny>=w) continue;

                    if(map[nx][ny]=='.'||map[nx][ny]=='@'){ //이동 가능 -> 불
                        map[nx][ny] = '*';
                        fire.add(new Pair(nx, ny, 0));
                    }
                }
            }
            int pepoleSize = pepole.size();
            for (int i = 0; i < pepoleSize; i++) {
                Pair pair=pepole.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = pair.x + dirx[j];
                    int ny = pair.y + diry[j];

                    if(nx<0||ny<0||nx>=h||ny>=w) { //탈출 가능할경우
                        ans=pair.dept+1;
                        return;
                    }

                    if(!visited[nx][ny]&&map[nx][ny]=='.'){ //이동 가능할경우
                        visited[nx][ny]=true;
                        pepole.add(new Pair(nx, ny, pair.dept+1));
                    }
                }
            }

        }
    }
}
