import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2812
 * Level: Gold III
 * Algorithm: Stack
 */

/*
입력값 파싱

<문자열에서 몇개를 지워 가장 큰 수가 되는 방법>
- 현재 자리보다 앞자리 문자들과 값을 비교하여 현재가 더 크다면 기존 자리 문자 삭제

처음부터 순회하며 모든 자리의 char에 대해 아래 기준으로 갱신한다.
<deque 값 삭제 조건>
1. deque가 비어있지 않다.
2. 지울 수 있는 개수(erase) 가 남아있다.
3. 현재의 char가 deque.peek() char보다 크다.

<deque push 조건>
- deque의 사이즈가 결과의 길이를 넘지 않는다.

결과를 출력한다.
 */


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int length = Integer.parseInt(s[0]);
        int erase = Integer.parseInt(s[1]);
        int resultLength = length - erase;
        char[] chars = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(chars[0]);
        for (int i = 1; i < length; i++) {
            while((!deque.isEmpty()) && (erase > 0) && (chars[i] > deque.peek())) {
                deque.poll();
                erase--;
            }
            if(deque.size() < resultLength) {
                deque.push(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        System.out.println(sb);
    }
}
