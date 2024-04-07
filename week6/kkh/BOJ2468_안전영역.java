import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = {1,-1,0,0};
	static final int[] dy = {0,0,1,-1};
	static int N,result=-1;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		String[] s;
		int wMax = Integer.MIN_VALUE;
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				int h = Integer.parseInt(s[j]);
				map[i][j]=h;
				wMax = Math.max(wMax, h);
			}
		}
		
		for(int i=0;i<wMax;i++) {
			result = Math.max(result, dfs(i));
		}

		System.out.println(result);
	}
	static int dfs(int w) {
		Stack<int[]> st = new Stack<>();
		visited = new boolean[N][N];
		int cnt =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]-w>0 && !visited[i][j]) {
					st.push(new int[] {i,j});
					visited[i][j]=true;
					cnt++;
					
					while(!st.isEmpty()) {
						int[] xy = st.pop();
						int x = xy[0];
						int y = xy[1];
						for(int k=0;k<4;k++) {
							int nx = dx[k]+x;
							int ny = dy[k]+y;
							
							if(nx<0 || ny<0 || nx >=N || ny>=N)
								continue;
							if(map[nx][ny]-w>0 && !visited[nx][ny]) {
								visited[nx][ny]=true;
								st.push(new int[] {nx,ny});
							}
						}
					}
				}
			}
		}
		return cnt;
	}
}