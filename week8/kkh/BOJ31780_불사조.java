import java.io.*;
import java.util.*;

public class Main {
	static String s[];
	static int X,M,result=0;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		s = br.readLine().split(" ");
		X = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		
		recursive(X,M);
		
		System.out.println(result);
	}
	static void recursive(int x, int m) {
		if(m<0)
			return;
		result+=x;
		recursive(x-x/2,m-1);
		recursive(x/2,m-1);
	}
}