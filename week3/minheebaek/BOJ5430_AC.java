package week3.minheebaek;
/** 3주차
 * 1.BOJ 5430
 * 2.덱
 * 3.'D'가 나오면 배열을 뒤집어야하는데 덱을 이용해서 앞,뒤를 활용하면 굳이 배열을 뒤집지 않아도 된다. 그리고 앞, 뒤 첫번째 원소만 사용해서
 * 덱 사용했다.
 * 4.for문이 3개 있어서 O(n^3)라고 생각했는데 범위 최댓값을 넣으니 시간초과가 나오는 것 같다. 시간복잡도는 잘 모르겠다.
 */
/** 배운점
 * 1.[]인데 R일 경우와 D일 경우를 생각하는 것이 어려웠다. -> 33줄과 함수로 해결
 * 36번에 공통적으로 발생하는 String 문장을 함수의 리턴타입으로 만들고 함수 써서 로직을 효율적으로 관리한점
 * 2.의미있는 변수
 * 3.substring, split, toCharArray 개념
 * 4.문제와 예시를 꼼꼼히 읽자
 */
/** 참고
 * https://girawhale.tistory.com/9
 */

import java.util.*;

public class BOJ5430_AC {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        for (int tc = 0; tc < T; tc++) {
            String p = scan.next();
            int n = scan.nextInt();

            String arr = scan.next();
            Deque<Integer> deque = new LinkedList<>();
            for (String token : arr.substring(1, arr.length() - 1).split(",")) {
                if (!token.equals(""))
                    deque.add(Integer.parseInt(token));
            }

            System.out.println(ac(deque, p)); //뭐든 String 타입인 문장을 결과로 내니까 공통적인 부분은 함수로 관리
        }
    }

    static String ac(Deque<Integer> deque, String commands){
        boolean reverse = false;

        for(char command : commands.toCharArray() ){
            if(command == 'R')
                reverse = !reverse;
            if(command =='D'){
                if(deque.size()>0){
                    if(reverse){
                        deque.removeLast();
                    }else{
                        deque.removeFirst();
                    }
                }else{
                    return "error";
                }
            }

        }

        StringBuilder sb = new StringBuilder("[");
        while(!deque.isEmpty()){
            if(reverse){
                sb.append(deque.removeLast());
            }else{
                sb.append(deque.removeFirst());
            }
            if(deque.size()>0){
                sb.append(",");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}