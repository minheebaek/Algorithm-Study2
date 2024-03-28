import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {-1,-2,-2,-1,1,2,2,1};
	public static int[] dy = {-2,-1,1,2,-2,-1,1,2};
	public static int[] start;
	public static int[] end;
	public static int l;
	public static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 케이스T
		while(T-->0) {
			l = Integer.parseInt(br.readLine());// 체크한변의길이l
			String[] s = br.readLine().split(" ");
			start = new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])};
			s = br.readLine().split(" ");
			end = new int[]{Integer.parseInt(s[0]),Integer.parseInt(s[1])};
			
			result = 0;
			bfs();
			System.out.println(result);
		}
		
	}
	public static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[l][l];
		q.offer(new int[] {start[0],start[1],0});
		visited[start[0]][start[1]] = true;
		while(!q.isEmpty()) {
			int[] xym = q.poll();
			int x = xym[0];
			int y = xym[1];
			int m = xym[2];
			if(x==end[0] && y==end[1]) {
				result = m;
				break;
			}
			for(int k=0;k<8;k++) {
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<l && ny>=0 && ny<l))
					continue;
				if(!visited[nx][ny]) {
					q.offer(new int[] {nx,ny,m+1});
					visited[nx][ny] = true;
				}
			}
		}
	}
}