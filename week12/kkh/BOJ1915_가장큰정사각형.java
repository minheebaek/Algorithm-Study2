// 시간초과 
import java.util.*;
import java.io.*;

class Main {
	static int n,m,map[][],l;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		map = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i][j]=str.charAt(j)-'0';
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(map[i][j]!=0)
					square(i,j);
			}
		}
		
		System.out.println(l*l);
	}
// 현재위치에서 오른쪽과 아래로 최대 정사각형을 찾는다
	static void square(int x,int y) {
		int tmp =1;
		while(true) {
			if(x+tmp >= n | y+tmp >= m)
				return;
			for(int i=x;i<=x+tmp;i++)
				if(map[i][y+tmp]==0)
					return;

			for(int i=y;i<y+tmp;i++)
				if(map[x+tmp][i]==0)
					return;

			tmp++;
			l=Math.max(l, tmp);
		}
	}
}

import java.util.*;
import java.io.*;

class Main {
	static int n,m,map[][],dp[][],l;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		
		map = new int[n+1][m+1];
		dp =  new int[n+1][m+1];
		
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<m;j++) {
				map[i+1][j+1]=str.charAt(j)-'0';
			}
		}
		// dp[i][j]가 dp[i-1][j-1]만큼 x축 y축 확인
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]==0)
					dp[i][j]=0;
				else {
					int k = 1;
					for(;k<=dp[i-1][j-1];k++) {
						if(map[i][j-k]==0 || map[i-k][j]==0)
							break;
					}
					dp[i][j]=k;
					l=Math.max(l, dp[i][j]);
				}
			}
		}
		
		System.out.println(l*l);
	}
}

// 숏코딩
import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[][] dp = new int[n + 1][m + 1];
		long max = 0;
		for(int i = 1; i <= n; i++) {
			String str = scan.next();
			for(int j = 1; j <= m; j++) {
				if(str.charAt(j - 1) - '0' == 0) continue;
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max * max);
	}
}