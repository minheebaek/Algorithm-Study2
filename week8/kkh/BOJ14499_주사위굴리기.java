import java.io.*;
import java.util.*;

public class Main {
	static int N,M,x,y,K,dice[]=new int[6],map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//dice 0:top 1:bottom 2:front 3:back 4:left 5:right
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		x = Integer.parseInt(s[2]);
		y = Integer.parseInt(s[3]);
		K = Integer.parseInt(s[4]);
		map = new int[N][M];
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			for(int j=0;j<s.length;j++) {
				map[i][j]=Integer.parseInt(s[j]);
			}
		}
		s = br.readLine().split(" ");
		for(int i=0;i<s.length;i++) {
			if(rollTheDice(Integer.parseInt(s[i])))
				sb.append(dice[0]+"\n");
		}
		System.out.println(sb);
	}
	
	// 동1 서2 북3 남4
	static boolean rollTheDice(int dir) {
		int[] tmp = new int[6];
		if(dir==1) {
			if(!(y+1<M)) {
				return false;
			}
			y=y+1;
			tmp[0]=dice[4];
			tmp[1]=dice[5];
			tmp[2]=dice[2];
			tmp[3]=dice[3];
			tmp[4]=dice[1];
			tmp[5]=dice[0];
		}else if(dir==2) {
			if(!(y>0)) {
				return false;
			}
			y=y-1;
			tmp[0]=dice[5];
			tmp[1]=dice[4];
			tmp[2]=dice[2];
			tmp[3]=dice[3];
			tmp[4]=dice[0];
			tmp[5]=dice[1];
		}else if(dir==3) {
			if(!(x>0)) {
				return false;
			}
			x=x-1;
			tmp[0]=dice[2];
			tmp[1]=dice[3];
			tmp[2]=dice[1];
			tmp[3]=dice[0];
			tmp[4]=dice[4];
			tmp[5]=dice[5];
		}else if(dir==4) {
			if(!(x+1<N)) {
				return false;
			}
			x=x+1;
			tmp[0]=dice[3];
			tmp[1]=dice[2];
			tmp[2]=dice[0];
			tmp[3]=dice[1];
			tmp[4]=dice[4];
			tmp[5]=dice[5];
		}
		dice=tmp;
		if(map[x][y]==0)
			map[x][y]=dice[1];
		else {
			dice[1]=map[x][y];
			map[x][y]=0;
		}
		return true;
	}
}