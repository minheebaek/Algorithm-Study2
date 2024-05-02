import java.io.*;
import java.util.*;

public class Main {
	static int N,A[],tmp[],result=0;
	static String s;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		for(int i=1;i<=N;i++)
			A[i]=Integer.parseInt(br.readLine());

		merge_sort(1, N);
		
		for(int i=1;i<=N;i++)
			sb.append(A[i]+"\n");
		
		System.out.println(sb);
	}
	static void merge_sort(int s, int e) {
		if(e-s<1) return;
		int m = (e-s)/2+s;
		merge_sort(s,m);
		merge_sort(m+1,e);
		
		for(int i=s;i<=e;i++)
			tmp[i]=A[i];
		
		int k = s;
		int index1 = s;
		int index2 = m+1;
		
		while(index1<= m && index2<=e) {
			if(tmp[index1]<tmp[index2]) {
				A[k]=tmp[index2];
				index2++;
			}else {
				A[k]=tmp[index1];
				index1++;
			}
			k++;
		}
		while(index1<=m) {
			A[k]=tmp[index1];
			index1++;
			k++;
		}
		while(index2<=e) {
			A[k]=tmp[index2];
			index2++;
			k++;
		}
	}	
}