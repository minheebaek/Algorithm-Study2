import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] paper;
	static int[] cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new int [N][N];
		cnt = new int[3];
		String[] s;
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<N;j++)
				paper[i][j]=Integer.parseInt(s[j]);
		}
		
		recursive(0,0,N);
		for(int i : cnt)
			System.out.println(i);
	}
	public static void recursive(int x,int y, int size) {
		if(size==1) {
			cnt[paper[x][y]+1]++;
			return;
		}
		boolean isSameNum = true;
		for(int i=x;i<x+size;i++) {
			for(int j=y;j<y+size;j++) {
				if(paper[i][j]!=paper[x][y]) {
					isSameNum =false;
					break;
				}
			}
			if(!isSameNum)
				break;
		}
		if(isSameNum) {
			cnt[paper[x][y]+1]++;
			return;
		}
		else {
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					recursive(x+i*size/3,y+j*size/3,size/3);
				}
			}
		}
			
	}
}