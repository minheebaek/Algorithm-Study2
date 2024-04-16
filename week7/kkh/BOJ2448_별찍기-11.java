import java.io.*;
import java.util.*;


public class Main {
	static int N;
	static char[][] a;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		N=Integer.parseInt(s);
		a=new char[N][2*N-1];
		for(int i=0;i<a.length;i++)
			Arrays.fill(a[i], ' ');
		recursive(0,0,N);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[0].length;j++) {
				sb.append(a[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	static void recursive(int sx, int sy, int h) {
		if(h==3) {
			//별찍기
			for(int i=0;i<h;i++) {
				for(int j=0;j<2*h-1;j++) {
					if( (i==0 && j==2) ||
							(i==1 && j%2==1) ||
							i==2 )
						a[sx+i][sy+j]='*';
				}
			}
			return;	
		}
		for(int i=0;i<3;i++) {
			int nx=sx,ny=sy;
			switch(i) {
			case 0:
				ny =(2*h)/4+sy;
				break;
			case 1:
				nx = (h)/2+sx;
				break;
			case 2:
				nx =(h)/2+sx;
				ny = (2*h)/2+sy;
				break;
			}
			recursive(nx,ny,h/2);
		} 
	}
}

//숏코딩
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] temp;
		String[] curr = new String[] {"  *  ", " * * ", "*****"};
		int size = 3;
		while (size != n) {
			temp = curr;
			curr = new String[size << 1]; // *2
			for (int i = 0; i < size; i++) {
				curr[i] = " ".repeat(size) + temp[i] + " ".repeat(size);
				curr[i + size] = temp[i] + " " + temp[i];
			}
			size <<= 1;
		}
		for (String s: curr)
			System.out.println(s);
		sc.close();
	}
}