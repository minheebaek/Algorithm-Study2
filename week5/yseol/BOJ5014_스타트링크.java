
import java.io.*;
import java.util.*;

public class Main {

    /** 5주차
     * 1.BOJ 5014 스타트링크
     * 2. DFS
     * 3. 1) 중요 포인트**>  버튼을 적어도 몇 번 눌러야 하는지 구하는 프로그램 -> 최단거리 구하기 BFS !! 사용
     *    1-1) 위아래 static int[] dir = new int[2]; // 보통은 상하좌우였는데 이번 문제는 상하만!
     *    2) dfs() 함수
     *    2-1) visit[current_floor] = true; -> 왜 필요한가? : 최단 거리 구하기임으로!!
     *    2-2) move[current_floor] = 0; -> 층마다 이동횟수 저장
     *    2-3) move[nextfloor] = move[cur]+1; -> 다음 층 이동 횟수 저장
     *
     * 4. 시간복잡도
     *    DFS :  정점의 개수 : F , 간선의 개수 : E -> O(F+E)
     */
    static int F, S, G, U, D, count; //최고 층 f
    static int[] move;
    static boolean[]visit;
    static Queue<Integer> queue;
    static int[] dir = new int[2];

    static void bfs(int current_floor){
        queue = new LinkedList<>();
        queue.offer(current_floor);
        move[current_floor] = 0;
        visit[current_floor] = true;

        while (!queue.isEmpty()){
            int cur = queue.poll();

            if (cur == G){
                System.out.println(move[cur]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nextfloor = cur+dir[i];

                if (nextfloor >F || nextfloor<1) continue;

                if (!visit[nextfloor]){
                    queue.offer(nextfloor);
                    visit[nextfloor] = true;
                    move[nextfloor] = move[cur]+1;
                }
            }
        }

        System.out.println("use the stairs");

    }

    // 스타트링크는 총 F층으로 이루어진 고층 건물에 사무실이 있고, 스타트링크가 있는 곳의 위치는 G층이다.
    // 강호가 지금 있는 곳은 S층이고, 이제 엘리베이터를 타고 G층으로 이동하려고 한다.
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        F = sc.nextInt(); //최고 층
        S = sc.nextInt(); //현재 위치
        G = sc.nextInt(); //스타트링크 층
        U = sc.nextInt(); //up
        D = sc.nextInt(); //down

        dir = new int[]{U,-D};

        move = new int[F+1]; //층마다 이동 횟수 저장
        visit = new boolean[F+1]; //이전에 방문했던 층을 방문하면 최단 경로X
        bfs(S);

    }
}


