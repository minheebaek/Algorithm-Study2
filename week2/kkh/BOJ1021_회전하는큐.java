import java.io.*;
import java.util.*;

public class Main {
	public static Deque<Integer> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);//큐의 크기 N
		int M = Integer.parseInt(s[1]);//뽑아내려고 하는 수의 개수 M
		int[] a = new int[M];
		s = br.readLine().split(" ");
		for(int i=0;i<M;i++)
			a[i]=Integer.parseInt(s[i]);

		q = new LinkedList<>();
		for(int i=1;i<=N;i++)
			q.offer(i);
		
		int result = 0;
		int min;
		for(int i=0;i<M;i++) {
			min =Integer.MAX_VALUE;
			int now = a[i];
			// 왼쪽으로든 오른쪽으론든 뽑아내려는 값까지 카운트한후 size의 반보다 작으면 최소 크면 size-카운트값이 최소가됨
			for(int j=0;j<q.size();j++) {
				if(q.peekFirst()==now) {
					min = Math.min(min, j);
					break;
				}
				q.offer(q.pop());
			}
			if(min>q.size()/2)
				min=q.size()-min;
			q.pop();
			result+=min;
		}
		System.out.println(result);
	}
}