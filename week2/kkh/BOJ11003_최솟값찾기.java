//시간초과
import java.io.*;
import java.util.*;

public class Main {
	public static Deque<Integer> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		
		int[] D = new int [N];
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
		s= br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(s[i]);
			q.offer(new int[] {now,i});
			while(q.peek()[1]<=i-L)
				q.poll();
			sb.append(q.peek()[0]+" ");
		}
		System.out.println(sb);
	}
}

//br.readLine().split(" ")을 StringTokenizer st = new StringTokenizer(br.readLine()) 바꿔야
// 시간초과안걸림..
import java.io.*;
import java.util.*;

public class Main {
	public static Deque<Integer> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int L = Integer.parseInt(s[1]);
		int[] D = new int [N];
		Deque<int[]> q = new LinkedList<>();
		//s= br.readLine().split(" ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(st.nextToken());
			while(!q.isEmpty() && q.peekLast()[0]>now)
				q.pollLast();
			q.offerLast(new int[] {now,i});
			while(q.peekFirst()[1]<=i-L)
				q.pollFirst();
			sb.append(q.peek()[0]+" ");
		}
		System.out.println(sb);
	}
}