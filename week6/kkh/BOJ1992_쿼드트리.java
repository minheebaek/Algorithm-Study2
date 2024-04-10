import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] info;
	static String result="";
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		info = new int [N][N];
		String s;
		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<N;j++)
				info[i][j]= s.charAt(j)-'0';
		}
		recursive(0,0,N);
		System.out.println(result);
	}
	public static void recursive(int x,int y, int size) {
		boolean isSameNum = true;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(info[i][j]!=info[x][y]) {
					isSameNum =false;
					break;
				}
			}
			if(!isSameNum)
				break;
		}
		
		if(isSameNum) {
			result+=info[x][y];
			return;
		}
		else {
			result+='(';
			for(int i=0;i<2;i++)
				for(int j=0;j<2;j++)
					recursive(x+i*size/2,y+j*size/2,size/2);
			result+=')';
		}
	}
}