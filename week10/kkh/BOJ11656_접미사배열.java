import java.util.*;
import java.io.*;
public class Main {
	static int N,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		List<String> list = new ArrayList<>();
		while(s.length()>0) {
			list.add(s);
			s = s.substring(1);
		}
		
		Collections.sort(list, (a,b)->a.compareTo(b));
		
		for(String str : list)
			sb.append(str).append("\n");
		System.out.println(sb);
	}
}