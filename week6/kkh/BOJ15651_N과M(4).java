import java.io.*;
import java.util.*;


public class Main {
	static int N,M;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		recursive(Integer.parseInt(s[0]),Integer.parseInt(s[1]),"");
		System.out.print(sb);
	}
	static void recursive(int n,int m,String k) {
		if(m==0) {
			sb.append(k+"\n");
			return;
		}
		for(int i=1;i<=n;i++) {
			if(!(k.equals("") || (k.charAt(k.length()-2)-'0')<=i))
				continue;
			recursive(n,m-1,k+i+" ");
		} 
	}
}