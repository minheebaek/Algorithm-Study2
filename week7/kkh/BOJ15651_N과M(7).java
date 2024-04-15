import java.io.*;
import java.util.*;


public class Main {
	static int N,M;
	static List<Integer> a;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		a = new LinkedList<>();
		for(int i=0;i<N;i++)
			a.add(Integer.parseInt(s[i]));
		Collections.sort(a);
		recursive(M,"");
		System.out.print(sb);
	}
	static void recursive(int m,String k) {
		if(m==0) {
			sb.append(k+"\n");
			return;
		}
		for(int i=0;i<a.size();i++) {
			String str = k+a.get(i)+" ";
			recursive(m-1,str);
		} 
	}
}