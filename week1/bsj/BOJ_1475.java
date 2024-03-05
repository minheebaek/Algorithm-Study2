import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomNumber = sc.next();
        int[] arr = new int[10]; // 0~9까지의 배열을 index로 사용, 각 인덱스에 해당하는 count를 증가시키는 방법
        for(char c : roomNumber.toCharArray()){
            int num = c - '0';

            if(num == 9){ // 6과 9는 뒤집어 사용 가능
                num = 6; // 6으로 몰아주기
            }

            arr[num]++; // 해당 인덱스의 count 증가
        }
        arr[6] = (arr[6] / 2) + (arr[6] % 2); // count의 값을 반으로 나눈다.
        Arrays.sort(arr);
        System.out.println(arr[9]);
    }
}
