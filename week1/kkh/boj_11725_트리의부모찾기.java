import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] parent = new int[N+1];
		List<Integer>[] adj =new List[N+1];
		
		
		String[] s;
		for(int i=0;i<=N;i++)
			adj[i] = new ArrayList<>();
		for(int i=1;i<N;i++) {
			s= br.readLine().split(" ");
			adj[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
			adj[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
		}
		
		Stack<Integer> st = new Stack<>();
		boolean[] visited = new boolean[N+1];
		st.push(1);
		
		while(!st.isEmpty()) {
			int now = st.pop();
			visited[now]=true;
			for(int i : adj[now]) {
				if(!visited[i]) {
					st.push(i);
					parent[i]=now;
				}
			}
		}
		
		for(int i=2;i<parent.length;i++) {
			System.out.println(parent[i]);
		}
	}
}