import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s;
		myStack stack = new myStack();
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			switch(s[0]) {
			case "push" :
					stack.push(Integer.parseInt(s[1]));
				break;
			case "pop" :
				stack.pop();
				break;
			case "size" :
				stack.size();
				break;
			case "empty" :
				stack.empty();
				break;
			case "top" :
				stack.top();
				break;
			}
		}
	}
}

class myStack{
	List<Integer> list;
	int index;
	
	myStack(){
		this.index=-1;
		list = new ArrayList<>();
	}
	
	public void push(int x) {//push X: 정수 X를 스택에 넣는 연산이다.
		list.add(x);
		index++;
	}
	public void pop() {//스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 
		//만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(list.isEmpty())
			System.out.println("-1");
		else {
			System.out.println(list.get(index));
			list.remove(index--);
		}
	}
	public void size() {//size: 스택에 들어있는 정수의 개수를 출력한다.
		System.out.println(list.size());
	}
	public void empty() {//empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
		if(list.isEmpty())
			System.out.println("1");
		else
			System.out.println("0");
	}
	public void top() {//top: 스택의 가장 위에 있는 정수를 출력한다. 
		//만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		if(list.isEmpty())
			System.out.println("-1");
		else
			System.out.println(list.get(index));
	}
}