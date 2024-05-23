import java.util.*;
import java.io.*;

class Main {
	static int N,result;
	static long dp[];
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new long[N+1];
		dp[0]=1;
		dp[1]=1;
		// N==1, 1
		// N==2, 10
		// N==3, 100, 101
		// N==4, 1000,1001,1010
		// N==5, 10000,10001,10010,10100,10101
		for(int i=2;i<N;i++)
			dp[i]=dp[i-1]+dp[i-2];
		
		System.out.println(dp[N-1]);
	}
}