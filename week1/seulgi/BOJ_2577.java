import java.util.Scanner;
public class BOJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sNum = Integer.toString(sc.nextInt() * sc.nextInt() * sc.nextInt());
        char[] cNum = sNum.toCharArray();
        int[] result = new int[10];

        for(int i=0;i<cNum.length;i++) {
            result[cNum[i]-'0']++;
        }

        for(int i:result) {
            System.out.println(i);
        }
    }
}
