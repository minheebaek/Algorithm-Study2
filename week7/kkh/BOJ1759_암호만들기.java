public class Main {
	static int L,C;
	static List<Character> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		L = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		list = new LinkedList<>();
		s =br.readLine().split(" ");
		for(int i=0;i<C;i++) {
			list.add(s[i].charAt(0));
		}
		Collections.sort(list);
		recursive(L, list, "");
		sb.append("\n");
		System.out.println(sb);
	}
	public static void recursive(int cnt, List<Character> list, String str ) {
		if(cnt ==0) {
			if(new String(str).replaceAll("[^aeiou]","").length() >= 1 && 
					new String(str).replaceAll("[aeiou]","").length() >= 2 )
				sb.append(str+"\n");
			return;
		}
		for(int i=0; i<list.size(); i++) {
			if(!( str.equals("") || str.charAt(str.length()-1)-'0' < list.get(i)-'0'))
				continue;
			List<Character> tmp = new LinkedList<>(list);
			char c = tmp.get(i);
			tmp.remove(i);
			recursive(cnt-1,tmp,str+c);
		}
	}
}

//숏코딩
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int L,C;
	static char[] munja;
	
	static void bt(int idx, int moum, int jaum, String amho) {
		if(moum+jaum==L) { //base case
			if(moum>=1&&jaum>=2) System.out.println(amho); //조건 만족시 출력
			return;
		}
		
		for(int i=idx; i<C; i++) {
			if(munja[i]=='a'||munja[i]=='e'||munja[i]=='i'||munja[i]=='o'||munja[i]=='u') {
				bt(i+1, moum+1, jaum, amho+munja[i]);
			}
			else {
				bt(i+1, moum, jaum+1, amho+munja[i]);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt();
		
		munja = new char[C];
		for(int i=0; i<C; i++) {
			munja[i] = sc.next().charAt(0);
		}
		
		Arrays.sort(munja);
		
		bt(0, 0, 0, "");
	}

}

//숏코딩
public class Main {
	static int n,k;
	static int vowelCnt;
	static char[] list, arr;
	
	static void f(int idx, int cnt) {
		if (cnt==k) {
			if (vowelCnt>=1 && k-vowelCnt>=2)
				System.out.println(new String(list));
			return;
		}

		if (idx==n) return;
		
		for (int i=idx; i<n; ++i) {
			list[cnt]=arr[i];
			boolean isVowel = "aeiou".indexOf(arr[i])!=-1;
			if (isVowel) ++vowelCnt;
			f(i+1, cnt+1);
			if (isVowel) --vowelCnt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		k = sc.nextInt();
		n = sc.nextInt();

		list = new char[k];
		arr = new char[n];

		for (int i=0; i<n; ++i)
			arr[i] = sc.next().charAt(0);
		Arrays.sort(arr);
		
		f(0,0);
	}

}