//61% 시간초과
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		String[] s1 = new String[N];
		for(int i=0;i<N;i++) {
			s1[i]= br.readLine();
		}
		int cnt = 0;
		for(int i=0;i<M;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				if(s1[j].contains(str)) {
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}

// Trie자료구조, 예제1의 baekjoon이 baekjoononlinejudge에 포함된다고 생각했었는데
// 정확히같아야지 카운트
import java.io.*;

public class Main {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		Node trie = new Node();
		String str;
		
		for(int i=0;i<N;i++) {
			str = br.readLine();
			Node now = trie;
			for(int j=0;j<str.length();j++) {
				if(now.next[str.charAt(j)-'a']==null)
					now.next[str.charAt(j)-'a']=new Node();
				now = now.next[str.charAt(j)-'a'];
				if(j==str.length()-1)
					now.isEnd=true;
			}
		}
		int cnt = 0;
		for(int i=0;i<M;i++) {
			str = br.readLine();
			Node now = trie;
			for(int j=0;j<str.length();j++) {
				if(now.next[str.charAt(j)-'a']==null)
					break;
				now = now.next[str.charAt(j)-'a'];
				if(j==str.length()-1 && now.isEnd)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}

class Node {
	Node[] next;
	boolean isEnd;
	Node(){
		next = new Node[26];
		isEnd = false;
	}
}

//숏코딩
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), cnt = 0;
		Set<String> set = new HashSet<>();
		while(n-->0) set.add(sc.next());
		while(m-->0) cnt += set.contains(sc.next()) ? 1 : 0;
		System.out.print(cnt);
	}
}