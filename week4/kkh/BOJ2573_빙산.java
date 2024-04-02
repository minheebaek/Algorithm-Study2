public class Main {
	private static int[] dx = new int[] {0,0,-1,1};
	private static int[] dy = new int[] {-1,1,0,0};
	private static int N, M, cnt, result;
	private static int[][] a,b;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N=Integer.parseInt(s[0]);
		M=Integer.parseInt(s[1]);
		a=new int[N][M];
		s = br.readLine().split(" ");
		for(int i=1;i<N-1;i++) {//배열의 첫 번째 행과 열, 마지막 행과 열에는 항상 0으로 채워진다.
			s = br.readLine().split(" ");
			for(int j=1;j<M-1;j++)
				 a[i][j]=Integer.parseInt(s[j]);
		}
		s = br.readLine().split(" ");
		while(cnt<2) {
			//1. 빙산에 인접한 바다갯수를 구한다
			b=new int[N][M];
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					for(int k=0;k<4;k++) {
						int nx = dx[k]+i;
						int ny = dy[k]+j;
						if(nx<0||nx>=N||ny<0||ny>=M)
							continue;
						if(a[nx][ny]==0)
							b[i][j]++;
					}
				}
			}
			//2. 1년뒤 처리를 한다, 처리후 빙산이 다녹았다면 0을출력한다
			boolean isBingzero =true;
			for(int i=1;i<N-1;i++) {
				for(int j=1;j<M-1;j++) {
					a[i][j]=(a[i][j]-b[i][j])>0?(a[i][j]-b[i][j]):0;
					if(a[i][j]!=0)
						isBingzero=false;
				}
			}
			if(isBingzero) {
				result=0;
				break;
			}
			//3. 빙산 덩어리 갯수를 구한다, 빙산 덩어리가 2개 이상이라면 결과를 출력한다
			dfs();
			result++;
		}
		System.out.println(result);
	}
	private static void dfs() {
		cnt = 0;
		b=new int[N][M];
		Stack<int[]> st = new Stack<>();
		for(int i=1;i<N-1;i++) {
			for(int j=1;j<M-1;j++){
				if(a[i][j]>0 && b[i][j]==0) {
					st.push(new int[] {i,j});
					cnt++;
				}
				while(!st.isEmpty()) {
					int[] xy = st.pop();
					int x = xy[0];
					int y = xy[1];
					b[i][j]=cnt;
					for(int k=0;k<4;k++) {
						int nx = dx[k]+x;
						int ny = dy[k]+y;
						if(nx<0||nx>=N||ny<0||ny>=M)
							continue;
						if(a[nx][ny]>0 && b[nx][ny]==0) {
							b[nx][ny]=cnt;
							st.push(new int[] {nx,ny});
						}
					}
				}
			}
		}
	}
}