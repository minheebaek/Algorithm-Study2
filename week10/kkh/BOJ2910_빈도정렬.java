import java.util.*;
import java.io.*;
public class Main {
	static int N,C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		Map<Integer,Integer> map = new LinkedHashMap<>();
		s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int key = Integer.parseInt(s[i]);
			if(map.get(key)==null)
				map.put(key, 1);
			else
				map.put(key, map.get(key)+1);
		}
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
		
		Collections.sort(list,(a,b)->b.getValue()-a.getValue());
		
		for(Map.Entry<Integer, Integer> entry : list)
			for(int i=0;i<entry.getValue();i++)
				sb.append(entry.getKey()).append(" ");
		System.out.println(sb);
	}
}