import java.util.*;
import java.io.*;

public class Main {
	static int[][] xy;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
		int N = Integer.parseInt(br.readLine());
		xy = new int [N][2];
		String[] str;
		for(int i=0;i<N;i++) {
			str = br.readLine().split(" ");
			xy[i][0]=Integer.parseInt(str[0]);
			xy[i][1]=Integer.parseInt(str[1]);
		}
		Arrays.sort(xy,(a,b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
		
		for(int i=0;i<N;i++)
			sb.append(xy[i][0]+" "+xy[i][1]).append("\n");
		System.out.println(sb);
	}
}