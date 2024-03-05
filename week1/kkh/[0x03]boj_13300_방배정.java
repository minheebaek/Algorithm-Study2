import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N=Integer.parseInt(s[0]);
		int K=Integer.parseInt(s[1]);
		
		int[][] stus = new int[2][7];

		for(int i=0; i<N;i++) {
			s= br.readLine().split(" ");
			stus[Integer.parseInt(s[0])][Integer.parseInt(s[1])]++;
		}
		
		int cnt =0;
		for(int i=0;i<2;i++) {
			for(int j=1;j<=6;j++) {
				cnt += stus[i][j]/K+(stus[i][j]%K==0?0:1);
			}
		}
		System.out.println(cnt);
	}
}