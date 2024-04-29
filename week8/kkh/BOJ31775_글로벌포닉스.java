import java.io.*;
import java.util.*;

public class Main {
	static String[] s;
	static int[] a;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = new String[3];
		a = new int[3];
		for(int i=0;i<3;i++) {
			s[i] = br.readLine();
			if(s[i].charAt(0)=='l') a[0]++;
			else if(s[i].charAt(0)=='k') a[1]++;
			else if(s[i].charAt(0)=='p') a[2]++;
		}
		String result = "GLOBAL";
		for(int i=0;i<3;i++)
			if(a[i]==0) {
				result="PONIX";
				break;
			}
		System.out.println(result);
	}
}