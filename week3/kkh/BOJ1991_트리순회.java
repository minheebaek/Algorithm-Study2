import java.io.*;
import java.util.*;

public class Main {
	public static int[][] a;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s;
		a = new int[27][2];
		for(int i=0;i<N;i++) {
			s=br.readLine().split(" ");
			if(s[1].charAt(0)!='.')
				a[s[0].charAt(0)-'A'][0]=s[1].charAt(0)-'A';
			else
				a[s[0].charAt(0)-'A'][0]=-1;
			if(s[2].charAt(0)!='.')
				a[s[0].charAt(0)-'A'][1]=s[2].charAt(0)-'A';
			else
				a[s[0].charAt(0)-'A'][1]=-1;
		}
		preoder(0);
		System.out.println();
		inoder(0);
		System.out.println();
		postoder(0);
	}
	private static void postoder(int n) {
		if(n==-1)
			return;
		postoder(a[n][0]);
		postoder(a[n][1]);
		System.out.print((char)(n+'A'));
		
	}
	private static void inoder(int n) {
		if(n==-1)
			return;
		inoder(a[n][0]);
		System.out.print((char)(n+'A'));
		inoder(a[n][1]);
	}
	public static void preoder(int n) {
		if(n==-1)
			return;
		System.out.print((char)(n+'A'));
		preoder(a[n][0]);
		preoder(a[n][1]);
	}
}

//숏코딩
class Main {
	static char[][] tree = new char[26][2];
	static String[] ans = new String[3];

	public static void main(String[] args) {
		ans[0] = ""; ans[1] = ""; ans[2] = "";
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int idx = sc.next().charAt(0) - 'A';
			tree[idx][0] = sc.next().charAt(0);
			tree[idx][1] = sc.next().charAt(0);
		}
		getAns('A');
		System.out.println(ans[0]);
		System.out.println(ans[1]);
		System.out.println(ans[2]);
	}

	static void getAns(char c) {
		if (c == '.') return;
		ans[0] += c; 
		getAns(tree[c - 'A'][0]);
		ans[1] += c; 
		getAns(tree[c - 'A'][1]);
		ans[2] += c; 
	}
}