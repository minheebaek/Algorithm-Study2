import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        //System.out.printf("%d,%d,%d \n", n1,n2,n3);

        int num = n1*n2*n3;
        int[] count = new int[10];

        while (num>0){
            int d = num % 10;
            num = num / 10;
            count[d]++;
        }

        for (int i: count){
            System.out.println(i);
        }
    }
}