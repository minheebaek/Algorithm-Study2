//세그먼트트리
import java.io.*;
import java.util.*;

public class Main {
	public static int[][] a;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		long N = Long.parseLong(s[0]);//N개의 수
		long M = Long.parseLong(s[1]);//M은 수의 변경이 일어나는 횟수
		long K = Long.parseLong(s[2]);//K는 구간의 합을 구하는 횟수
		
		int a = 2;
		int b = 1;
		while(a<N) {
			a *= 2;
			b++;
		}
		long[] t = new long[(int) Math.pow(2, b+1)];
		for(int i=(int) Math.pow(2, b);i<(int) Math.pow(2, b)+N;i++) {
			t[i]=Long.parseLong(br.readLine());
		}
		for(int i=t.length-1;i>0;i--) {
			t[i/2]+=t[i];
		}
		
		while(K>0) {
			s = br.readLine().split(" ");
			if(Long.parseLong(s[0])==1) {
				long prev = t[(int) ((long)Math.pow(2, b)+Long.parseLong(s[1])-1)];
				t[(int) ((int)Math.pow(2, b)+Long.parseLong(s[1])-1)]=Long.parseLong(s[2]);
				long cur = t[(int) ((int)Math.pow(2, b)+Long.parseLong(s[1])-1)];
				int now =(int) ((int)Math.pow(2, b)+Long.parseLong(s[1])-1);
				while((now /=2)>0) {
					t[now]+= cur-prev;
				}
				
			}else {
				long sum=0;
				long start = (int)Math.pow(2, b)+Long.parseLong(s[1])-1;
				long end = (int)Math.pow(2, b)+Long.parseLong(s[2])-1;
				
				while(start<=end) {
					if(start%2==1)
						sum+=t[(int) start];
					if(end%2==0)
						sum+=t[(int) end];
					start = (start+1)/2;
					end = (end-1)/2;
				}
				
				System.out.println(sum);
				K--;
			}
		}
	}
}

//숏코딩 펜윅트리
public class Main {
	static long[] tree;
	static int N, M, K;

	static void update(int i, long num) {
		while (i < N  +1) {
			tree[i] += num;
			i += (i & -i);
		}
	}

	static long sum(int i) {
		long ans = 0;
		while (i > 0) {
			ans += tree[i];
			i -= (i & -i);
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long[] num = new long[N + 1];
		tree = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(br.readLine());
			update(i, num[i]);
		}
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) {
				long dif = c - num[b];
				num[b] =c;
				update(b, dif);
			}
			else {
				System.out.println(sum((int)c) - sum(b - 1));
			}
		}

	}

}