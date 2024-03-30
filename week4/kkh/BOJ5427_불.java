//12% 틀림
import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int w;
	public static int h;
	public static char[][] map;
	public static Queue<int[]> q = new LinkedList<>();
	public static int[] pos;
	public static int[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 케이스T
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			w = Integer.parseInt(s[0]);
			h = Integer.parseInt(s[1]);
			map=new char[h][w];
			visited=new int[h][w];
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++)
					if(map[i][j]=='*')
						q.offer(new int[] {i,j,0});
					else if(map[i][j]=='@')
						pos = new int[] {i,j};
			bfs();
			int result = bfs2();
			if(result==0)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(result);
		}
		
	}
	private static int bfs2() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {pos[0],pos[1],0});
		while(!q.isEmpty()) {
			int[] xym = q.poll();
			int x = xym[0];
			int y = xym[1];
			int m = xym[2];
			map[x][y]='#';
			for(int k=0;k<4;k++) {
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<h && ny>=0 && ny<w)) {
					return m+1;
				}
				if(map[nx][ny]!='#' && visited[nx][ny]>m+1) {
					q.offer(new int[] {nx,ny,m+1});
					map[nx][ny]='*';
				}
			}
		}
		return 0;
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] xym = q.poll();
			int x = xym[0];
			int y = xym[1];
			int m = xym[2];
			visited[x][y]=m;
			for(int k=0;k<4;k++) {
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<h && ny>=0 && ny<w))
					continue;
				if(map[nx][ny]=='.' || map[nx][ny]=='@') {
					q.offer(new int[] {nx,ny,m+1});
					map[nx][ny]='*';
				}
			}
		}
	}
}

//37% 메모리초과
public class Main {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int w;
	public static int h;
	public static char[][] map;
	public static Queue<int[]> q;
	public static int[] pos;
	public static int[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 케이스T
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			w = Integer.parseInt(s[0]);
			h = Integer.parseInt(s[1]);
			map=new char[h][w];
			visited=new int[h][w];
			for(int i=0;i<h;i++)
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			q = new LinkedList<>();
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			for(int i=0;i<h;i++)
				for(int j=0;j<w;j++)
					if(map[i][j]=='*')
						q.offer(new int[] {i,j,0});
					else if(map[i][j]=='@')
						pos = new int[] {i,j};
			bfs();
			int result = bfs2();
			if(result==0)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(result);
		}
		
	}
	private static int bfs2() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {pos[0],pos[1],0});
		while(!q.isEmpty()) {
			int[] xym = q.poll();
			int x = xym[0];
			int y = xym[1];
			int m = xym[2];
			map[x][y]='#';
			for(int k=0;k<4;k++) {
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<h && ny>=0 && ny<w)) {
					return m+1;
				}
				if(map[nx][ny]!='#' && visited[nx][ny]>m+1) {
					q.offer(new int[] {nx,ny,m+1});
					map[nx][ny]='*';
				}
			}
		}
		return 0;
	}
	public static void bfs() {
		while(!q.isEmpty()) {
			int[] xym = q.poll();
			int x = xym[0];
			int y = xym[1];
			int m = xym[2];
			visited[x][y]=m;
			for(int k=0;k<4;k++) {
				int nx=dx[k]+x;
				int ny=dy[k]+y;
				if(!(nx>=0 && nx<h && ny>=0 && ny<w))
					continue;
				if(map[nx][ny]=='.' || map[nx][ny]=='@') {
					q.offer(new int[] {nx,ny,m+1});
					map[nx][ny]='*';
				}
			}
		}
	}
}

// 위 메모리초과는 불인상태여도 bfs로 최단시간 확인이라 큐에 넣음
// 아래는 매초마다 불번짐과 상근이의이동을 같이 확인하면서 큐에 .만 이동가능하도록 수정함
import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int w;
	public static int h;
	public static char[][] map;
	public static Queue<int[]> q;
	public static Queue<int[]> q2;
	public static int[][] visited;
	public static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 케이스T
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			w = Integer.parseInt(s[0]);
			h = Integer.parseInt(s[1]);
			map=new char[h][w];
			visited=new int[h][w];
			for(int i=0;i<h;i++)
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			q = new LinkedList<>();
			q2 = new LinkedList<>();
			for(int i=0;i<h;i++) {
				String str = br.readLine();
				for(int j=0;j<w;j++) {
					map[i][j]=str.charAt(j);
					if(map[i][j]=='*')
						q.offer(new int[] {i,j});
					else if(map[i][j]=='@')
						q2.offer(new int[] {i,j,0});
				}
			}
			result=0;
			bfs();
			if(result==0)
				System.out.println("IMPOSSIBLE");
			else
				System.out.println(result);
		}
	}
	private static void bfs() {
		while(!q2.isEmpty()) {
			int size = q.size();
			while(size-->0) {
				int[] xym = q.poll();
				int x = xym[0];
				int y = xym[1];
				for(int k=0;k<4;k++) {
					int nx=dx[k]+x;
					int ny=dy[k]+y;
					if(!(nx>=0 && nx<h && ny>=0 && ny<w))
						continue;
					if(map[nx][ny]=='.' || map[nx][ny]=='@') {
						q.offer(new int[] {nx,ny});
						map[nx][ny]='*';
					}
				}
			}
			size = q2.size();
			while(size-->0) {
				int[] xym = q2.poll();
				int x = xym[0];
				int y = xym[1];
				int m = xym[2];
				for(int k=0;k<4;k++) {
					int nx=dx[k]+x;
					int ny=dy[k]+y;
					if(!(nx>=0 && nx<h && ny>=0 && ny<w)) {
						result=m+1;
						return;
					}
					if(map[nx][ny]=='.') {
						q2.offer(new int[] {nx,ny,m+1});
						map[nx][ny]='@';
					}
				}
			}
		}
	}
}