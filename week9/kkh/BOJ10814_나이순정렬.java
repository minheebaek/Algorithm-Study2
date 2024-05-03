import java.io.*;

public class Main {
	static User[] users,tmp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬
		int N = Integer.parseInt(br.readLine());
		String[] s;
		users = new User[N+1];
		tmp = new User[N+1];
		for(int i=1;i<=N;i++) {
			s = br.readLine().split(" ");
			users[i]=new User(i,Integer.parseInt(s[0]),s[1]);
		}
		mergeSort(1,N);
		for(int i=1;i<=N;i++) {
			sb.append(users[i].age+" "+users[i].name).append("\n");
		}
		System.out.println(sb);
	}
	
	static void mergeSort(int s, int e) {
		if(e-s < 1) return;
		
		int m = (e-s)/2 +s;
		mergeSort(s,m);
		mergeSort(m+1,e);
		
		for(int i=s;i<=e;i++)
			tmp[i]=users[i];
		
		int k = s;
		int index1 = s;
		int index2 = m+1;
		while(index1 <= m && index2 <= e) {
			if(tmp[index1].age==tmp[index2].age) {
				if(tmp[index1].index<tmp[index2].index)
					users[k++]=tmp[index1++];
				else
					users[k++]=tmp[index2++];
			}else if(tmp[index1].age<tmp[index2].age) {
				users[k++]=tmp[index1++];
			}else
				users[k++]=tmp[index2++];
		}
		while(index1<=m) {
			users[k++]=tmp[index1++];
		}
		while(index2<=e) {
			users[k++]=tmp[index2++];
		}
			
	}
}
class User{
	int index;
	int age;
	String name;
	User(int index, int age, String name){
		this.index=index;
		this.age=age;
		this.name=name;
	}
}

//숏코딩
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Object[][] memberInfo = new Object[N][2];
		
		for(int i=0; i<N; i++) {
			memberInfo[i][0] = sc.nextInt();
			memberInfo[i][1] = sc.next();
		}
				
		Arrays.sort(memberInfo, (a, b) -> ((Comparable)a[0]).compareTo(b[0]));

		for(int i=0; i<N; i++) {
			System.out.println(memberInfo[i][0]+" "+memberInfo[i][1]);
		}
	}
}