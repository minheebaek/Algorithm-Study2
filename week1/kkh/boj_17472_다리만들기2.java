//1%틀림->10%틀림->통과 ( 반례들 대입하면서 수정)
import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int M;
	public static int[][] map;
	public static PriorityQueue<Edge> pq;
	public static int num; // 섬의 개수-1
	public static int[] parent;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);//지도의 세로 크기 N과 가로 크기 M
		M = Integer.parseInt(s[1]);
		
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		//모든 섬을 연결하는 다리 길이의 최솟값을 출력한다. 모든 섬을 연결하는 것이 불가능하면 -1을 출력
		
		dfs();//1.섬번호 매기기+섬의개수확인
		pq = new PriorityQueue<>((a,b)->a.w-b.w);
		edgeAdd();//2.섬간 edge 추가
		parent = new int[num];
		for(int i=1;i<num;i++) {
			parent[i]=i;
		}
		
		int edge =0;
		int result =0;
		
		while(edge<num-2) {
			if(pq.isEmpty()) {
				result=-1;
				break;
			}
			Edge tmp = pq.poll();
			if(find(tmp.s)!=find(tmp.e)) {
				union(tmp.s,tmp.e);
				result+=tmp.w;
				edge++;
			}
		}
		
		int chk = find(1);
		for(int i=2;i<num;i++) {
			if(chk!=find(i)) {
				result=-1;
				break;
			}
		}
		System.out.println(result);
		
	}
	
	public static void edgeAdd() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]>0) {
					for(int k=0;k<4;k++) {
						int x =i;
						int y =j;
						int len =0;
						switch (k) {
						case 0: //상
							while(true) {
								x--;
								if(x<0 || map[i][j]==map[x][y] ||(map[x][y]>0 && len<2))
									break;
								else if(map[x][y]==0)
									len++;
								else if(len>=2 && map[i][j]!=map[x][y]) {
									pq.add(new Edge(map[i][j],map[x][y],len));
									break;
								}
							}
							break;
						case 1: //하
							while(true) {
								x++;
								if(x>N-1 || map[i][j]==map[x][y] ||(map[x][y]>0 && len<2))
									break;
								else if(map[x][y]==0)
									len++;
								else if(len>=2 && map[i][j]!=map[x][y]) {
									pq.add(new Edge(map[i][j],map[x][y],len));
									break;
								}
							}
							break;
						case 2: //좌
							while(true) {
								y--;
								if(y<0 || map[i][j]==map[x][y] ||(map[x][y]>0 && len<2))
									break;
								else if(map[x][y]==0)
									len++;
								else if(len>=2 && map[i][j]!=map[x][y]) {
									pq.add(new Edge(map[i][j],map[x][y],len));
									break;
								}
							}
							break;
						case 3: //우
							while(true) {
								y++;
								if(y>M-1 || map[i][j]==map[x][y] ||(map[x][y]>0 && len<2))
									break;
								else if(map[x][y]==0)
									len++;
								else if(len>=2 && map[i][j]!=map[x][y]) {
									pq.add(new Edge(map[i][j],map[x][y],len));
									break;
								}
							}
							break;
						}
					}
				}
			}
		}
	}
	public static void dfs() {
		boolean[][] visited =new boolean[N][M];
		num =1;
		Stack<int[]> s = new Stack<>();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && !visited[i][j]) {
					s.push(new int[] {i,j});
					map[i][j]=num;
					visited[i][j] = true;
				}
				while(!s.isEmpty()) {
					int[] tmp = s.pop();
					int x = tmp[0];
					int y = tmp[1];
					for(int k=0;k<4;k++) {
						switch (k) {
						case 0://상
							if(x>0 && !visited[x-1][y] && map[x-1][y]==1) {
								s.push(new int[] {x-1,y});
								map[x-1][y]=num;
								visited[x-1][y] = true;
							}
							break;
						case 1://하
							if(x<N-1 && !visited[x+1][y] && map[x+1][y]==1) {
								s.push(new int[] {x+1,y});
								map[x+1][y]=num;
								visited[x+1][y] = true;
							}
							break;
						case 2://좌
							if(y>0 && !visited[x][y-1] && map[x][y-1]==1) {
								s.push(new int[] {x,y-1});
								map[x][y-1]=num;
								visited[x][y-1] = true;
							}
							break;
						case 3://우
							if(y<M-1 && !visited[x][y+1] && map[x][y+1]==1) {
								s.push(new int[] {x,y+1});
								map[x][y+1]=num;
								visited[x][y+1] = true;
							}
							break;
						}
					}
					if(s.isEmpty())
						num++;
				}
			}
		}
	}
	public static void union(int a,int b) {
		a = find(a);
		b = find(b);
		if(a!=b)
			parent[Math.max(a, b)] = Math.min(a, b);
	}
	public static int find(int a) {
		if(parent[a]==a)
			return a;
		return parent[a] = find(parent[a]);
	}
}

class Edge {
	int s;
	int e;
	int w;
	Edge(int s,int e,int w){
		this.s=s;
		this.e=e;
		this.w=w;
	}
}