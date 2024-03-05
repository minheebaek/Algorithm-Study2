import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 =br.readLine();
		String s2 =br.readLine();
		
		int cnt = 0;
		
		int[] a1 = new int[26];
		int[] a2 = new int[26];
		
		for(int i=0;i<s1.length();i++) {
			a1[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<s2.length();i++) {
			a2[s2.charAt(i)-'a']++;
		}
		
		for(int i=0;i<a1.length;i++) {
			if(a1[i]!=a2[i]) {
				cnt += Math.abs(a1[i]-a2[i]);
			}
		}
		
		System.out.println(cnt);
	}
}