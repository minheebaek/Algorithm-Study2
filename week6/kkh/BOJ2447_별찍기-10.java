import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static char[][] info;
	static String result="";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		info = new char [N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(info[i], ' ');
		}
		recursive(0,0,N);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				sb.append(info[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	public static void recursive(int x,int y, int size) {
		if(size==0)
			return;
		if(size==1)
			info[x][y]='*';
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				if(!(i==1 && j==1))
					recursive(x+i*size/3,y+j*size/3,size/3);
			}
	}
}