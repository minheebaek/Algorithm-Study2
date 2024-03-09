//시간초과
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		//오큰수 NGE(i) : Ai의 오큰수는 오른쪽에 있으면서 Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 
		//그러한 수가 없는 경우에 오큰수는 -1이다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] NGE = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(s[i]);
		}	
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				if(a[i]<a[j]) {
					NGE[i]=a[j];
					break;
				}
			}
			if(NGE[i]==0)
				NGE[i]=-1;
		}	
		for(int i : NGE) {
			sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
}

// 모노스택 index를 넣어서 처리, 문제보고 로직생각하기 어려움..
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] NGE = new int[N];
		String[] s = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			a[i]=Integer.parseInt(s[i]);
		}
		
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0;i<N;i++) {
			while(!st.isEmpty() && a[st.peek()]<a[i]) {
				NGE[st.pop()]=a[i];
			}
			st.push(i);
		}
		while(!st.isEmpty()) {
			NGE[st.pop()]=-1;
		}
		
		
		for(int i : NGE) {
			sb.append(i+" ");
		}
		System.out.println(sb.toString());
	}
}