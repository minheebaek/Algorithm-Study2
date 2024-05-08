import java.util.*;
import java.io.*;
public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for(int i=0;i<N;i++)
			set.add(br.readLine());
		List<String> list = new ArrayList<>(set);
		Collections.sort(list,(a,b)-> a.length()!=b.length()?a.length()-b.length():a.compareTo(b));
		
		for(String s : list)
			sb.append(s).append("\n");
		System.out.println(sb);
	}
}