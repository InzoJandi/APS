/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2164
 * Level: Silver V
 * Algorithm: Queue
 */

/*
입력값을 Queue에 담는다.
버리고(poll()) 제일 뒤에 추가 (poll() + add()) 하여 사이즈가 1일 때 까지 진행한다.
마지막 poll()을 출력한다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < T; i++) {
            queue.add(i + 1);
        }

        while (queue.size() > 1) {
            queue.poll();
            Integer poll = queue.poll();
            queue.add(poll);
        }
        System.out.println(queue.poll());
    }

}

