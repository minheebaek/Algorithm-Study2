import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int K = Integer.parseInt(s[2]);
		int mod = 1_000_000_007;
		int a = 2;
		int b = 1;
		while(a<N) {
			a *=2;
			b++;
		}
		int pow = (int)Math.pow(2, b);
		long[] tree = new long[pow*2];
		Arrays.fill(tree, 1);
		for(int i=pow;i<pow+N;i++) {
			tree[i]=Long.parseLong(br.readLine());
		}
		for(int i=tree.length-1;i>0;i--)
			tree[i/2]= tree[i/2]*tree[i]%mod;
		
		while(K>0) {
			s = br.readLine().split(" ");
			int type = Integer.parseInt(s[0]);
			int start =Integer.parseInt(s[1])-1+pow;
			int end =Integer.parseInt(s[2])-1+pow;
			if(type==1) {
				tree[start] = Long.parseLong(s[2]);
				while((start/=2)>0)
					tree[start]=tree[start*2]*tree[start*2+1]%mod;
			}else {
				long result =1;
				while(start<=end) {
					if(start%2==1) result =result*tree[start]%mod;
					if(end%2==0) result =result*tree[end]%mod;
					start = (start+1)/2;
					end = (end-1)/2;
				}
				K--;
				System.out.println(result);
			}
		}
	}
}