// 시간초과
import java.util.*;
import java.io.*;

class Main {
	static int N,result;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		recursive(N,1);
		
		System.out.println(result%10007);
	}
	
	static void recursive(int n, int cnt) {
		if(n<=0) {
			result+=cnt;
			return;
		}
		// 한 타일만 사용할 경우
		recursive(n-1,cnt);
		// 두 타일만 사용할 경우
		if(n>=2)
			recursive(n-2,cnt*2);

	}
}

import java.util.*;
import java.io.*;

class Main {
	static int N,dp[],result;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N+1];
		dp[0]=1;
		dp[1]=3;
		
		for(int i=2;i<N;i++)
			dp[i]=(dp[i-1]%10_007+dp[i-2]*2%10_007)%10_007;
		
		System.out.println(dp[N-1]);
	}
}