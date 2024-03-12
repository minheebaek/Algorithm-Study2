//98% 틀림
public class Main {
	public static int root;
	public static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new List[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(s[i]) == -1) {
				root = i;
				continue;
			}
			adj[Integer.parseInt(s[i])].add(i);
		}

		int remove = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				if (adj[i].get(j) == remove) {
					adj[i].remove(j);
					break;
				}
			}
		}
		if (remove == root)
			System.out.println("0");
		else
			System.out.println(dfs());
	}

	public static int dfs() {
		int refcnt = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(root);
		while (!st.isEmpty()) {
			int now = st.pop();
			for (int i : adj[now]) {
				if (adj[i].isEmpty()) {
					refcnt++;
					continue;
				} else
					st.push(i);
			}
		}
		return refcnt;
	}
}

//반례보면서 통과 ( 루트만있을때도 리프노드는 1 )
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	public static int root;
	public static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		adj = new List[N];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			if (Integer.parseInt(s[i]) == -1) {
				root = i;
				continue;
			}
			adj[Integer.parseInt(s[i])].add(i);
		}

		int remove = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < adj[i].size(); j++) {
				if (adj[i].get(j) == remove) {
					adj[i].remove(j);
					break;
				}
			}
		}
		if (remove == root)
			System.out.println("0");
		else
			System.out.println(dfs());
	}

	public static int dfs() {
		int refcnt = 0;
		Stack<Integer> st = new Stack<Integer>();
		st.push(root);
		if (adj[st.peek()].size() == 0)
			return 1;
		while (!st.isEmpty()) {
			int now = st.pop();
			for (int i : adj[now]) {
				if (adj[i].isEmpty()) {
					refcnt++;
					continue;
				} else
					st.push(i);
			}
		}
		return refcnt;
	}
}

//숏코딩
import java.util.*;

public class Main {
	static boolean[][] tree;
	static int ans, n, root;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		tree = new boolean[n][n];
		for (int child = 0; child < n; child++) {
			int parent = sc.nextInt();
			if (parent == -1) root = child;
			else tree[parent][child] = true;
		}
		int delete = sc.nextInt();
		for (int i = 0; i < n; i++) {
			tree[i][delete] = false;
		}
		ans = 0;
		if (delete != root)
			dfs(root);
		System.out.println(ans);
	}
	static void dfs(int idx) {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (tree[idx][i]) dfs(i);
			else cnt++;
		}
		if (cnt == n) ans++;
	}
}