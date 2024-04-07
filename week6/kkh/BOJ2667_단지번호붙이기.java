import java.io.*;
import java.util.*;

public class Main {
    static String[] map;
    static int N;
    static boolean[][] visited;
    static int num = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new String[N];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine();
        }
        
        // 0,0부터 N-1,N-1까지 check함수 실행
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                check(i,j);
            }
        }
        // 결과 출력
        int[] result = new int[num];
        // map에 값이 0이 아니면(1~) 그 값을 해당인덱스에 카운트
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(map[i].charAt(j)-'0' !=0)
                    result[map[i].charAt(j)-'0']++;
            }
        }
        // 각 단지내 집의 수를 오름차순으로 정렬
        Arrays.sort(result);
        System.out.println(num-1);
        for(int i=1;i<num;i++) {
            System.out.println(result[i]);
        }
    }
	
	// DFS방식
    public static void check(int x, int y) {
        int value = map[x].charAt(y)-'0';
        Stack<int[]> s = new Stack<>();
        // 값이 0이거나 방문했으면
        if(value==0 || visited[x][y])
            return;
        else {
            s.add(new int[]{x,y});
            visited[x][y] = true;
            char[] cAry = map[x].toCharArray();
            cAry[y] = (char) (num+'0');
            map[x] = new String(cAry);
        }
        // 현재위치에서 상하좌우 확인하면서 stack추가
        while(!s.isEmpty()) {
            int[] tmp = s.pop();
            x = tmp[0];
            y = tmp[1];
            
            for(int i=0;i<4;i++) {
                int xx=x,yy=y;
                switch(i) {
                case 0 : // 상
                    xx = x -1;
                    break;
                case 1 : // 하
                    xx = x +1;
                    break;
                case 2 : // 좌
                    yy = y -1;
                    break;
                case 3 : // 우
                    yy = y +1;
                    break;
                }
                if( !(xx>=0 && xx < N &&
                        yy >=0 && yy < N ))
                    continue;
                if(map[xx].charAt(yy) !='0' && !visited[xx][yy]) {
                    visited[xx][yy] = true;
                    s.push(new int[] {xx,yy});
                    char[] cAry = map[xx].toCharArray();
                    cAry[yy] = (char) (num+'0');
                    map[xx] = new String(cAry);
                }
            }
        }
        num++;
    }
}