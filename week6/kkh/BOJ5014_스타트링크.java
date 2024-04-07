import java.io.*;
import java.util.*;

public class Main {
	static int F,S,G,U,D,result=-1;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		F = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		G = Integer.parseInt(s[2]);
		U = Integer.parseInt(s[3]);
		D = Integer.parseInt(s[4]);
		visited = new boolean[F+1];
		
		bfs();
		
		if(result==-1)
			System.out.println("use the stairs");
		else
			System.out.println(result);
	}
	static void bfs() {
		Queue<int[]> st = new LinkedList<>();
		st.offer(new int[] {S,0});
		visited[S]=true;
		while(!st.isEmpty()) {
			int[] layer = st.poll();
			if(layer[0]==G) {
				result = layer[1];
				return;
			}
			for(int i=0;i<2;i++) {
				int nowLayer;
				if(i==0)
					nowLayer = layer[0] + U;
				else
					nowLayer = layer[0] - D;
				
				if(nowLayer<1 || nowLayer >F)
					continue;
				if(!visited[nowLayer]) {
					visited[nowLayer]=true;
					st.offer(new int[] {nowLayer,layer[1]+1});
				}
			}
		}
	}
}