import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int w,h, count;
    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Queue<int[]> fire; //불의 위치
    static Queue<int[]> location; // 사람의 위치

    static void bfs(){
        while (!location.isEmpty()){
            /** 불의 이동*/
            int fireSize= fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] current_fire = fire.poll();
                int cx = current_fire[0];
                int cy = current_fire[1];

                for (int j = 0; j < 4; j++) {
                    int nextx = cx+dx[j];
                    int nexty = cy+dy[j];

                    if (nextx<0||nexty<0 || nextx>=h || nexty>=w) continue;

                    if (map[nextx][nexty]=='.' || map[nextx][nexty] == '@'){
                        map[nextx][nexty] = '*';
                        fire.offer(new int[]{nextx,nexty});
                    }
                }
            }

            /** 사람의 이동 */
            int locaionSize= location.size();
            for (int i = 0; i < locaionSize; i++) {
                /**  i < location.size() => 문제점
                 *  매번 반복 시 locaion.size()를 호출해서 큐의 크기 확인
                 * */

                int[] personLocation = location.poll();
                int cx = personLocation[0];
                int cy = personLocation[1];
                int time = personLocation[2]+1;


                for (int j = 0; j < 4; j++) {
                    int nextx = cx+dx[j];
                    int nexty = cy+dy[j];

                    if (nextx<0||nexty<0 || nextx>=h || nexty>=w){
                        count = time;
                        return;
                    }

                    if (map[nextx][nexty]=='.'){
                        map[nextx][nexty] = '@';
                        location.offer(new int[]{nextx,nexty, time});
                        //  location.offer(new int[]{nextx,nexty, count+1});
                        /** 해당 코드 문제점: 자꾸 0으로 초기화 됨*/
                        /** 이유: 자바에서 배열은 객체로 취급
                         * location.offer(new int[]{nextx,nexty, count+1});에서 count+1을 한 후 배열에 추가하더라도,
                         * 배열에 저장된 count+1의 값은 아니라 현재 count의 값이 저장
                         * 따라서 이 코드는 count의 현재 값으로만 배열이 생성되고, count의 값이 변경되어도 배열에는 영향XXX
                         * => 해결 하기 위해 변수로 저장한 후 그 값을 배열에 저장해야함
                         * */
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        /** 4주차
         * 1.BOJ 5427 불
         * 2. BFS
         * 3. 1) BFS로 최단 경로 구하기
         *    1-1) 입력을 받고 bfs()함수 호출
         *    1-2) 사람위치 queue / 불의 위치 queue를 만듬
         *    2-1) while문 안에 사람(location)이 없을 때 까지 시행
         *    2-2) 불을 먼저 이동 시킴
         *         '.' or '@' 이라면 가능
         *    2-3) 사람을 이동 시킴
         *         if) 좌표 밖이라면 time을 return함
         *         if) 좌표 안이라면 '.' 일 떄 이동시킴
         *          '.'
         *    3) 출력
         *    3-1) count=0 이라면 움직이지 않았기에 탈출 불가능
         *         아니라면 count 출력
         * 4. BFS 인접리스트 구현 => O(V+E)
         *    V : 정점의 수 E: 간선의 수
         *    V : 맵 한 칸 => W*H, E : 간선의 수 => 4
         *    O(W*H)
         */

        BufferedReader bfs = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bfs.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(bfs.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            fire = new LinkedList<>();
            location = new LinkedList<>();

            map = new char[h][w];
            for (int j = 0; j < h; j++) {
                String string = bfs.readLine();
                for (int k = 0; k < w; k++) {
                    map[j][k] = string.charAt(k);
                    if (map[j][k] == '@'){
                        location.offer(new int[]{j,k,0});
                    }
                    if (map[j][k] == '*'){
                        fire.offer(new int[]{j,k});
                    }
                }

            }
            count = 0;
            bfs();

            if (count!=0) System.out.println(count);
            else System.out.println("IMPOSSIBLE"); // 사람이 이동하지 않으면 탈출 할 수 없음
        }

    }

}


