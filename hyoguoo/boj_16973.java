/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16973
 * Level: GOLD IV
 * Algorithm: Graph
 */

/* Pseudocode *
큐에 시작점을 넣음
while(큐가 비어있지 않다면)
    큐에서 하나 꺼냄
    if (도착지에 도착했다면)
        현재까지의 거리를 반환
    for(상하좌우 탐색)
        if (다음 좌표가 범위를 벗어나거나, 벽이거나, 이미 거리가 갱신되어 있다면)
            continue
        다음 좌표를 큐에 넣음
        다음 좌표까지의 거리를 현재 좌표까지의 거리 + 1로 설정
        
벽 판정 함수
    for(사각형의 테두리를 탐색)
        if (다음 좌표가 범위를 벗어나거나, 벽이라면)
            return false
    return true
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RectangleEscape {

    final static int WALL = -1;
    final static int NOT_VISIT = 0;
    final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int N, M, H, W, START_X, START_Y, END_X, END_Y;
    static int[][] GRAPH;

    public static void main(String[] args) throws IOException {
        init(); // 입력 정보 생성
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(START_X, START_Y, 0));

        // 일반적인 미로찾기 알고리즘
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int currentX = current.x;
            int currentY = current.y;
            int currentDistance = current.distance;

            // 도착지에 도착하면 현재까지의 거리를 반환
            if (currentX == END_X && currentY == END_Y) return GRAPH[END_X][END_Y];

            for (int[] direction : DIRECTIONS) { // 상하좌우 탐색
                int nextX = currentX + direction[0];
                int nextY = currentY + direction[1];
                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue; // 범위를 벗어나는지 확인
                if (!checkBorder(nextX, nextY)) continue; // 사각형 테두리에 대한 유효성 검사
                if (GRAPH[nextX][nextY] != NOT_VISIT) continue; // 방문 여부 확인
                GRAPH[nextX][nextY] = currentDistance + 1; // GRAPH 갱신
                queue.add(new Node(nextX, nextY, currentDistance + 1)); // 큐에 추가
            }
        }

        return -1;
    }

    private static boolean checkBorder(int nextX, int nextY) {
        if (nextX + H - 1 >= N || nextY + W - 1 >= M) return false; // 사각형이 범위를 벗어나는지 확인
        // 사각형의 테두리만 확인(모든 칸을 확인할 필요 없음)
        for (int offsetX = 0; offsetX < H; offsetX++) {
            if (GRAPH[nextX + offsetX][nextY] == WALL) return false;
            if (GRAPH[nextX + offsetX][nextY + W - 1] == WALL) return false;
        }
        for (int offsetY = 0; offsetY < W; offsetY++) {
            if (GRAPH[nextX][nextY + offsetY] == WALL) return false;
            if (GRAPH[nextX + H - 1][nextY + offsetY] == WALL) return false;
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];
        GRAPH = new int[N][M];
        for (int n = 0; n < N; n++) {
            int[] values = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int m = 0; m < values.length; m++) {
                int value = values[m];
                GRAPH[n][m] = value == 1 ? WALL : 0; // GRAPH를 distance로 사용하기 위해 벽은 -1로 표시
            }
        }
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        H = info[0];
        W = info[1];
        // 0부터 시작하므로 -1
        START_X = info[2] - 1;
        START_Y = info[3] - 1;
        END_X = info[4] - 1;
        END_Y = info[5] - 1;
    }

    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
