import java.io.*;

// 런타임에러 ( s1과 s2의 길이가 같지 않을 경우가 있음 )
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean result;
		while(N>0) {
			String[] s = br.readLine().split(" ");
			String s1 = s[0];
			String s2 = s[1];
			int[] a1 = new int[26];
			int[] a2 = new int[26];
			
			for(int i=0;i<s1.length();i++) {
				a1[s1.charAt(i)-'a']++;
				a2[s2.charAt(i)-'a']++;
			}
			
			result = true;
			
			for(int i=0;i<a1.length;i++) {
				if(a1[i]!=a2[i]) {
					result=false;
					break;
				}
			}
			if(result)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
			N--;
		}
	}
}
// 수정
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		boolean result;
		while(N>0) {
			String[] s = br.readLine().split(" ");
			String s1 = s[0];
			String s2 = s[1];
			int[] a1 = new int[26];
			int[] a2 = new int[26];
			
			for(int i=0;i<s1.length();i++) {
				a1[s1.charAt(i)-'a']++;
			}
			for(int i=0;i<s2.length();i++) {
				a2[s2.charAt(i)-'a']++;
			}
			
			result = true;
			
			for(int i=0;i<a1.length;i++) {
				if(a1[i]!=a2[i]) {
					result=false;
					break;
				}
			}
			if(result)
				System.out.println("Possible");
			else
				System.out.println("Impossible");
			N--;
		}
	}
}