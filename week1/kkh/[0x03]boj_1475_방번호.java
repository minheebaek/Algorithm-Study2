import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] result = new int[9];
		int tmp =N;
		while(tmp>0) {
			int n= tmp%10;
			tmp/=10;
			if(n==9)
				n=6;
			result[n]++;
		}
		if(result[6]%2==0)
			result[6]/=2;
		else
			result[6] = result[6]/2+1;
		
		int max =Integer.MIN_VALUE;
		
		for(int n : result) {
			if(max<n)
				max =n;
		}
		
		System.out.println(max);
	}
}