package week1.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] set = new int[10]; // 0으로 초기화
        for (int i = 0; i < N.length(); i++) {
            set[N.charAt(i) - '0']++;
        }

        // 갯수가 최대인 값
        int max = Arrays.stream(set).max().getAsInt();
        List<Integer> maxIndexes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (set[i] == max) {
                maxIndexes.add(i);
            }
        }

        if (maxIndexes.contains(6) && maxIndexes.contains(9) && maxIndexes.size() == 2) {
            printResult(set);
        } else if ((maxIndexes.contains(6) || maxIndexes.contains(9)) && maxIndexes.size() == 1) {
            printResult(set);
        } else {
            System.out.println(max);
        }

    }

    private static void printResult(int[] set) {
        int share = (set[6] + set[9]) / 2;
        int remainder = (set[6] + set[9]) % 2;
        System.out.println(remainder == 1 ? share + 1 : share);
    }
}
