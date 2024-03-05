import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] result = new int[26];
		
		for(int i=0;i<s.length();i++) {
			result[s.charAt(i)-'a']++;
		}
		
		for(int i=0;i<result.length;i++) {
			System.out.print(result[i]+" ");
		}
	}
}