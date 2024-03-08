//시간초과
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());//탑의 수 N
		int[] a = new int[N+1];
		
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			a[i+1]=Integer.parseInt(s[i]);
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=i-1;j>=0;j--) {
				if(a[i]<=a[j]) {
					sb.append(j+" ");
					break;
				}
				if(j==0) {
					sb.append("0 ");
				}
			}
		}
		System.out.println(sb.toString());
	}
}

//메모리 초과
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());//탑의 수 N
		int[] a = new int[N+1];
		int[] high = new int[100_000_001];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			a[i+1]=Integer.parseInt(s[i]);
		}
		
		for(int i=1;i<=N;i++) {
			sb.append(high[a[i]]+" ");
			Arrays.fill(high, 1,a[i],i);
		}
		System.out.println(sb.toString());
	}
}

//스택사용
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());//탑의 수 N
		Stack<int[]> stack = new Stack<>(); 
		String[] s = br.readLine().split(" ");
		
		stack.push(new int[]{1,Integer.parseInt(s[0])});
		sb.append("0 ");
		for(int i=1;i<N;i++) {
			
			while(!stack.isEmpty() &&
					stack.peek()[1]<Integer.parseInt(s[i])) {
				stack.pop();
			}
			if(stack.isEmpty())
				sb.append("0 ");
			else
				sb.append(stack.peek()[0]+" ");
			stack.push(new int[]{i+1,Integer.parseInt(s[i])});
			
		}
		System.out.println(sb.toString());
	}
}

//숏코딩
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			for(int j=i-1 ; j > 0;) {
				if(arr[j] > arr[i]) { // i타워의 레이저가 j타워(이전타워)가 수신하는지
					dp[i] = j;
					break;
				}
				j = dp[j]; // 이전타워(j)를 수신한 타워를 j로 변경
			}
			sb.append(dp[i]+" ");
		}	
		System.out.println(sb);
	}
}