import java.io.*;
import java.util.*;

public class Main {
	final static int[] dx = {-1, 1, 0, 0};
	final static int[] dy = {0, 0, -1, 1};
	static int N,M,K,cnt=0;
	static List<Integer> list;
	static boolean[][] unVisited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		K = Integer.parseInt(s[2]);
		unVisited = new boolean[M][N];
		for(int i=0;i<K;i++) {
			s = br.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 = Integer.parseInt(s[3]);
			//1.직사각형 내부 unVisited true로 변경
			for(int ny =y1;ny<y2;ny++)
				for(int nx =x1;nx<x2;nx++)
					unVisited[ny][nx]=true;
		}
		list = new ArrayList<>();
		//2.분리된 영역 갯수 구하기
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				if(!unVisited[i][j])
						list.add(dfs(i,j));
		
		System.out.println(cnt);
		Collections.sort(list);
		for(Integer i : list) {
			System.out.print(i+" ");
		}
	}
	static int dfs(int x, int y) {
		cnt++;
		int size=1;
		Stack<int[]> st = new Stack<>();
		st.push(new int[] {x,y});
		unVisited[x][y]=true;
		while(!st.isEmpty()) {
			int[] xy = st.pop();
			x = xy[0];
			y = xy[1];
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				if(nx<0 || ny<0 || nx>=M || ny>=N)
					continue;
				if(!unVisited[nx][ny]) {
					unVisited[nx][ny]=true;
					st.push(new int[] {nx,ny});
					size++;
				}
			}
		}
		return size;
	}
}