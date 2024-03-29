import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1012_유기농배추 {
    static Stack<Node> stack = new Stack<>();
    static int map[][];
    static boolean visit[][];
    static int dirX[] = {0, 0, -1, 1}; // 상하좌우 방향을 나타내는 배열
    static int dirY[] = {-1, 1, 0, 0}; // 상하좌우 방향을 나타내는 배열
    static int count = 1;
    static int N, M; // 배추 밭의 세로(N)과 가로(M)의 크기 
    static int nowX, nowY; // 현재 탐색 중인 위치의 x, y 좌표

    static class Node{
        int x;
        int y;

        // 생성자
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수를 입력 받음
        while(T--> 0){ // 테스트 케이스의 수만큼 반복
            st = new StringTokenizer(br.readLine()); // 각 테스트 케이스의 첫 번째 줄을 읽어 토큰화

            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로

            map = new int[N][M]; // 배추 밭의 상태를 저장할 2차원 배열 초기화
            visit = new boolean[N][M]; // 방문 여부를 저장할 2차원 배열 초기화

            int K = Integer.parseInt(st.nextToken()); // 배추의 위치 수를 입력 받음
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // X좌표 입력 받음
                int y = Integer.parseInt(st.nextToken()); // Y좌표 입력 받음
                map[y][x] = 1; // 배추가 있는 위치를 1로 표시
            }

            count = 0; // 배추가 연결되어 있는 영역의 개수 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(visit[i][j] == false && map[i][j] == 1){ // 방문하지 않은 배추가 있는 위치를 찾음
                        count++; //  배추가 연결되어 있는 영역의 개수 증가
                        DFS(j, i); // DFS 시작
                    }
                }
            }
            sb.append(count).append('\n'); // 결과 출력
        }
        System.out.println(sb); // 모든 테스트 케이스에 대한 결과 출력
    } // End of main

    static void DFS(int x, int y) {
        stack.add(new Node(x, y)); // 현재 위치를 스택에 추가
        visit[y][x] = true; // 현재 위치를 방문했으므로 표시
        while (!stack.isEmpty()) { // 스택이 비어있지 않을 때까지 반복
            Node node = stack.pop(); // 스택에서 위치 정보를 가져옴

            for (int i = 0; i < 4; i++) { // 상하좌우 방향 4개를 확인
                nowX = node.x + dirX[i]; // 현재 위치에서 상하좌우 방향으로 이동한 위치의 x 좌표
                nowY = node.y + dirY[i]; // 현재 위치에서 상하좌우 방향으로 이동한 위치의 x 좌표
                if (Range_check() && visit[nowY][nowX] == false && map[nowY][nowX] == 1) {
                    // 범위 내에 있고, 방문하지 않은 배추가 있는 위치인지 확인
                    stack.push(new Node(nowX, nowY)); // 해당 위치를 스택에 추가
                    visit[nowY][nowX] = true; // 해당 위치를 방문했음으로 표시
                }
            }

        }
    }

    static boolean Range_check() { // 현재 위치가 배추 밭의 범위 내에 있는지 검사
        return (nowX < M && nowY < N && nowX >= 0 && nowY >= 0);
    }



}
