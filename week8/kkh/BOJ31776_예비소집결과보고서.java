import java.io.*;
import java.util.*;

public class Main {
	static String[] s;
	static int N,result=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			if(Integer.parseInt(s[0])==-1)continue;
			if(Integer.parseInt(s[1])==-1) {
				if(Integer.parseInt(s[1]) >= Integer.parseInt(s[2])) result++;
				continue;
			}		
			if(Integer.parseInt(s[2])==-1) {
				if(Integer.parseInt(s[0]) <= Integer.parseInt(s[1]))result++;
				continue;
			}
			if(Integer.parseInt(s[0]) <= Integer.parseInt(s[1]) &&
					Integer.parseInt(s[1]) <= Integer.parseInt(s[2]))result++;
				
		}
		System.out.println(result);
	}
}