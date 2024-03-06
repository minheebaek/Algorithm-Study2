import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int count = 0;
        int[] nums = new int[10];

        while(num>0){
            int d = num%10;
            if (d == 9) d=6;
            num = num/10;
            nums[d]++;
        }
/** 반례)666 -> 원래 코드 1 출력 되어서 if문으로 홀수일 때 처리*/
        if (nums[6] >1){
            if (nums[6]%2 == 0){
                nums[6] = nums[6]/2;
            }else {
                nums[6] = nums[6]/2+1;
            }
        }

//        for (int i = 0; i < 10; i++) {
//            System.out.printf("%d : %d\n",i,nums[i]);
//        }
        while (true){
            int sum = Arrays.stream(nums).sum();
            if (sum == 0) break;

            for (int i = 0; i < 10; i++) {
                if(nums[i] == 0) continue;
                nums[i]--;
            }
            count++;

        }
//        for (int i = 0; i < 10; i++) {
//            System.out.printf("%d : %d\n",i,nums[i]);
//        }
        System.out.println(count);

    }
}