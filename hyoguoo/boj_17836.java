/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17836
 * Level: GOLD V
 * Algorithm: Graph
 */

/* Pseudocode *
bfs run:
queue.add(시작점);
while(!queue.isEmpty()) {
    현재 위치를 queue에서 꺼냄
    현재 위치가 그람이 있는 위치이면
        현재 위치에서 그람까지의 거리를 더해 answer에 갱신
    현재 위치가 목적지이면
        걸린 시간 answer에 갱신
        탐색 종료
    현재 위치에서 상하좌우로 이동할 수 있는 위치를 시간 갱신하여 queue에 추가

만약 answer가 LIMIT_TIME보다 작으면 answer 출력
 */

package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SavePrincess {

    // 상하좌우 탐색을 위한 배열
    final static int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int N, M, LIMIT_TIME;
    static int GRAM_X, GRAM_Y;
    // 최대 제한시간인 10000보다 큰 값으로 초기화, 만약 목적지에 도착하지 못한 경우 10001 값이 갱신 되지 않아 Fail이 출력됨
    static int answer = 10001;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        LIMIT_TIME = info[2];
        map = new int[N][M];

        for (int x = 0; x < N; x++) {
            int[] line = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int y = 0; y < M; y++) {
                map[x][y] = line[y];
                // 그람을 찾으면 그람의 위치를 저장하고 그람의 위치도 통과할 수 있으므로 0으로 초기화
                if (map[x][y] == 2) {
                    GRAM_X = x;
                    GRAM_Y = y;
                    map[x][y] = 0;
                } else if (map[x][y] == 1) {
                    // 벽은 통과할 수 없으며 지도에 걸린 시간을 업데이트 시킬 예정이므로 편의상 -1로 초기화
                    map[x][y] = -1;
                }
            }
        }

        bfs();
        // 제한시간을 초과한 경우 Fail을 출력하고 아닌 경우 걸린 시간을 출력
        System.out.println(answer > LIMIT_TIME ? "Fail" : answer);
    }

    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        // 시작점을 큐에 넣고 시작점의 시간을 0으로 초기화
        queue.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentTime = current.time;

            // 그람을 찾은 경우
            if (currentX == GRAM_X && currentY == GRAM_Y) {
                // 그람을 찾는 데에 걸린 시간 + 그람에서 목적지까지의 최단 거리 계산하여 answer 갱신
                answer = currentTime + getManhattanDistance(N - 1, M - 1, GRAM_X, GRAM_Y);
                // 그람을 찾지 않고 바로 목적지에 가는 경우가 있으므로 탐색을 계속함
                continue;
            }

            // 목적지에 도착한 경우
            if (currentX == N - 1 && currentY == M - 1) {
                // 바로 목적지에 도착한 시간이 그람을 찾고 목적지에 도착한 시간보다 작은 경우 answer 갱신
                answer = Math.min(answer, currentTime);
                // 탐색 종료
                return;
            }

            // 상하좌우 탐색
            for (int[] direction : DIRECTION) {
                // 다음 좌표
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];

                // 다음 좌표가 지도 내에 있고(isInMap) && 벽이 아니고 (-1이 아님) && 다음 좌표에 방문하지 않았거나(==0) 현재 좌표에서 다음 좌표로 이동하는데 걸린 시간이 다음 좌표에 저장된 시간보다 작은 경우
                if (isInMap(nextX, nextY) && map[nextX][nextY] != -1 && (map[nextX][nextY] == 0 || map[nextX][nextY] > currentTime + 1)) {
                    map[nextX][nextY] = currentTime + 1;
                    queue.add(new Node(nextX, nextY, currentTime + 1));
                }
            }
        }
    }

    private static int getManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static boolean isInMap(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

    }
}
