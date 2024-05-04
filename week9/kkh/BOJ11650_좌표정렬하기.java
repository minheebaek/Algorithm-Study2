import java.util.*;
import java.io.*;

public class Main {
	static int[][] xy,tmp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬
		int N = Integer.parseInt(br.readLine());
		xy = new int [N+1][2];
		tmp = new int [N+1][2];
		String[] str;
		for(int i=1;i<=N;i++) {
			str = br.readLine().split(" ");
			xy[i][0]=Integer.parseInt(str[0]);
			xy[i][1]=Integer.parseInt(str[1]);
		}
		mergeSortX(1, N);
		int num=-100_001;
		int s=0,e=0;
		for(int i=1;i<=N;i++) {
			if(num<xy[i][0]) {
				mergeSortY(s, e);
				s=e=i;
				num = xy[i][0];
			}else {
				e=i;
			}
			if(i==N)
				mergeSortY(s, e);
		}
		for(int i=1;i<=N;i++)
			sb.append(xy[i][0]+" "+xy[i][1]).append("\n");
		System.out.println(sb);
	}
	
	static void mergeSortX(int s,int e) {
		if(e-s<1) return;
		int m = (e-s)/2+s;
		mergeSortX(s, m);
		mergeSortX(m+1, e);
		for(int i=s;i<=e;i++)
			tmp[i]=xy[i];
		int k=s;
		int index1=s;
		int index2=m+1;
		while(index1<=m && index2<=e) {
			if(tmp[index1][0]<tmp[index2][0])
				xy[k++]=tmp[index1++];
			else
				xy[k++]=tmp[index2++];
		}
		while(index1<=m) {
			xy[k++]=tmp[index1++];
		}
		while(index2<=e) {
			xy[k++]=tmp[index2++];
		}
	}
	static void mergeSortY(int s,int e) {
		if(e-s<1) return;
		int m = (e-s)/2+s;
		mergeSortY(s, m);
		mergeSortY(m+1, e);
		for(int i=s;i<=e;i++)
			tmp[i]=xy[i];
		int k=s;
		int index1=s;
		int index2=m+1;
		while(index1<=m && index2<=e) {
			if(tmp[index1][1]<tmp[index2][1])
				xy[k++]=tmp[index1++];
			else
				xy[k++]=tmp[index2++];
		}
		while(index1<=m) {
			xy[k++]=tmp[index1++];
		}
		while(index2<=e) {
			xy[k++]=tmp[index2++];
		}
	}
}

//숏코딩
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    List<int[]> list = new ArrayList<>();
    while(N-->0) {
      list.add(new int[]{sc.nextInt(),sc.nextInt()});
    }
    list.sort((arr1, arr2) -> (arr1[0] == arr2[0]) ? arr1[1] - arr2[1] : arr1[0] - arr2[0]);
    for(int[] point : list) {
      System.out.println(point[0] + " " + point[1]);
    }
  }
}