import java.util.*;
import java.io.*;
public class Main {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		String[] s;
		// 국어, 영어, 수학 점수
		Data[] dataAry = new Data[N];
		for(int i=0;i<N;i++) {
			s = br.readLine().split(" ");
			dataAry[i]=new Data(s[0], Integer.parseInt(s[1]),Integer.parseInt(s[2]),Integer.parseInt(s[3]));
		}
		
		Arrays.sort(dataAry, (a,b)-> (a.kor!=b.kor)?(b.kor-a.kor):
			(a.eng!=b.eng?(a.eng-b.eng):
			(a.math!=b.math?(b.math-a.math):
			(a.name.compareTo(b.name))
			)));
		
		for(Data d : dataAry)
			sb.append(d.name).append("\n");
		System.out.println(sb);
	}
}

class Data{
	String name;
	int kor;
	int eng;
	int math;
	Data(String name, int kor, int eng, int math){
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
}