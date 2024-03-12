// 배열복사로 인한 시간초과
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());//명령어의 수 N
		String[] s;
		int index =-1;
		int size = 3;
		int[] myQueue = new int[size];
		int value;
		while(N-->0) {
			s = br.readLine().split(" ");
			switch (s[0]) {
			case "push": // offer
				if(++index>=size){
					size *=2;
					int[] tmp = new int[size];
					System.arraycopy(myQueue, 0, tmp, 0, myQueue.length);
					myQueue = tmp;
				}
				myQueue[index]=Integer.parseInt(s[1]);
				break;
			case "pop": // poll
				if(index<0) {
					value=-1;
				}
				else{
					value=myQueue[0];
					if(--index<(size/2) && size>3)
						size /=2;
					int[] tmp = new int[size];
					System.arraycopy(myQueue, 1, tmp, 0, index+1);
					myQueue = tmp;
				}
				sb.append(value+"\n");
				break;
			case "size":
				sb.append(index+1+"\n");
				break;
			case "empty":
				value = (index==-1)?1:0;
				sb.append(value+"\n");
				break;
			case "front":
				value = (index==-1)?-1:myQueue[0];
				sb.append(value+"\n");
				break;
			case "back":
				value = (index==-1)?-1:myQueue[index];
				sb.append(value+"\n");
				break;
			}
		}
		System.out.println(sb.toString());
	}
}

//투포인터
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());//명령어의 수 N
		String[] s;
		int start = 0;
		int end =0;
		int[] myq = new int[N];
		while(N-->0) {
			s = br.readLine().split(" ");
			switch (s[0]) {
			case "push": // offer
				myq[end++]=Integer.parseInt(s[1]);
				continue;
			case "pop": // poll
				sb.append(start!=end?myq[start++]:-1);
				break;
			case "size":
				sb.append(end-start);
				break;
			case "empty":
				sb.append(start==end?1:0);
				break;
			case "front":
				sb.append(start!=end?myq[start]:-1);
				break;
			case "back":
				sb.append(start!=end?myq[end-1]:-1);
				break;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}