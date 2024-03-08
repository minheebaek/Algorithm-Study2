import java.util.*;

/**
 * 배열 비교해서 동일한 원소 찾으면 삭제함, 후에 남은 원소들이 정답이 됨
 */
public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();
        String str2 = scan.next();

        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();

        for(int i=0;i<str1.length();i++){
            list1.add(str1.charAt(i));
        }

        for(int i=0;i<str2.length();i++){
            list2.add(str2.charAt(i));
        }
        int cnt=0;
        for(int i=0; i< str1.length();i++){
            if(list2.contains(list1.get(i))){
                list2.remove(list1.get(i));
                cnt++;
            }
        }

        System.out.println(list1.size()+list2.size()-cnt);

    }
}