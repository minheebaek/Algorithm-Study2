import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] a = new int[201];
		
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			a[Integer.parseInt(s[i])+100]++;
		}
		System.out.println(a[Integer.parseInt(br.readLine())+100]);

	}
}