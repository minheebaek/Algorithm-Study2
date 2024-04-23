package test;

import java.io.*;
import java.util.*;

public class Main {
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int N,M,G,R,map[][],time[][],result=0;
	static char[] GR = new char[] {'G','R'};
	static Data[] data;
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		G = Integer.parseInt(s[2]);
		R = Integer.parseInt(s[3]);
		map = new int[N][M];
		
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				int n = Integer.parseInt(s[j]);
				if(n==2)
					list.add(new int[] {i,j});
				if(n!=0)
					n=1;
				map[i][j]= n;
			}
		}
		//1 배양액을 뿌릴 수 있는 땅중에서 배양액(초록,빨강)을 뿌릴수있는 모든 경우의 수를 구한다
		//2 각 경우의 수마다 꽃의 개수를 구한다
		//3 곷의 최대 개수를 출력한다
		data = new Data[G+R];
		recursive(list,0,0);
		System.out.println(result);
	}
	public static void recursive(List<int[]> list, int g, int r) {
		if(g==G && r==R) {
			result = Math.max(bfs(),result);
			// 모든 경우의 수 확인
//			for(int i=0;i<data.length;i++) {
//				System.out.print(data[i].x+","+data[i].y+" ");
//			}
//			System.out.println();
			return;
		}
		for(int i=0; i<list.size();i++) {
			if(!(g+r == 0 || data[g+r-1].index <Main.list.indexOf(list.get(i))))
					continue;
			for(int j=0;j<2;j++) {
				List<int[]> tmp = new ArrayList<>(list);
				data[g+r]=new Data(Main.list.indexOf(list.get(i)),list.get(i),GR[j]);
				tmp.remove(i);
				if(j==0 && g<G)
					recursive(tmp, g+1, r);
				if(j==1 && r<R)
					recursive(tmp, g, r+1);
			}
		}
	}
	public static int bfs() {
		int cnt=0;
		boolean[][] visited = new boolean[N][M];
		int[][] map = new int[N][M];
		time = new int[N][M];
		for(int i=0;i<N;i++) {
			map[i]=Main.map[i].clone();
		}
		
		Queue<Datat> q = new LinkedList<>();
		for(int i=0;i<data.length;i++) {
			q.offer(new Datat(data[i],0));
			visited[data[i].x][data[i].y] = true;
		}
		
		while(!q.isEmpty()) {
			Datat d = q.poll();
			visited[d.x][d.y] = true;
			if(map[d.x][d.y]==4){//꽃
				cnt++;
				continue;
			}
			for(int i=0;i<4;i++) {
				int nx = dx[i]+d.x;
				int ny = dy[i]+d.y;
				
				if(nx <0 || ny <0 || nx >=N || ny>=M)
					continue;
				if(!visited[nx][ny] && map[nx][ny]!=0) {
					int c = d.c=='G'?2:3;
					if(time[nx][ny] == d.time+1) {
						if((map[nx][ny]==2 || map[nx][ny]==3) &&c!=map[nx][ny]) {
							map[nx][ny]=4;
						}
					}
					else if(time[nx][ny]==0){
						time[nx][ny] = d.time+1;
						map[nx][ny]= c;
						q.offer(new Datat(new Data(d.index,new int[] {nx,ny},d.c),d.time+1));
					}
					
				}
			}
		}
		return cnt;
	}
}
class Data{
	int index;
	int x;
	int y;
	char c;
	Data(int index, int[] xy ,char c){
		this.index=index;
		this.x=xy[0];
		this.y=xy[1];
		this.c=c;
	}
}
class Datat{
	int index;
	int x;
	int y;
	char c;
	int time;
	Datat(Data d,int time){
		this.time = time;
		this.index=d.index;
		this.x=d.x;
		this.y=d.y;
		this.c=d.c;
	}
}