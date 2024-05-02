import java.io.*;

public class Main {
	static int N,A[]=new int[1_000_000*2+1];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++)
			A[Integer.parseInt(br.readLine())+1000000]++;
		
		int index=0;
		while(N>0) {
			if(A[index]>0)
				for(int i=0;i<A[index];i++) {
					sb.append(index-1000000).append("\n");
					N--;
				}
			index++;
		}
		System.out.println(sb);
	}
}