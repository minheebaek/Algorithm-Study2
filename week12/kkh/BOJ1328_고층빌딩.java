import java.util.*;
import java.io.*;

class Main {
	static int N,L,R;
	static long dp[][][],mod=1000000007;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		N = Integer.parseInt(s[0]);
		L = Integer.parseInt(s[1]);
		R = Integer.parseInt(s[2]);
		
		dp = new long[N+1][N+1][N+1];
		dp[1][1][1]=1;
		
		for(int i=2;i<=N;i++) {
			for(int j=1;j<=L;j++) {
				for(int k=1;k<=R;k++) {
					dp[i][j][k]= (dp[i-1][j][k]*(i-2)+dp[i-1][j-1][k]+dp[i-1][j][k-1])%mod;
				}
			}
		}
		System.out.println(dp[N][L][R]);
	}
}