import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		
		Stack<Character> st = new Stack<>();
		int curStic =0; // 현재 막대기 수
		int cnt = 0; // 잘려진 막대기 수
		for(int i=0;i<c.length;i++) {
			
			if(c[i]=='('){
				curStic++;
			}
			else if(c[i]==')' && st.peek()=='(') {
				curStic--;
					cnt+=curStic;
			}else{
				curStic--;
				cnt++;
			}
			st.push(c[i]);
		}
		System.out.println(cnt);
	}
}