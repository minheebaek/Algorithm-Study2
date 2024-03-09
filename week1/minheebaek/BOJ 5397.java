import java.util.*;
import java.io.*;
/**
 * 원소를 자주 추가하고 삭제하는 문제다 연결리스트를 사용하면 O(1)에 해결할 수 있다
 * 문자열이 1,000,000이라 BufferedReader을 사용함
 * LinkedList 요소를 하나씩 반복해서 요소를 확인하는 ListIterator(양방향) 사용
 */
public class BOJ5397{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        for(int j=0;j<t;j++){
            String str = br.readLine();

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);

                switch(c){
                    case '<':
                        if(iter.hasPrevious()){
                            iter.previous();
                        }
                        break;
                    case '>':
                        if(iter.hasNext()){
                            iter.next();
                        }
                        break;
                    case '-':
                        if(iter.hasPrevious()){
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for(char c : list){
                sb.append(c);
            }

            System.out.println(sb.toString());
        }
    }
}