import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt=0;
		String[] s;
		while(N-->0){
			s  = br.readLine().split(" ");
			Deque<Character> q = new LinkedList<>();
			for(char i: s[0].toCharArray()) {
				if(q.isEmpty())
					q.offerLast(i);
				else {
					if(q.peekLast()==i)
						q.pollLast();
					else
						q.offerLast(i);
				}
			}
			int prevsize = q.size();
			while(q.size()>1){
				if(q.peekFirst()==q.peekLast()) {
					q.pollFirst();
					q.pollLast();
				}
				if(prevsize==q.size())
					break;
				else
					prevsize=q.size();
					
			}
			if(q.isEmpty())
				cnt++;
		}
		System.out.println(cnt);
	}
}