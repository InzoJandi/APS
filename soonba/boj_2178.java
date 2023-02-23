import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2178
 * Level: 실버 1
 * Algorithm: Graph
 */

/*

필요한 인접 행렬 및 변수 초기화
1. 방문 여부
2. 비용
3. 길 유무
4. 상,하,좌,우 탐색용 변수 dx, dy

bfs 로 해결
*/

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] road = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                road[i][j] = Integer.parseInt(split[j]);
            }
        }

        // bfs 내의 for 문에서 상하좌우 탐색용
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 방문 여부
        boolean[][] visit = new boolean[N][M];
        // 비용
        int[][] score = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        score[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                //범위를 넘어갈 경우
                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
                    continue;
                }
                //길이 막혀있는 경우
                if (road[nextX][nextY] == 0) {
                    continue;
                }
                //이미 방문한 경우
                if (visit[nextX][nextY]) {
                    continue;
                }
                queue.add(new int[]{nextX, nextY});
                visit[nextX][nextY] = true;
                score[nextX][nextY] = score[nowX][nowY] + 1;
            }
        }

        System.out.println(score[N-1][M-1]);

    }
}

