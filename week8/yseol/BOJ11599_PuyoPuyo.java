import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    /** 8주차
     * 1.BOJ 11559 PuyoPuyo
     * 2. 시뮬레이션
     * 3. 1) bfs() -> map[i][j] != '.' 이면 근처에 같은 뿌요를 찾는다
     *    1-1) list.add({x,y}) -> list에 뿌요 좌표를 넣는다 - 4개 이상이면 터틀어야함
     *    2) dropPuyo() -> 뿌요들을 맨 아래로 보내야함
     *    2-1) int emptyRow = 11 -> 맨 아래부터 채워 넣을 꺼임
     *    2-2) for문 -> 맨 아래 (11,0)부터 돌면서 '.' 아니고, emptyRow != i 이면 map[emptyRow][j] = map[i][j]
     *         => 즉, emptyRow <=> i 에 위치를 교환함
     *         emptyRow--; 중요! if(emtpyRow != i) 종료 후 빼야함.
     *        3) main
     *    3-1) while(true) 무한루프 -> boolean isflag = true;
     *    3-2) 반복문 돌면서 뿌요가 있으면 bfs()호출 -> if(list.size()>=4)라면
     *    3-3) list에 담겨있는 좌표 '.'로 변경하고 isflag = false -> 더있는지 확인필요하니깐 루프 종료안함
     *    3-4) if (isFlag) break -> 터트릴게 없으면 종료
     *         아니면 dropPuyo(); count++;
     *
     * 4. 시간복잡도
     *    O(n * (12 * 6)^2) -> n: while 시행 횟수, (12 * 6)^2 : bfs()와 dropPuyo() 시간 복잡도
     */
    static char[][] map = new char[12][6];
    static boolean[][] visit;
    static int count;
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,1,0,-1};
    static ArrayList<Integer[]> list;

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String str = new String(bf.readLine());
            for (int j = 0; j < 6; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        count=0;

        while (true){
            boolean isFlag = true;
            visit = new boolean[12][6];

            for (int i = 0; i <12 ; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.'){
                        list = new ArrayList<>();
                        bfs(map[i][j],i,j);

                        if (list.size() >= 4){
                            isFlag = false; // 터졌으면 더 있는지 확인 필요
                            for (int k = 0; k <list.size() ; k++) {
                                map[list.get(k)[0]][list.get(k)[1]] = '.';
                            }
                        }
                    }
                }
            }
            if (isFlag) break;
            dropPuyo();
            count++;
        }

        System.out.println(count);

    }

    static void bfs(char c, int a,int b){
        LinkedList<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{a,b});
        list.add(new Integer[]{a,b});
        visit[a][b] = true;

        while (!queue.isEmpty()){
            Integer[] data =queue.poll();
            int x = data[0];
            int y = data[1];

            for (int i = 0; i <4 ; i++) {
                int nx = x+ dx[i];
                int ny = y+ dy[i];

                if (nx < 0 || nx>=12 || ny<0 || ny>=6) continue;

                if (!visit[nx][ny] && map[nx][ny] == c){
                    list.add(new Integer[]{nx,ny});
                    visit[nx][ny] =true;
                    queue.offer(new Integer[]{nx,ny});
                }
            }
        }
    }
    static void dropPuyo(){
        for (int j=0; j < 6; j++) {
            int emptyRow = 11;
            for (int i = 11; i >= 0; i--) {
                if (map[i][j] != '.'){
                    if (i != emptyRow){
                        map[emptyRow][j] = map[i][j];
                        map[i][j] = '.';
                    }
                    emptyRow--;
                }
            }
        }
    }
}