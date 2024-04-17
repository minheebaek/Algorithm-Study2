import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static List<Integer> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] s = br.readLine().split(" ");
			if(s[0].equals("0")) break;
			N = Integer.parseInt(s[0]);
			list = new LinkedList<>();
			for(int i=1;i<=N;i++) {
				list.add(Integer.parseInt(s[i]));
			}
			recursive(6, list, "");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void recursive(int cnt, List<Integer> list, String str ) {
		if(cnt ==0) {
			sb.append(str+"\n");
			return;
		}
		for(int i=0; i<list.size(); i++) {
			String[] s = str.split(" ");
			if(!( str.equals("") || Integer.parseInt(s[s.length-1].trim()) < list.get(i)))
				continue;
			List<Integer> tmp = new LinkedList<>(list);
			int n = tmp.get(i);
			tmp.remove(i);
			recursive(cnt-1,tmp,str+n+" ");
		}
	}
}

//숏코딩
public class Main {
	static int n,arr[],ans[];
	public static void main(String[] args) {
	Scanner	sc =new Scanner(System.in);
	while(true) {
		n=sc.nextInt();
		if(n==0) break;
		arr=new int[n];
		ans=new int[n];
		for (int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		dfs(0,0);
		System.out.println();
	}
}
	static void dfs(int cnt, int start) {
		if(cnt==6) {
			for(int i=0;i<6;i++) {
				System.out.print(ans[i]+" ");
			}System.out.println();
		}
		else {
				for(int i=start;i<n;i++)
				{
					ans[cnt]=arr[i];
					dfs(cnt+1,i+1);
				}
			}
	}
}