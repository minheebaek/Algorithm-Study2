import java.io.*;
import java.util.*;


public class Main {
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	static int L = 5, result =0;
	static char[][] a = new char[L][L];
	static List<Integer> list = new LinkedList<>();
	static boolean[][] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<L;i++) {
			String s = br.readLine();
			for(int j=0;j<L;j++) {
				a[i][j]=s.charAt(j);
				list.add(i*L+j);
			}
		}
		pickSeven(0,list, "");
		
		System.out.println(result);
	}
	public static void pickSeven(int cnt, List<Integer> list, String str) {
		if(cnt == 7) {
			String[] s = str.trim().split(" ");
			int cntS = 0;
			for(int i=0;i<s.length;i++) {
				int n =Integer.parseInt(s[i]);
				if(a[n/L][n%L]=='S')cntS++;
			}
			if(cntS>=4 && bfs(str))
				result++;
			return;
		}
		for(int i=0;i<list.size();i++) {
			String[] s = str.trim().split(" ");
			if(!( str.equals("") || Integer.parseInt(s[s.length -1]) < list.get(i)))
				continue;
			List<Integer> tmp = new LinkedList<>(list);
			int n = tmp.get(i);
			tmp.remove(i);
			pickSeven(cnt+1,tmp,str+n+" ");
		}
	}
	public static boolean bfs(String str) {
		visited = new boolean[L][L];
		String[] s = str.trim().split(" ");
		int n = Integer.parseInt(s[0]);
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {n/5,n%5});
		visited[n/5][n%5]=true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] xy = q.poll();
			int x = xy[0];
			int y = xy[1];
			cnt++;
			if(cnt==7) {
				return true;
			}
			for(int i=0;i<4;i++) {
				int nx = dx[i]+x;
				int ny = dy[i]+y;
				
				if( nx<0 || ny<0 || nx>=L || ny>=L)
						continue;
				if(!visited[nx][ny]) {
					for(int j=1;j<s.length;j++) {
						n =Integer.parseInt(s[j]);
						if(nx == n/L && ny == n%L) {
							q.offer(new int[] {nx,ny});
							visited[nx][ny]=true;
							break;
						}
					}
				}
			}
		}
		return false;
	}
}

// 숏코딩
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int Y, result, numbers[];
	static char map[][];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		numbers = new int[7];
		map = new char[5][];

		for (int i = 0; i < 5; i++)
			map[i] = br.readLine().toCharArray();
		recur(0, 0);
		System.out.println(result);
	}

	private static void recur(int cnt, int start) {
		if (cnt == 7) {
			if (isConnected())
				result++;
			return;
		}
		for (int i = start; i < 25; i++) {
			numbers[cnt] = i;
			char c = map[i / 5][i % 5];
			if (c == 'Y') {
				if (Y == 3)
					continue;
				else
					Y++;
			}
			recur(cnt + 1, i + 1);
			if (c == 'Y')
				Y--;
		}
	}

	private static boolean isConnected() {
		visited = new boolean[7];
		dfs(0);
		for (int i = 0; i < 7; i++)
			if (!visited[i])
				return false;
		return true;
	}

	private static void dfs(int i) {
		visited[i] = true;
		for (int j = 0; j < 7; j++)
			if (!visited[j] && Math.abs(numbers[i] % 5 - numbers[j] % 5) + Math.abs(numbers[i] / 5 - numbers[j] / 5) == 1)
				dfs(j);
	}
}