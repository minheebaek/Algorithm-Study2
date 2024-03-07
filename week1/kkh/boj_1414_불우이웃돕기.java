import java.io.*;
import java.util.*;

public class Main {
	public static int[] parent;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());//컴퓨터의 개수 N
		PriorityQueue<Edge> edges = new PriorityQueue<>((a,b)->a.w-b.w);
		int totalLAN = 0;
		char[] c;
		parent = new int[N+1];
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i=1;i<=N;i++) {
			c = br.readLine().toCharArray();
			for(int j=1;j<=N;j++) {
				int tw = ctoi(c[j-1]);
				if(tw==0)
					continue;
				edges.add(new Edge(i,j,tw));
				totalLAN += tw;
			}
		}
		
		int edge = 0;
		int result =0;
		while(edge<N-1) {
			if(edges.isEmpty()) {
				result = -1;
				break;
			}
			Edge tmp = edges.poll(); 
			
			if(find(tmp.s)!=find(tmp.e)) {
				union(tmp.s,tmp.e);
				result+=tmp.w;
				edge++;
			}
		}
		if(result!=-1)
			result = totalLAN -result;
		System.out.println(result);
	}
	
	public static int ctoi(char c) {//랜선의 길이는 a부터 z는 1부터 26을 나타내고, A부터 Z는 27부터 52
		int tmp =0;
		if(c=='0')
			return tmp;
		else if(c >= 'a')
			return c-'a'+1;
		else
			return c-'A'+27;
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
		return parent[a]=find(parent[a]);
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