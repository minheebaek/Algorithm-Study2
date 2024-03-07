import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class BOJ_5397 {
    static LinkedList<Character> lnklist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++){
            lnklist = new LinkedList<>();
            ListIterator<Character> listIter = lnklist.listIterator();
            String str = br.readLine();

            for(int j=0; j < str.length(); j++){
                char c = str.charAt(j);
                switch (c){
                    case '<':
                        if(listIter.hasPrevious())
                            listIter.previous();
                        break;
                    case '>':
                        if(listIter.hasNext())
                            listIter.next();
                        break;
                    case '-':
                        if(listIter.hasPrevious()){ //이전 값이 있으면
                            listIter.previous(); // 커서를 이전 방향으로 이동하고 삭제
                            listIter.remove(); // 삭제
                        }
                        break;
                    default: // 1,2,3의 경우가 아닌 경우 문자를 add
                        listIter.add(c); 

                }
            }

            StringBuilder sb = new StringBuilder();
            for (char s : lnklist) {
                sb.append(s);
            }
            System.out.println(sb.toString()); //결과 출력 반복


        }


    }
}
