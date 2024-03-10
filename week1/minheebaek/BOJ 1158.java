import java.util.LinkedList;
import java.util.Scanner;

public class BOJ1158{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=1; i<=N; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(list.size()>0){
            for(int i=0; i<K; i++){
                if(i==K-1){
                    if(list.size()==1){
                        sb.append(list.remove());
                    }else{
                        sb.append(list.remove()+", ");
                    }
                }else{
                    list.add(list.remove());
                }
            }
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}