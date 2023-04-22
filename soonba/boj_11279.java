import java.util.PriorityQueue;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11279
 * Level: Silver II
 * Algorithm: priority queue
 */

/*
내림차순 comparator 를 구현한 pq를 생성
입력값을 받아 출력값을 조건에 맞게 sb.append()
출력
 */
public class Main {

    public static final int PRINT = 0;

    public static void main(String[] args) throws Exception {
        int T = read();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int i = 0; i < T; i++) {
            int now = read();
            if(now == PRINT) {
                if(pq.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                pq.add(now);
            }
        }
        System.out.println(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}

