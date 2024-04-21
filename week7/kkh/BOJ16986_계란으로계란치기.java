import java.io.*;
import java.util.*;

public class Main {
	static int N,S[],W[],result=0, index=0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = new int[N];//내구도
		W = new int[N];//무게
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			S[i]=Integer.parseInt(s[0]);
			W[i]=Integer.parseInt(s[1]);
		}
		recursive(0);
		System.out.println(result);
	}
	public static void recursive(int start) {
		if(start==N) {
			int cnt =0;
			for(int i=0;i<N;i++)
				if(S[i]<=0)
					cnt++;
			result = Math.max(result, cnt);
			return;
		}
		if(S[start]<=0 || !isOtherEgg(start)) {
			recursive(start+1);
		}
		else {
			for(int i=0;i<N;i++) {
				if(start==i || S[i]<=0)continue;
				S[i]-=W[start];
				S[start]-=W[i];
				recursive(start+1);
				S[i]+=W[start];
				S[start]+=W[i];
			}
		}
	}
	public static boolean isOtherEgg(int index) {
		boolean result = false;
		for(int i=0;i<N;i++) {
			if(i==index)
				continue;
			if(S[i]>0) {
				result = true;
				break;
			}
		}
		return result;
	}
}