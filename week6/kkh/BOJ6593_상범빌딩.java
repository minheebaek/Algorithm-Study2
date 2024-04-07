import java.io.*;
import java.util.*;

public class Main {
	static final int[] dx = {1,-1,0,0,0,0};
	static final int[] dy = {0,0,1,-1,0,0};
	static final int[] dz = {0,0,0,0,1,-1};
	static int L,R,C,result;
	static int[] S,E;
	static int[][][] map;
	static boolean[][][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] s = br.readLine().split(" ");
			L = Integer.parseInt(s[0]);
			R = Integer.parseInt(s[1]);
			C = Integer.parseInt(s[2]);
			if(L==0 && L==R && L==C)
				break;
			map = new int[L][R][C];
			visited = new boolean[L][R][C];
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					String str = br.readLine();
					for(int k=0;k<C;k++) {
						map[i][j][k]=str.charAt(k);
						if(str.charAt(k) == 'S')
							S = new int[] {i,j,k};
						if(str.charAt(k) == 'E')
							E = new int[] {i,j,k};
					}
				}
				br.readLine();
			}
			result=-1;
			bfs();
			if(result==-1)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in "+result+" minute(s).");
		}
	}
	static void bfs() {
		Queue<int[]> st = new LinkedList<>();
		st.offer(new int[] {S[0],S[1],S[2],0});
		visited[S[0]][S[1]][S[2]]=true;
		while(!st.isEmpty()) {
			int[] zxy = st.poll();
			int z = zxy[0];
			int x = zxy[1];
			int y = zxy[2];
			int c = zxy[3];
			if(z==E[0] && x==E[1] && y==E[2]) {
				result=c;
				return;
			}
			for(int k=0;k<6;k++) {
				int nz = dz[k]+z;
				int nx = dx[k]+x;
				int ny = dy[k]+y;
				
				if(nz<0 || nx<0 || ny<0 || nz>=L || nx >=R || ny>=C)
					continue;
				if((map[nz][nx][ny]=='.'||map[nz][nx][ny]=='E') && !visited[nz][nx][ny]) {
					visited[nz][nx][ny]=true;
					st.offer(new int[] {nz,nx,ny,c+1});
				}
			}
		}
	}
}