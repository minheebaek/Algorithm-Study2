import java.io.*;
import java.util.*;

public class Main {
	static int N, start[]=new int[5], result;
	static String a[]=new String[5];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
		for(int i=1;i<a.length;i++) {
			a[i] = br.readLine();
		}
		N= Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			String[] s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0]);
			int cycle = Integer.parseInt(s[1]);
			// -1 왼쪽, +1 오른쪽
			recursive(num,cycle,-1);
			start[num]+=cycle;
			recursive(num,cycle,1);
		}
		for(int i=1;i<a.length;i++) {
			int num = start[i]<0?(start[i]%8+8)%8:start[i]%8;
			if(a[i].charAt(num)=='1')
				result += Math.pow(2, i-1);
		}
		System.out.println(result);
	}
	static void recursive(int num, int cycle, int dir) {
		//왼쪽확인
		if(dir==-1 && num>1) {
			int leftNum = start[num]<0?((start[num]-2)%8+8)%8:(start[num]+6)%8;
			int rightNum = start[num-1]<0?((start[num-1]-6)%8+8)%8:(start[num-1]+2)%8;
			if(a[num].charAt(leftNum)!=a[num-1].charAt(rightNum)) {
				recursive(num-1,cycle*-1, dir);
			}
		}
		//오른쪽확인
		if(dir==1 && num<4) {
			int rightNum = start[num]<0?((start[num]-6)%8+8)%8:(start[num]+2)%8;
			int leftNum = start[num+1]<0?((start[num+1]-2)%8+8)%8:(start[num+1]+6)%8;
			if(a[num].charAt(rightNum)!=a[num+1].charAt(leftNum)) {
				recursive(num+1,cycle*-1, dir);
			}
		}
		start[num]-=cycle;
	}
}