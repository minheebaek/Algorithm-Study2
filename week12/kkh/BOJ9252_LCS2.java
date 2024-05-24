import java.util.*;
import java.io.*;

class Main {
	static String s1,s2,result;
	static int n;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s1 = br.readLine();
		s2 = br.readLine();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++) {
			for(int j=1;j<=s2.length();j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1))
					dp[i][j]=dp[i-1][j-1]+1;
				else
					dp[i][j]=Math.max(dp[i][j-1], dp[i-1][j]);	
			}
		}
		
		n = dp[s1.length()][s2.length()];
		System.out.println(n);
		if(s1.length()==0 || s1.length()==0)
			return;
		int x=s1.length();
		int y=s2.length();
		result="";
		while(n>0) {
			if(s1.charAt(x-1)==s2.charAt(y-1)) {
				result+=s1.charAt(x-1);
				x--;y--;
				n--;
			}else {
				if(dp[x][y-1]>dp[x-1][y]) {
					y--;
				}else {
					x--;
				}
			}
		}
		StringBuilder sb = new StringBuilder(result);
		sb.reverse();
		System.out.println(sb);
	}
}