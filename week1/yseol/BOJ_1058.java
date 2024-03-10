import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        // 1058
        /*
         * a b c d e
         * x o x x x -> a : b
         * o x o x x -> b : a,c
         * x o x o x -> c : b, d
         * x x o x o -> d: c, e
         * x x x o x -> e : d
         *
         * a : b, c
         * b : a,c, d
         * c : b,d,e
         * d : c,e,d
         * e :d,c,
         *
         * a -- b
         * |  / |
         * c -- d
         * |   /
         * e
         *
         * */

        /**1.입력받기*/
        BufferedReader bfr  = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bfr.readLine());

        char[][] friends = new char[n][n];

        for (int i = 0; i < n; i++) {
            friends[i] = bfr.readLine().toCharArray();
        }
        int maxCount = 0;

        /**2. 친구 및 친구의 친구일 경우 count*/

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int count = 0;
            int depth = 0;
            while (depth <2){

                int size = queue.size();

                for (int k = 0; k < size; k++) {
                    int current = queue.poll();
                    for (int j = 0; j < n; j++) {
                        if (friends[current][j] == 'Y' && !visited[j]){
                            visited[j] = true;
                            queue.add(j);
                            count++;
                        }
                    }
                }
                depth++;
            }
            if (count>= maxCount){
                maxCount = count;
            }

        }
        System.out.println(maxCount);
    }
}