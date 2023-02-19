/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2194
 * Level: GOLD V
 * Algorithm: Graph
 */

/* Pseudocode *
init
    N, M, A, B, K를 입력받음
    map을 N x M 크기로 생성
    map을 모두 0으로 초기화
    for (K번 반복) {
        x, y를 입력받음
        map[x][y] = -1
    }
    unitSizeX, unitSizeY, currentX, currentY, targetX, targetY를 입력받음
bfs
    queue를 생성
    queue에 (currentX, currentY, 0)을 넣음
    map[currentX][currentY] = 1
    while (queue가 비어있지 않다면) {
        current를 queue에서 꺼냄
        if (current.x == targetX && current.y == targetY) return current.count
        for (4방향) {
            nextX = current.x + direction[0]
            nextY = current.y + direction[1]
            if (nextX, nextY가 map의 범위 내에 있고 && 유닛 크기만큼 벗어나지 않고 && 벽에 부딛히지 않고 && 방문하지 않았다면) {
                queue에 (nextX, nextY, current.count + 1)을 넣음
                map[nextX][nextY] = 1
            }
        }
    }
    return -1
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveUnit {

    final static int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final static int BLOCKED = -1;
    final static int EMPTY = 0;
    final static int VISITED = 1;
    static int[][] map;
    static int N;
    static int M;
    static int UNIT_SIZE_X;
    static int UNIT_SIZE_Y;
    static int CURRENT_X;
    static int CURRENT_Y;
    static int TARGET_X;
    static int TARGET_Y;

    public static void main(String[] args) throws IOException {
        init(); // 입력 받고 초기화
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(CURRENT_X, CURRENT_Y, 0)); // 시작점 큐에 넣고
        map[CURRENT_X][CURRENT_Y] = VISITED; // 방문 표시
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (current.x == TARGET_X && current.y == TARGET_Y) return current.count; // 목표 도착하면 리턴
            for (int[] direction : DIRECTIONS) { // 4방향 탐색
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];
                if (isInBound(nextX, nextY) && map[nextX][nextY] == EMPTY) { // 범위 내에 있고, 비어 있는 곳(방문하지 않았고, 벽이 아닌 곳)이면
                    queue.add(new Point(nextX, nextY, current.count + 1));
                    map[nextX][nextY] = VISITED; // 방문 표시
                }
            }
        }

        return -1; // 목표 도착하지 못하면 -1 리턴
    }

    private static boolean isInBound(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= M) return false; // 범위를 벗어나면 false
        for (int offsetX = 0; offsetX < UNIT_SIZE_X; offsetX++) { // 유닛 크기만큼
            for (int offsetY = 0; offsetY < UNIT_SIZE_Y; offsetY++) { // 유닛 크기만큼
                if (x + offsetX >= N || y + offsetY >= M || map[x + offsetX][y + offsetY] == BLOCKED) return false; // 범위를 벗어나거나 벽이면 false(방문한 곳은 상관 없음)
            }
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        map = new int[N][M];
        UNIT_SIZE_X = info[2];
        UNIT_SIZE_Y = info[3];
        // 장애물의 개수를 받은 후 장애물의 좌표를 입력 받아서 map에 표시
        int OBSTACLE_COUNT = info[4];
        for (int i = 0; i < OBSTACLE_COUNT; i++) {
            int[] obstacle = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[obstacle[0] - 1][obstacle[1] - 1] = BLOCKED; // 장애물은 -1로 표시
        }
        int[] current = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 시작점 좌표는 0부터 시작하므로 1을 빼줌
        CURRENT_X = current[0] - 1;
        CURRENT_Y = current[1] - 1;
        int[] target = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 도착점 좌표는 0부터 시작하므로 1을 빼줌
        TARGET_X = target[0] - 1;
        TARGET_Y = target[1] - 1;
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
