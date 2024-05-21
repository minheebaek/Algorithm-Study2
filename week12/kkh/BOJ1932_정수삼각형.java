import java.util.*;
import java.io.*;

class Main {
	static int N;
	public static void main(String[]Z) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] a = new int[N+1][N];
		int[][] max = new int[N+1][N];
		String[] s;
		for(int i=1;i<=N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<s.length;j++)
				a[i][j]=Integer.parseInt(s[j]);
		}
		max[1][0]=a[1][0];
		for(int i=1;i<N;i++)
			for(int j=0;j<i;j++) {
				max[i+1][j]=Math.max(max[i+1][j], max[i][j]+a[i+1][j]);
				max[i+1][j+1]=Math.max(max[i+1][j+1], max[i][j]+a[i+1][j+1]);
			}

		System.out.println(Arrays.stream(max[N]).max().orElse(0));
	}
}

// 숏코딩 sort나 max값 로직없이 역으로

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int N [][] = new int[n][n];
		for (int i=0;i<n;i++) {
			for(int j=0; j<i+1;j++) {
				N[i][j] = scn.nextInt();	
			}
		}
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				N[i-1][j]+=Math.max(N[i][j],N[i][j+1]);
			}
		}
		System.out.println(N[0][0]);
	}
}