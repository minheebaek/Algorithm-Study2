// result 자료형 int => 4% 틀림, long수정 후 통과
// 최대 약 80000*80001/2= 32억
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] high = new long[N];
		for(int i=0;i<N;i++) {
			high[i]=Integer.parseInt(br.readLine());
		}
		long result =0;
		
		for(int i=0;i<N-1;i++) {
			long cnt=0;
			for(int j=i+1;j<N;j++) {
				if(high[i]>high[j])
					cnt++;
				else
					break;
			}
			result+=cnt;
		}
		System.out.println(result);
	}
}

//숏코딩 모노스택
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
	    Stack<Integer> st = new Stack<>();
	    long result = 0;
	    for(int i = 0; i < N; i++){
	        int str = Integer.parseInt(br.readLine());
    	    while(!st.isEmpty() && st.peek() <= str){
                st.pop();
    	    }
    	    result += st.size();
    	    st.push(str);
	    }
	    System.out.println(result);
	}
}