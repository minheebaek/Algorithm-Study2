public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int result =0;
		int n =0;
		while(K-->0) {
			n = Integer.parseInt(br.readLine());
			if(n==0)
				result-=stack.pop();
			else
				result+=stack.push(n);
		}
		System.out.println(result);
	}
}