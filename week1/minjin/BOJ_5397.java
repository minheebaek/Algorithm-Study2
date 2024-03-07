package week1.minjin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BOJ_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            char[] password = br.readLine().toCharArray();

            List<Character> charArr = new LinkedList<>();
            ListIterator<Character> iter = charArr.listIterator();

            for (char ch : password) {
                switch (ch) {
                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(ch);
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : charArr) {
                sb.append(c);
            }
            System.out.println(sb);
        }
        
    }
}
