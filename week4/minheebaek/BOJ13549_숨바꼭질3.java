import java.util.*;
import java.io.*;

class Node{
    int x;
    int time;

    public Node(int x, int time){
        this.x=x;
        this.time=time;
    }
}
public class BOJ13549_숨바꼭질3 {
    static int n,k;
    static boolean[] visited;
    static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        bfs();
        System.out.println(ans);
    }

    static void bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n,0));


        while(!queue.isEmpty()){
            Node node=queue.poll();
            visited[node.x]=true;
            if(node.x==k) ans=Math.min(ans, node.time);

            if(node.x*2<100001&&!visited[node.x*2]){
                queue.add(new Node(node.x*2,node.time));
            }
            if(node.x+1<100001&&!visited[node.x+1]){
                queue.add(new Node(node.x+1,node.time+1));
            }
            if(node.x-1>=0&&!visited[node.x-1]){
                queue.add(new Node(node.x-1,node.time+1));
            }

        }
    }
}