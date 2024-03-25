import java.io.*;
import java.util.*;

public class Main {
	public static int M;
	public static int N;
	public static int K;
	public static int[][] a;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);// M 배추밭 가로길이
			N = Integer.parseInt(s[1]);// N 배추밭 세로길이
			K = Integer.parseInt(s[2]);// K 배추 갯수
			a = new int[M][N];
			for(int i=0;i<K;i++) {
				s = br.readLine().split(" ");
				a[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
			}
			System.out.println(dfs());
		}
	}
	public static int dfs() {
		int num = 0;
		boolean[][] visited = new boolean[M][N];
		Queue<int[]> st = new LinkedList<>();
		
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				if(!visited[i][j] && a[i][j]>0) {
					st.offer(new int[] {i,j});
					visited[i][j] = true;
					num++;
				}
				while(!st.isEmpty()) {
					int[] xy = st.poll();
					int x = xy[0];
					int y = xy[1];
					
					for(int k=0;k<4;k++) {
						int nx=x;
						int ny=y;
						boolean b = false;
						switch(k) {
						case 0://상
							if(x-1>=0 && !visited[x-1][y] && a[x-1][y]>0) {
								nx = x -1;
								b = true;
							}
							break;
						case 1://하
							if(x+1<M && !visited[x+1][y] && a[x+1][y]>0) {
								nx = x +1;
								b = true;
							}
							break;
						case 2:
							if(y-1>=0 && !visited[x][y-1] && a[x][y-1]>0) {
								ny = y -1;
								b = true;
							}
							break;
						case 3:
							if(y+1<N && !visited[x][y+1] && a[x][y+1]>0) {
								ny = y +1;
								b = true;
							}
							break;
						}
						if(b) {
							st.offer(new int[] {nx,ny});
							visited[nx][ny] = true;
							a[nx][ny]=num;
						}
					}
				}
			}
		}
		return num;
	}
}

// 방향 변수 만든 코드
import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {0,0,-1,1};
	public static int[] dy = {-1,1,0,0};
	public static int M;
	public static int N;
	public static int K;
	public static int[][] a;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			M = Integer.parseInt(s[0]);// M 배추밭 가로길이
			N = Integer.parseInt(s[1]);// N 배추밭 세로길이
			K = Integer.parseInt(s[2]);// K 배추 갯수
			a = new int[M][N];
			for(int i=0;i<K;i++) {
				s = br.readLine().split(" ");
				a[Integer.parseInt(s[0])][Integer.parseInt(s[1])]=1;
			}
			System.out.println(dfs());
		}
	}
	public static int dfs() {
		int num = 0;
		boolean[][] visited = new boolean[M][N];
		Queue<int[]> st = new LinkedList<>();
		
		for(int i=0;i<M;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && a[i][j]>0) {
					st.offer(new int[] {i,j});
					visited[i][j] = true;
					num++;
				}
				while(!st.isEmpty()) {
					int[] xy = st.poll();
					int x = xy[0];
					int y = xy[1];
					
					for(int k=0;k<4;k++) {
						int nx=dx[k]+x;
						int ny=dy[k]+y;
						if(!(nx>=0 && nx<M && ny>=0 && ny<N))
							continue;
						if(!visited[nx][ny] && a[nx][ny]>0) {
							st.offer(new int[] {nx,ny});
							visited[nx][ny] = true;
							a[nx][ny]=num;
						}
					}
				}
			}
		}
		return num;
	}
}