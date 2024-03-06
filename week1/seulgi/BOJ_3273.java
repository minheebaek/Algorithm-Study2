import java.util.Scanner;

public class BOJ_3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] sNum = sc.nextLine().split(" ");
        int x = sc.nextInt();

        int[] occur = new int[2000001]; // 크기를 100만로 잡으면 에러남. x가 200만 이하이기 때문에 occur[x-arr[i]]에서 x-arr[i]가 100만을 초과할 수 있기 때문
        int[] arr = new int[n];

        int pair = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(sNum[i]);
            if(x>arr[i] && occur[x-arr[i]]==1) pair++;
            occur[arr[i]] = 1;
        }
        System.out.println(pair);
    }
}
