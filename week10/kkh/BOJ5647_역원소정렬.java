// 입력에 빈라인이 있어서 코드추가 Numberformat 예외 확인
import java.util.*;
import java.io.*;
public class Main {
	static int N=0; 
	static long a[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<>();
		String[] s;
		do {
			s = br.readLine().split(" ");
			for(String str : s) {
				if(str.equals(""))
					continue;
				if(N!=0)
					list.add(str);
				else
					N = Integer.parseInt(str);
			}
		}while(list.size()<N);
		a = new long[N];
		for(int i=0;i<N;i++) {
			String tmp = new StringBuilder(list.get(i)).reverse().toString();
			a[i]=Long.parseLong(tmp);
		}
		Arrays.sort(a);
		for(long i : a)
			sb.append(i).append("\n");
		System.out.println(sb);
	}
}