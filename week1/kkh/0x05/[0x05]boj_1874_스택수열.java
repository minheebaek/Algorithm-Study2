import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int now =0;
		boolean isPossible = true;
		while(N-->0) {
			int n = Integer.parseInt(br.readLine());
			while(now<n) {
				stack.push(++now);
				sb.append("+\n");
			}
			if(stack.peek()==n) {
				stack.pop();
				sb.append("-\n");
			}
			else {
				isPossible =false;
				break;
			}
		}
		
		if(isPossible) {
			System.out.println(sb.toString());
		}
		else
			System.out.println("NO");
	}
}