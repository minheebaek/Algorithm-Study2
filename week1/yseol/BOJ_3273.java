import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

/**
 시간초과 3273

 Scanner scanner = new Scanner(System.in);
 int n = scanner.nextInt();

 int[] nums = new int[n];
 for (int i = 0; i < n; i++) {
 nums[i] = scanner.nextInt();
 }

 int x = scanner.nextInt();

 // (12,1),(10,3),(2,11)
 int count = 0;

 for (int i = 0; i < n-1; i++) {
 for (int j = i; j < n; j++) {
 if (x == nums[i]+nums[j]){
 count++;
 // System.out.printf("%d,%d\n",nums[i],nums[j]);
 }
 }
 }

 System.out.println(count);
 */
        /**  투포인터 사용 */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);

        int x = scanner.nextInt();

        int lt = 0;
        int rt = n-1;

        //장렬 : 1 2 3 4 5 7 9 10 11 12
        // (12,1),(10,3),(2,11)
        int count = 0;

        while (lt<rt){
            int sum = nums[lt]+nums[rt];
            if(sum == x) count++;
            if (sum > x){
                rt--;
            }else{
                lt++;
            }
        }

        System.out.println(count);


    }
}