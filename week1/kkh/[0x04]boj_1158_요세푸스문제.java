import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		//(N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>
		int index = 0;
		int tmp = N;
		List<Integer> list = new LinkedList<>();
		List<Integer> result = new ArrayList<>();
		for(int i=1;i<=N;i++)
			list.add(i);
		while(tmp-->0) {
			index+=(K-1);
			if(index >= list.size())
				index%=list.size();
			result.add(list.get(index));
			list.remove(index);
		}
		
		
		System.out.print("<");
		for(int i=0;i<result.size();i++) {
			System.out.print(result.get(i));
			if(i!=result.size()-1)
				System.out.print(", ");
		}
		System.out.print(">");
	}
}