import java.util.Scanner;

public class BOJ_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cNum = sc.next().toCharArray();
        int[] freq = new int[10];
        for(int i=0;i<cNum.length;i++)
            freq[cNum[i] - '0']++;

        int max = 0;
        for(int i=0;i<freq.length;i++){
            if(i == 6 || i == 9) continue;
            if(freq[i] > max) max = freq[i];
        }
        max = Math.max(max, freq[6]+freq[9]+1/2);
        System.out.println(max);
    }
}
