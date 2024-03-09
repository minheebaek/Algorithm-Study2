package linkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            LinkedList<Character> left = new LinkedList<>();
            ListIterator<Character> right = left.listIterator();

            String data = br.readLine();

            for (char j : data.toCharArray()) {
                switch (j) {
                    case '<':
                        if (right.hasPrevious()) {
                            right.previous();
                        }
                        break;
                    case '>':
                        if (right.hasNext()) {
                            right.next();
                        }
                        break;
                    case '-':
                        if (right.hasPrevious()) {
                            right.previous();
                            right.remove();
                        }
                        break;
                    default:
                        right.add(j);
                        break;
                }
            }

            StringBuilder result = new StringBuilder();
            for (char ch : left) {
                result.append(ch);
            }
            System.out.println(result.toString());
        }
        br.close();
    }
}
