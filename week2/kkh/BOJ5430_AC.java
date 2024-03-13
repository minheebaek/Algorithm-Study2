// 시간초과 아마도 리버스때문일듯
import java.io.*;
import java.util.*;

public class Main {
	public static Deque<Integer> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			char[] func = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<Integer>();
			char[] tmp = br.readLine().toCharArray();
			int index = 0;
			while(q.size()!=N) {
				if(tmp[index]>='0' && tmp[index]<='9')
					q.offer(tmp[index]-'0');
				index++;
			}
			
			for(int i=0;i<func.length;i++) {
				if(func[i]=='R') {
					List<Integer> list = new ArrayList<>(q);
					Collections.reverse(list);
					q = new LinkedList<>(list);
				}
				else {//D
					if(q.isEmpty())
						break;
					q.poll();
				}
			}
			
			if(q.isEmpty())
				sb.append("error\n");
			else {
				sb.append("[");
				while(!q.isEmpty()) {
					sb.append(q.poll());
					if(!q.isEmpty())
						sb.append(",");
				}
			sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}

// 입력받는 숫자는 최대100 비어있어도 D함수를 쓰지않으면 []
import java.io.*;
import java.util.*;

public class Main {
	public static Deque<Integer> q;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N;
		int T = Integer.parseInt(br.readLine());
		while(T-->0) {
			boolean isback = false;
			boolean iserror = false;
			char[] func = br.readLine().toCharArray();
			N = Integer.parseInt(br.readLine());
			Deque<Integer> q = new LinkedList<Integer>();
			String tmp = br.readLine();
			int index = 0;
			while(q.size()!=N) {
				String s ="";
				while(true) {
					if(tmp.charAt(index)>='0' && tmp.charAt(index)<='9') {
						s += tmp.charAt(index++);
					}
					else {
						if(s!="")
							q.offer(Integer.parseInt(s));
						index++;
						break;
					}
				}	
			}
			for(int i=0;i<func.length;i++) {
				if(func[i]=='R') {
					isback = !isback;
				}
				else {//D
					if(q.isEmpty()) {
						iserror = true;
						break;
					}
					if(isback)
						q.pollLast();
					else
						q.pollFirst();
				}
			}
			
			if(iserror)
				sb.append("error\n");
			else {
				sb.append("[");
				while(!q.isEmpty()) {
					int result;
					if(isback)
						result=q.pollLast();
					else
						result=q.pollFirst();
					sb.append(result);
					if(!q.isEmpty())
						sb.append(",");
				}
			sb.append("]\n");
			}
		}
		System.out.println(sb);
	}
}