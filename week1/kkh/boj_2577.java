import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] number = new int[3];
		long n =1L;
		int[] result = new int[10];
		for(int i=0;i<number.length;i++) {
			number[i]=Integer.parseInt(br.readLine());
			n *=number[i];
		}
		
		long tmp = n;
		while(tmp>0) {
			int t = (int) (tmp%10);
			tmp /= 10;
			result[t]++;
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}