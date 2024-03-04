import java.io.*;
import java.util.*;

public class Main {
	public static int V;
	public static int E;
	public static PriorityQueue<Edge> edges;
	public static int[] parent;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str =br.readLine().split(" ");
		V = Integer.parseInt(str[0]);
		E = Integer.parseInt(str[1]);
		parent = new int[V+1];
		for(int i=1;i<=V;i++) {
			parent[i]=i;
		}
		edges = new PriorityQueue<>((a,b)->a.w-b.w);
		for(int i=0;i<E;i++) {
			str = br.readLine().split(" ");
			int s = Integer.parseInt(str[0]);
			int e = Integer.parseInt(str[1]);
			int w = Integer.parseInt(str[2]);
			edges.add(new Edge(s,e,w));
		}
		
		int result =0;
		while(!edges.isEmpty()) {
			Edge tmp = edges.poll();
			if(find(tmp.s)!=find(tmp.e)) {
				union(tmp.s,tmp.e);
				result +=tmp.w;
			}
		}
		System.out.println(result);
	}
	public static void union(int a,int b) {
		a=find(a);
		b=find(b);
		if(a!=b)
			parent[Math.max(a, b)] = Math.min(a, b);
	}
	
	public static int find(int a) {
		if(parent[a]==a)
			return a;
		return parent[a] = find(parent[a]);
	}
}

class Edge{
	int s;
	int e;
	int w;
	Edge(int s,int e,int w){
		this.s=s;
		this.e=e;
		this.w=w;
	}
}