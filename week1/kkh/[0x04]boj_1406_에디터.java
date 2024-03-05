import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		List<String> list = new LinkedList<>();
		ListIterator<String> iter = list.listIterator();
		for (char ch : c) {
			iter.add(String.valueOf(ch));
		}
		int M = Integer.parseInt(br.readLine()); // 명령어의 개수 M
		while(M-->0) {
			String[] s = br.readLine().split(" ");
			
			switch(s[0]) {
			case "L" : // 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
				if(iter.hasPrevious())
					iter.previous();
				break;
			case "D" : // 커서를 오른쪽으로 한 칸 옮김 (커서가 문장의 맨 뒤이면 무시됨)
				if(iter.hasNext())
					iter.next();
				break;
			case "B" : // 커서 왼쪽에 있는 문자를 삭제함 (커서가 문장의 맨 앞이면 무시됨)
				//삭제로 인해 커서는 한 칸 왼쪽으로 이동한 것처럼 나타나지만, 실제로 커서의 오른쪽에 있던 문자는 그대로임
				if(iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
				break;
			case "P" : // $라는 문자를 커서 왼쪽에 추가함
				iter.add(s[1]);
				break;
			
			}
		}
		System.out.print(String.join("", list));
	}
}