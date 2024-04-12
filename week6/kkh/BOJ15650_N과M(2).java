import java.io.*;
import java.util.*;


public class Main {
	static int N,M;
	static List<List<Integer>> result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		List<Integer> a = new LinkedList<>();
		result = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			a.add(i);
		}
		
		recursive(a,new ArrayList<>());
		
		for(List<Integer> list : result) {
			for(Integer i : list) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	public static void recursive(List<Integer> a, List<Integer> b) {
		if(b.size()==M) {
			result.add(b);
			return;
		}
		if(a.size()==0)
			return;
		for(int i=0; i<a.size();i++) {
			if(!(b.size()==0 ||
				b.get(b.size()-1)<a.get(i)))
				continue;
			List<Integer> tmp1 = new LinkedList<>(a);
			List<Integer> tmp2 = new LinkedList<>(b);
			tmp2.add(tmp1.get(i));
			tmp1.remove(i);
			recursive(tmp1,tmp2);
		}
	}
}

// 숏코딩
import java.util.Scanner;

public class Main {
	static int n,m,arr[];
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	n=sc.nextInt();
	m=sc.nextInt();
	arr=new int [n];
	dfs(0,0);
}
	static void dfs(int start, int cnt) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				System.out.print(arr[i]+" ");
			}System.out.println();
		}
		for(int i=start;i<n;i++) {
			arr[cnt]=i+1;
			dfs(i+1,cnt+1);
			
		}
	}
}