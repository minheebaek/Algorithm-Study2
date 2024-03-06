import java.util.*;
import java.io.*;

/**
 * 원소만 서로 같으면 되니까 배열에 각자 넣고 정렬 후 배열을 비교함
 */
public class BOJ11328{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int j=0; j<n; j++) {
            ArrayList<Character> list1 = new ArrayList<>();
            ArrayList<Character> list2 = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int i = 0; i < str.length(); i++) {
                list1.add(str.charAt(i));
            }

            String str2 = st.nextToken();

            for (int i = 0; i < str2.length(); i++) {
                list2.add(str2.charAt(i));
            }

            Collections.sort(list1);
            Collections.sort(list2);

            if (list1.equals(list2)) {
                System.out.println("Possible");
            } else {
                System.out.println("Impossible");
            }
        }
    }
}