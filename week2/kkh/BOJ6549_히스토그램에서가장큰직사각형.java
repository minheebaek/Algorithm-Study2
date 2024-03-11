// 8% 메모리초과..
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s;
		while(true) {
			s= br.readLine().split(" ");
			if(Integer.parseInt(s[0])==0)
				break;
			int N = Integer.parseInt(s[0]);
			int[] h = new int[N+1];
			int max=0;
			for(int i=1;i<=N;i++) {
				h[i]=Integer.parseInt(s[i]);
				if(max<h[i]) max=h[i];
			}
			int[][] area=new int[max+1][2];
			
			Stack<Integer> st = new Stack<>();
			
			for(int i=1; i<=N;i++) {
				//
				if(st.isEmpty()) {
					area[h[i]][1]=h[i];
					area[h[i]][0]=Math.max(area[h[i]][0], area[h[i]][1]);
					st.push(h[i]);
				}else {
					if(st.peek()<h[i]) {
						area[st.peek()][1]+=st.peek();
						area[st.peek()][0]=Math.max(area[st.peek()][0],area[st.peek()][1]);
						area[h[i]][1]=h[i];
						area[h[i]][0]=Math.max(area[h[i]][0],area[h[i]][1]);
						st.push(h[i]);
					}else if(st.peek()==h[i]){
						area[st.peek()][1]+=st.peek();
						area[st.peek()][0]=Math.max(area[st.peek()][0],area[st.peek()][1]);
						st.push(h[i]);
					}else {
						area[h[i]][1]=h[i];
						area[h[i]][0]=Math.max(area[h[i]][0],area[h[i]][1]);
						st.push(h[i]);
					}
				}
			}
			
			int result =0;
			for(int i=0;i<area.length;i++) {
				if(result<area[i][0])
					result=area[i][0];
			}
			System.out.println(result);
		}
	}
}

//문제를 읽고 로직이 생각이 안나 구글링을 하였다. 모노스택관련 문제를 더 풀어보면서 익숙해져야될같다. 주석과 출처를 통해 문제풀이를 대신하겠다
import java.io.*;
import java.util.*;

public class Main {
	public static int[] a;
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N;
		String[] s;
		while(true) {
			s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			if(N == 0)
				break;
			a = new int[N];
			for(int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(s[i+1]);
			}
			sb.append(getArea(N)).append('\n');
			a = null;
			
		}
		System.out.println(sb);
	}
	public static long getArea(int len) {
		Stack<Integer> stack = new Stack<Integer>();
		long maxArea = 0;
		for(int i = 0; i < len; i++) {

			while((!stack.isEmpty()) && a[stack.peek()] >= a[i]) {
				int height = a[stack.pop()];	// 이전 체인의 높이

				long width = stack.isEmpty() ? i : i - 1 - stack.peek(); 
				
				maxArea = Math.max(maxArea, height * width);	// 최대 넓이 값 갱신
			}
			stack.push(i);
		}

        while(!stack.isEmpty()) {
            int height = a[stack.pop()];
            
            long width = stack.isEmpty() ? len: len - 1 - stack.peek();
            maxArea = Math.max(maxArea, width * height);
        }
		
        return maxArea;	
	}
}