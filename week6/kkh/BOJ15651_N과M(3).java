public class Main {
	static int N,M;
	static List<Integer> a;
	static List<List<Integer>> result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);
		a = new ArrayList<>();
		result = new ArrayList<>();
		for(int i=1;i<=N;i++) {
			a.add(i);
		}
		
		recursive(new ArrayList<>());
		
		for(List<Integer> list : result) {
			for(Integer i : list) {
				sb.append(i+" ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	public static void recursive(List<Integer> b) {
		if(b.size()==M) {
			result.add(b);
			return;
		}
		for(int i=0; i<a.size();i++) {
			List<Integer> tmp2 = new LinkedList<>(b);
			tmp2.add(a.get(i));
			recursive(tmp2);
		}
	}
}

//숏코딩
public class Main {
static StringBuilder sb=new StringBuilder();
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		nm(s.nextInt(),s.nextInt(),"");
		System.out.print(sb);
	}
	static void nm(int n,int m,String k) {
		if(m==0) {
			sb.append(k+"\n");
			return;
		}
		for(int i=1;i<=n;i++) nm(n,m-1,k+i+" ");
	}
}