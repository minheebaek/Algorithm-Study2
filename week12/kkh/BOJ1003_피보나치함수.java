import java.util.*;
import java.io.*;
public class Main {
	static int N, MAX=40;
	static Data[] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new Data[MAX+1];
		for(int i=0;i<=MAX;i++)
			dp[i]=new Data();
		dp[0].zero=1;
		dp[1].one=1;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			int N = Integer.parseInt(br.readLine());
			fibonacci(N);
			System.out.println(dp[N].zero+" "+dp[N].one);
		}
	}
	
	static Data fibonacci(int n) {
		if(dp[n].one==0 && dp[n].zero==0) {
			Data d1 = fibonacci(n-1);
		    Data d2 = fibonacci(n-2);
		    
		    dp[n].zero = d1.zero + d2.zero;
		    dp[n].one = d1.one + d2.one;
		}
	    return dp[n];
	}
}

class Data{
	int zero;
	int one;
	Data(){
		this.zero=0;
		this.one=0;
	}
}

// 숏코딩
import java.util.*;

class Main {
	public static void main(String[]Z) {
		Scanner S = new Scanner(System.in);
		int[] A = new int[41];
		A[0] = 0; A[1] = 1;
		for(int i = 1; i++ < 40;)
			A[i] = A[i-1] + A[i-2];
		for(int T = S.nextInt(); T-- > 0;) {
			int N = S.nextInt();
			System.out.println(N==0?"1 0":A[N-1]+" "+A[N]);
		}
	}
}

ex)
f(2) = f(1)+f(0)
f(3) = 2f(1) + f(0) = 3
f(4) = 3f(1) + 2f(0) = 5
f(5) = 5f(1) + 3f(0) = 8
f(6) = 8f(1) + 5f(0) = 13