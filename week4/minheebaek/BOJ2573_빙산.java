import java.util.*;
import java.io.*;

class Iceberg{
    int x;
    int y;

    public Iceberg(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class BOJ2573_빙산 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirx={1,0,-1,0};
    static int[] diry={0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) { //배열 초기화
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }

        }

        //1.빙하 덩어리 세기 dfs
        //2.빙하 녹이고 빙하 상태 반영하기 bfs
        //3.빙하 덩어리 센거 2 이하면 bfs 추가 실행, 0이면 다 녹은거니까 0, 넘으면 결과 출력

        //3번부터
        int cnt=0;
        int year=0;
        while((cnt=countIceberg())<2){//2이상이면 두개로 쪼개진 시간을 출력
            if(cnt==0){ //빙하 다 녹음
                year=0;
                break;
            }
            //빙하 2 미만
            bfs(); //빙하 녹이고 시간 늘리기
            year++;
        }
        System.out.println(year);
    }

    static int countIceberg(){ //dfs 실행해서 빙하 개수 세기
        boolean[][] visited = new boolean[n][m]; //while문 돌리면서 빙하 개수를 계속 확인해야히니까 매번 생성하는 것 같다

        int cnt=0;
        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(!visited[i][j]&&map[i][j]!=0){//방문하지 않았고 빙하 있음, 빙하 여러개 찾아야 하니까 이중 for문
                    dfs(i,j,visited);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int x, int y, boolean[][] visited){
        visited[x][y]=true;

        for(int i=0; i<4;i++){
            int nx=x+dirx[i];
            int ny=y+diry[i];

            if(nx<0||ny<0||nx>=n||ny>=m) continue;

            if(!visited[nx][ny]&&map[nx][ny]!=0) //방문x 빙하o
                dfs(nx,ny,visited);

        }

    }

    static void bfs(){
        boolean[][] visited = new boolean[n][m]; //매년 빙하 녹이기 해야하니까 배열 생성
        Queue<Iceberg> queue = new LinkedList<>();

        for(int i=0; i<n;i++){
            for(int j=0; j<m;j++){
                if(map[i][j]!=0){
                    queue.add(new Iceberg(i,j));
                    visited[i][j]=true;
                }
            }
        }

        while(!queue.isEmpty()){
            Iceberg iceberg= queue.poll();
            int sea=0;
            for(int i=0; i<4;i++){
                int nx=iceberg.x+dirx[i];
                int ny=iceberg.y+diry[i];

                if(nx<0||ny<0||nx>=n||ny>=m) continue;

                if(!visited[nx][ny]&&map[nx][ny]==0){ //방문x 바다
                    sea++;
                }

            }
            if(map[iceberg.x][iceberg.y]-sea<0){
                map[iceberg.x][iceberg.y]=0;
            }else{
                map[iceberg.x][iceberg.y]-=sea;
            }
        }

    }
}