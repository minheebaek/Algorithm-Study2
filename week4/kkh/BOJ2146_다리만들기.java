import java.io.*;
import java.util.*;

public class Main {
	private static int[] dx = new int[] {0,0,-1,1};
	private static int[] dy = new int[] {-1,1,0,0};
	private static int N, cnt, result;
	private static int[][] a;
	private static boolean[][] visited, visitedSt; 
	private static Queue<int[]> q;
	private static Stack<int[]> st;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		st = new Stack<>();
		visitedSt = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				int k = Integer.parseInt(s[j]);
				a[i][j]= k;
			}
		}
		//0. 대륙별로 번호표시
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(a[i][j]==1 && !visitedSt[i][j])
					dfs(i,j);
			}
		}
		result=Integer.MAX_VALUE;
		//1. 각 대륙별로 최소거리 찾기
		while(cnt>0) {
			q = new LinkedList<>();
			visited = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(a[i][j]==cnt)
						q.offer(new int[] {i,j,a[i][j],0});
				}
			}
			result = Math.min(result, bfs());
			cnt--;
		}
		//2.값출력
		System.out.println(result);
	}
	private static void dfs(int x,int y) {
		st.push(new int[] {x,y});
		visitedSt[x][y]=true;
		cnt++;
		a[x][y]=cnt;
		while(!st.isEmpty()) {
			int[] xy = st.pop(); /// 위치,거리
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx<0 || ny<0 || nx>=N || ny>=N)
					continue;
				if(a[nx][ny]==1 && !visitedSt[nx][ny]) {
					st.push(new int[] {nx,ny});
					a[nx][ny]=cnt;
					visitedSt[nx][ny] = true;
				}
			}
		}
	}
	private static int bfs() {
		while(!q.isEmpty()) {
			int[] xynl = q.poll(); /// 위치,거리
			int x = xynl[0];
			int y = xynl[1];
			int n = xynl[2];
			int l = xynl[3];
			visited[x][y] = true;
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx<0 || ny<0 || nx>=N || ny>=N)
					continue;
				if(a[nx][ny]!=0 && a[nx][ny]!=n) {
					return l;
				}
				if(a[nx][ny]==0 && !visited[nx][ny]) {
					q.offer(new int[] {nx,ny,n,l+1});
					visited[nx][ny] = true;
				}
			}
		}
		return 0;
	}
}

//숏코딩
import java.io.*;
import java.util.*;

public class Main {
	final static int[] di = {-1, 1, 0, 0};
	final static int[] dj = {0, 0, -1, 1};
	static int N;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int[][] a = new int[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int groupcount = 2;
		for(int i=0;i<N;i++) { // 대륙별로 번호표시 2부터시작
			for(int j=0;j<N;j++) {
				if(a[i][j]==1)
					makeGroup(a, i, j, groupcount++);
			}
		}
		int min = 999999999;
		for(int i1=0;i1<N;i1++) {
			for(int j1=0;j1<N;j1++) {
				for(int i2=0;i2<N;i2++) {
					for(int j2=0;j2<N;j2++) {
						// 4중for문에서 i1,j1과 i2,j2가 중복되는 경우 제외
						if(i1>i2 || (i1==i2 && j1>=j2))
							continue;
						if(a[i1][j1]==0) // 바다
							continue;
						else if(a[i2][j2]==0) // 바다
							continue;
						else if(a[i1][j1]==a[i2][j2]) // 같은대륙
							continue;
						
						min = Math.min(min, getBridge(i1, j1, i2, j2));
					}
				}
			}
		}
		System.out.println(min);
	}
	// 대륙 번호
	static void makeGroup(int[][] a, int row, int col, int g) {
		a[row][col] = g;
		for(int k=0;k<4;k++) {
			int i = row + di[k];
			int j = col + dj[k];
			if(0<=i && i<N && 0<=j && j<N && a[i][j]==1)
				makeGroup(a, i, j, g);
		}
	}
	// 두지점 사이의 거리
	static int getBridge(int x, int y, int x2, int y2){
		return Math.abs(x-x2) + Math.abs(y-y2) -1;
	}
}