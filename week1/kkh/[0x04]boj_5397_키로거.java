// 시간초과
public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스(-), 화살표이다.
		while(T>0) {
			char[] c = br.readLine().toCharArray();
			List<String> pwd = new LinkedList<>();
			int index =-1;
			for(int i=0;i<c.length;i++) {
				switch (c[i]){
				case '-' :
					if(index > -1 && pwd.get(index)!=null) {
						pwd.remove(index);
						index--;
					}
					break;
				case '<' :
					if(index > -1)
						index--;
					break;
				case '>' :
					if(index < pwd.size()-1)
						index++;
					break;
				default :
					index++;
					pwd.add(index,String.valueOf(c[i]));
					break;
				}
			}
			System.out.println(String.join("", pwd));
			T--;
		}
	}
}
// listiterator 사용
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		//보드로 입력한 키는 알파벳 대문자, 소문자, 숫자, 백스페이스(-), 화살표이다.
		//만약 커서의 위치가 줄의 마지막이 아니라면, 커서 및 커서 오른쪽에 있는 모든 문자는 오른쪽으로 한 칸 이동한다.??
		while(T>0) {
			char[] c = br.readLine().toCharArray();
			List<String> pwd = new LinkedList<>();
			ListIterator<String> index = pwd.listIterator();
			for(int i=0;i<c.length;i++) {
				switch (c[i]){
				case '-' :
					if(index.hasPrevious()) {
						index.previous();
						index.remove();
					}
					break;
				case '<' :
					if(index.hasPrevious())
						index.previous();
					break;
				case '>' :
					if(index.hasNext())
						index.next();
					break;
				default :
					index.add(String.valueOf(c[i]));
					break;
				}
			}
			System.out.println(String.join("", pwd));
			T--;
		}
	}
}
