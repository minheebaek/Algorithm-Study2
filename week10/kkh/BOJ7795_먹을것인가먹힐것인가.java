import java.util.*;
import java.io.*;
public class Main {
	static int N,M;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[] a = new int[N];
			int[] b = new int[M];
			
			s = br.readLine().split(" ");
			for(int i=0;i<N;i++)
				a[i]=Integer.parseInt(s[i]);
			s = br.readLine().split(" ");
			for(int i=0;i<M;i++)
				b[i]=Integer.parseInt(s[i]);
			
			Arrays.sort(a);
			Arrays.sort(b);
			
			int cnt = 0;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(a[i]>b[j])
						cnt++;
					else
						break;
				}
			}
			System.out.println(cnt);
		}
	}
}