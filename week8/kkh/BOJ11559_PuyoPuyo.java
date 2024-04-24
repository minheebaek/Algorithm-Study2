import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int N=12,M=6,result=0;
	static char[][] puyo = new char[N][M];
	static boolean visited[][];
	static List<int[]> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<N;i++)
			puyo[i]= br.readLine().toCharArray();
		
		while(true) {
			list = new ArrayList<>();
			visited = new boolean[N][M];
			for(int i=0;i<N;i++)
				for(int j=0;j<M;j++)
					if(puyo[i][j]!='.' && !visited[i][j])
						dfs(i,j);

			if(!list.isEmpty()) {
				for(int i=0;i<list.size();i++)
					puyo[list.get(i)[0]][list.get(i)[1]]=' ';
				blankBlockChk();
				result++;
			}else {
				System.out.println(result);
				return;
			}
		}
	}
	public static void blankBlockChk() {
		for(int k=N-1;k>=0;k--) {
			for(int i=0;i<M;i++) {
				if(puyo[k][i]==' ') {
					for(int j=k;j>0;j--) {
						puyo[j][i]=puyo[j-1][i];
					}
					puyo[0][i]='.';
					i--;
				}
			}
		}
	}
	public static void dfs(int x,int y) {
		List<int[]> list = new ArrayList<>();
		Stack<int[]> st = new Stack<>();
		st.push(new int[] {x,y});
		list.add(new int[] {x,y});
		visited[x][y]= true;
		
		while(!st.isEmpty()) {
			int[] xy = st.pop();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				
				if(nx<0 || ny<0 || nx>=N || ny>= M)
					continue;
				if(puyo[nx][ny]==puyo[x][y] && !visited[nx][ny]) {
					st.push(new int[] {nx,ny});
					list.add(new int[] {nx,ny});
					visited[nx][ny]= true;
				}
			}
			
		}
		if(list.size()>=4)
			Main.list.addAll(list);
	}
}