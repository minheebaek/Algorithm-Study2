import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static String[] s;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		s = new String[7];
		s[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		s[1] = "\"재귀함수가 뭔가요?\"";
		s[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		s[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		s[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		s[5] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		s[6] = "라고 답변하였지.";
		
		System.out.println(s[0]);
		recursive(0);
	}
	
	public static void recursive(int c) {

		for(int i=0;i<c;i++) {
			System.out.print("____");
		}
		System.out.println(s[1]);

		if(c<N) {
			for(int j=2;j<5;j++) {
				for(int i=0;i<c;i++) {
					System.out.print("____");
				}
				System.out.println(s[j]);
			}
			recursive(c+1);
		}
		else {
			for(int i=0;i<c;i++) {
				System.out.print("____");
			}
			System.out.println(s[5]);
		}
		for(int i=0;i<c;i++) {
			System.out.print("____");
		}
		System.out.println(s[6]);
	}
}