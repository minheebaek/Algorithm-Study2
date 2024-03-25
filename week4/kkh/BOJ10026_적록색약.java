import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int N;
	public static char[][] map;
	public static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		String s;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<N;j++)
				map[i][j]=s.charAt(j);
		}
		int a=0,b=0;
		visited = new boolean[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				a+=dfs(i,j,map[i][j]);
		visited = new boolean[N][N];
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				if(map[i][j]=='G')
					map[i][j]='R';
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				b+=dfs(i,j,map[i][j]);
		System.out.println(a);
		System.out.println(b);
	}
	public static int dfs(int x, int y, char start) {
		Stack<int[]> st = new Stack<>();
		if(visited[x][y])
			return 0;
		st.push(new int[] {x,y});
		visited[x][y] = true;
		while(!st.isEmpty()) {
			int[] xy = st.pop();
			x = xy[0];
			y = xy[1];
			
			for(int k=0;k<4;k++) {
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<N && ny>=0 && ny<N))
					continue;
				if(!visited[nx][ny] && map[nx][ny]==start) {
					st.push(new int[] {nx,ny});
					visited[nx][ny] = true;
				}
			}
		}
		return 1;
	}
}