import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String s;
		while (N-- > 0) {
			Stack<Character> st = new Stack<>();
			char[] c = br.readLine().toCharArray();
			for (int i = 0; i < c.length; i++) {
				if (st.isEmpty() || c[i] == '(')
					st.push(c[i]);
				else {
					if (st.peek() == c[i])
						st.push(c[i]);
					else
						st.pop();
				}
			}
			if (st.size() == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}