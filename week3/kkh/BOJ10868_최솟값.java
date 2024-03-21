//세그먼트트리
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		int a = 2;
		int b = 1;
		while(a<N) {
			a *=2;
			b++;
		}
		int pow = (int)Math.pow(2, b);
		int[] tree = new int[pow*2];
		Arrays.fill(tree, Integer.MAX_VALUE);
		for(int i=pow;i<pow+N;i++) {
			tree[i]=Integer.parseInt(br.readLine());
		}
		for(int i=tree.length-1;i>0;i--)
			tree[i/2]=Math.min(tree[i/2], tree[i]);
		
		while(M-->0) {
			s = br.readLine().split(" ");
			int start =Integer.parseInt(s[0])-1+pow;
			int end =Integer.parseInt(s[1])-1+pow;
			int min = Integer.MAX_VALUE;
			while(start<=end) {
				if(start%2==1) min =Math.min(min,tree[start]);
				if(end%2==0) min =Math.min(min,tree[end]);
				start = (start+1)/2;
				end = (end-1)/2;
			}
			System.out.println(min);
		}
	}
}