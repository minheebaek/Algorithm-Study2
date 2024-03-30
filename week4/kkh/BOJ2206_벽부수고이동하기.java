import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {-1,1,0,0};
	public static int[] dy = {0,0,-1,1};
	public static int N;
	public static int M;
	public static char[][] map;
	public static Queue<block> q;
	public static boolean[][] visited;
	public static boolean[][] visited2;
	public static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Integer.parseInt(s[1]);
			map=new char[N][M];
			visited=new boolean[N][M];
			visited2=new boolean[N][M];
			q = new LinkedList<>();
			for(int i=0;i<N;i++) {
				String str = br.readLine();
				for(int j=0;j<M;j++) {
					map[i][j]=str.charAt(j);
				}
			}
			bfs();
				System.out.println(result);
	}
	private static void bfs() {
		q.offer(new block(0,0,1,false));
		visited[0][0]=true;
		while(!q.isEmpty()) {
			block b = q.poll();
			if(b.x==N-1 && b.y==M-1) {
				result=b.c;
				return;
			}
			for(int k=0;k<4;k++) {
				int nx=dx[k]+b.x;
				int ny=dy[k]+b.y;
				if(!(nx>=0 && nx<N && ny>=0 && ny<M))
					continue;
				if(map[nx][ny]=='1' && !b.b && !visited[nx][ny]) {
					q.offer(new block(nx,ny,b.c+1,true));
					visited2[nx][ny]=true;
				}
				else if(map[nx][ny]=='0' && 
						((!visited[nx][ny] && !b.b) || (!visited2[nx][ny] && b.b))) {
					q.offer(new block(nx,ny,b.c+1,b.b));
					if(!b.b)
						visited[nx][ny]=true;
					else
						visited2[nx][ny]=true;
				}
			}
		}
		result = -1;
	}
}
class block{
	int x;
	int y;
	int c;
	boolean b;
	block(int x,int y,int c, boolean b){
		this.x=x;
		this.y=y;
		this.c=c;
		this.b=b;
	}
}