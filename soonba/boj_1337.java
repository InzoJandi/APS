import java.util.*;
/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1337
 * Level: Silver IV
 * Algorithm: Two Pointer
 */

/*
입력값을 받아 정렬한다.
list를 순회하며 현재 값보다 5번째 앞까지와 전체 리스트 사이즈 중 작은 값(Bound Exception 방지) 동안 순회하며
5보다 작은 값이 있는지 확인하고, count를 더해준다.
만약 이미 5개가 나온다면, 더이상 연산하지 않고 끝낸다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        int T = read();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            list.add(read());
        }
        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            Integer integer = list.get(i);
            int loopUntil = Math.min(i+5,list.size());
            for (int j = i+1; j < loopUntil; j++) {
                if(j == i+5) break;
                if(list.get(j) < integer +5) count++;
            }
            result = Math.max(result,count);
            if(count==5) break;
        }
        System.out.println(5-result);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
