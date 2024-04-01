//시간초과
import java.io.*;
import java.util.*;

public class Main {
	public static int T, N, result;
	public static int[] a;
	public static boolean[] visited, isCycle;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());//학생의 수
			isCycle = new boolean[N+1];
			a = new int[N+1];
			result = 0;
			String[] s = br.readLine().split(" ");
			for(int i=1;i<=N;i++) {
				a[i]=Integer.parseInt(s[i-1]);
				if(i==a[i]) { // 자기 자신을 가리키고있으면 
					isCycle[i]=true;
					result++;
				}
			}
			for(int i=1;i<=N;i++) {
				if(!isCycle[i])
					dfs(i);
			}
			System.out.println(N-result);
		}
	}
	
	public static void dfs(int s) {
		if(isCycle[s])
			return;
		Stack<Integer> st = new Stack<>();
		visited = new boolean[N+1];
		st.push(s);
		while(!st.isEmpty()) {
			int i = st.pop();
			visited[i]=true;
			if(visited[a[i]]) {
				Stack<Integer> st2 = new Stack<>();
				st2.push(a[i]);
				while(!st2.isEmpty()) {
					int j = st2.pop();
					isCycle[j]=true;
					result++;
					if(!isCycle[a[j]])
						st2.push(a[j]);
				}
			}
			if(!isCycle[a[i]])
				st.push(a[i]);
		}
	}
}
import java.io.*;
import java.util.*;

public class Main {
	public static int T, N, result;
	public static int[] a;
	public static boolean[] visited, done;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		while(T-->0) {
			N = Integer.parseInt(br.readLine());//학생의 수
			visited = new boolean[N+1];
			done = new boolean[N+1];
			a = new int[N+1];
			result = 0;
			String[] s = br.readLine().split(" ");
			for(int i=1;i<=N;i++) {
				a[i]=Integer.parseInt(s[i-1]);
			}
			for(int i=1;i<=N;i++) {
				if(!done[i])
					//dfs(i);
					dfsRec(i);
			}
			System.out.println(N-result);
		}
	}
	public static void dfsRec(int s) {
		if(done[s]) return; // 이전에 이미 검사했다는 뜻이므로 더 이상 들어갈 필요가 없다.
		if(visited[s]) { // 방문을 했었다 == 사이클 구성원이다
			done[s] = true; // 이제 다시 볼 일 없으므로 done 체크
			result++; // 사이클 구성원이므로 + 1
		}
		visited[s] = true; // 방문 체크
		dfsRec(a[s]);
		done[s] = true; // 사이클이 아닌 애들도 검사 끝났으니까 done 체크
		visited[s] = false; // 방문 체크한 거 초기화
	}
}
//숏코딩
public class Main {
	public static int T, N, result;
	public static int[] a;
	public static boolean[] visited, done;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=0;t<T;t++) {
            int N = sc.nextInt(),ans=0,temp=1;
            int[] arr = new int[N], parr = new int[N];
            for(int i=0;i<N;i++) arr[i] = sc.nextInt()-1;
            for(int i=0;i<N;i++) {
                if(parr[i]!=0) continue;
                int nowi =i,sttemp = temp; // parr:확인순서
                while(parr[nowi]==0){ // 루프
                    parr[nowi] = temp++;
                    nowi = arr[nowi];
                }
                if(parr[nowi]>sttemp) ans+=parr[nowi]-sttemp;
                else if(parr[nowi]==sttemp) continue;
                else ans+= temp-sttemp;
            }
            System.out.println(ans);
        }
	}
}
