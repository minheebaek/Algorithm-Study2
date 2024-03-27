//11% 시간초과
import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {0,0,-1,1,0,0};
	public static int[] dy = {-1,1,0,0,0,0};
	public static int[] dz = {0,0,0,0,-1,1};
	public static int M;
	public static int N;
	public static int H;
	public static int all_tomato =0;
	public static int tomato =0;
	public static int[][][] map;
	public static boolean[][][] visited;
	public static int day=0;
	Stack<int[]> st1 = new Stack<>();
	Stack<int[]> st2 = new Stack<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]); // 상자 크기 M N
		N = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]); // 쌓아올려지는 상자의 수
		map = new int[H][N][M];
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				s = br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					int v = Integer.parseInt(s[j]);
					map[k][i][j]=v;
					if(v==1) {
						all_tomato++;
						tomato++;
					}else if(v==0)
						all_tomato++;
				}
			}
		}
		if(all_tomato==tomato) {
			System.out.println(0);
			return;
		}
		
		while(true) {
			visited = new boolean[H][N][M];
			int prev = tomato;
			for(int k=0;k<H;k++)
				for(int i=0;i<N;i++)
					for(int j=0;j<M;j++)
						if(!visited[k][i][j] && map[k][i][j]==1)
							dfs(k,i,j);	
			if(prev == tomato)
				break;
			day++;
		}
		if(all_tomato!=tomato)
			day=-1;
		System.out.println(day);
	}
	public static void dfs(int z, int x, int y) {
		Stack<int[]> st = new Stack<>();
		st.push(new int[] {z,x,y});
		visited[z][x][y] = true;
		while(!st.isEmpty()) {
			int[] zxy = st.pop();
			z = zxy[0];
			x = zxy[1];
			y = zxy[2];
			
			for(int k=0;k<6;k++) {
				int nz=dz[k]+z;
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<N && ny>=0 && ny<M && nz>=0 && nz<H))
					continue;
				if(!visited[nz][nx][ny]) {
					if(map[nz][nx][ny]==1) {
						st.push(new int[] {nz,nx,ny});
					}else if(map[nz][nx][ny]==0) {
						map[nz][nx][ny]=1;
						tomato++;
					}
					visited[nz][nx][ny] = true;
				}
			}
		}
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {0,0,-1,1,0,0};
	public static int[] dy = {-1,1,0,0,0,0};
	public static int[] dz = {0,0,0,0,-1,1};
	public static int M;
	public static int N;
	public static int H;
	public static int all_tomato =0;
	public static int tomato =0;
	public static int[][][] map;
	public static boolean[][][] visited;
	public static int day=0;
	public static Queue<int[]> q = new LinkedList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]); // 상자 크기 M N
		N = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]); // 쌓아올려지는 상자의 수
		map = new int[H][N][M];
		for(int k=0;k<H;k++) {
			for(int i=0;i<N;i++) {
				s = br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					int v = Integer.parseInt(s[j]);
					map[k][i][j]=v;
					if(v==1) {
						all_tomato++;
						tomato++;
					}else if(v==0)
						all_tomato++;
				}
			}
		}
		if(all_tomato==tomato) {
			System.out.println(0);
			return;
		}
		
		for(int k=0;k<H;k++)
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(map[k][i][j]==1)
						q.offer(new int[] {k,i,j});
		bfs();
		
		if(all_tomato!=tomato)
			day=-1;
		System.out.println(day);
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] zxy = q.poll();
			int z = zxy[0];
			int x = zxy[1];
			int y = zxy[2];
			day = Math.max(day,map[z][x][y]-1);
			for(int k=0;k<6;k++) {
				int nz=dz[k]+z;
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<N && ny>=0 && ny<M && nz>=0 && nz<H))
					continue;
				if(map[nz][nx][ny]==0) {
					map[nz][nx][ny]=map[z][x][y]+1;
					q.offer(new int[] {nz,nx,ny});
					tomato++;
				}
			}
		}
	}
}