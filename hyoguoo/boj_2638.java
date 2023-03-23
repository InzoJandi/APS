/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2639
 * Level: GOLD III
 * Algorithm: Graph / Simulation
 */

/* Pseudocode *
치즈 좌표 리스트에 치즈 좌표를 저장
공기 좌표 리스트에 각 꼭지점을 저장
치즈 좌표 리스트가 비어있을 때까지 반복
    공기 좌표 리스트를 bfs로 탐색하면서, 치즈 좌표 리스트에 있는 치즈 좌표의 count를 1 증가
    치즈 좌표 리스트에 있는 치즈 좌표의 count가 2 이상이면, 치즈를 녹이고, 공기 좌표 리스트에 추가
    치즈를 녹이는 시간을 증가
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cheese {

    final static int CHEESE = 1;
    final static int AIR = 0;
    final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    final static List<CheeseCoordinate> cheeseCoordinateList = new ArrayList<>();
    final static Queue<Coordinate> airCoordinateList = new LinkedList<>();
    static int N;
    static int M;
    static int[][] GRAPH;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        init(); // 입력 받고, 치즈 좌표 리스트에 저장
        int meltingTime = getMeltingTime();
        System.out.println(meltingTime);
    }

    private static int getMeltingTime() {
        // 문제에서 각 꼭지점은 공기라고 확정을 해놓았기 때문에, 각 꼭지점을 큐에 넣어준다.
        airCoordinateList.add(new Coordinate(0, 0));
        airCoordinateList.add(new Coordinate(0, M - 1));
        airCoordinateList.add(new Coordinate(N - 1, 0));
        airCoordinateList.add(new Coordinate(N - 1, M - 1));
        int time = 0;
        while (!cheeseCoordinateList.isEmpty()) {
            bfs(); // 공기 부분을 bfs로 탐색하면서, 치즈 부분을 만나면 치즈 좌표 리스트에 있는 치즈 좌표의 count를 1 증가
            removeCheeseBlock(); // 치즈 좌표 리스트에 있는 치즈 좌표의 count가 2 이상이면, 치즈를 녹이고, 공기 좌표 리스트에 추가
            time++; // 치즈를 녹이는 시간을 증가
        }
        return time;
    }

    private static void bfs() {
        while (!airCoordinateList.isEmpty()) {
            Coordinate current = airCoordinateList.poll(); // 공기 좌표 리스트에서 하나를 꺼냄

            if (visited[current.x][current.y]) continue; // 이미 방문한 곳이면 continue
            visited[current.x][current.y] = true; // 방문 처리

            for (int[] direction : DIRECTIONS) { // 상하좌우 탐색
                int nextX = current.x + direction[0];
                int nextY = current.y + direction[1];

                if (nextX < 0 || N <= nextX || nextY < 0 || M <= nextY) continue; // 범위를 벗어나면 continue
                if (GRAPH[nextX][nextY] == CHEESE) { // 치즈를 만나면 치즈 좌표 리스트에 있는 치즈 좌표의 count를 1 증가
                    // 치즈 좌표 리스트에 있는 치즈 좌표의 count를 1 증가
                    cheeseCoordinateList.stream().filter(cheeseCoordinate -> cheeseCoordinate.x == nextX && cheeseCoordinate.y == nextY).forEach(cheeseCoordinate -> cheeseCoordinate.count++);
                } else airCoordinateList.add(new Coordinate(nextX, nextY)); // 치즈가 아니면 공기 좌표 리스트에 추가
            }
        }
    }

    private static void removeCheeseBlock() {
        for (int i = cheeseCoordinateList.size() - 1; i >= 0; i--) { // 삭제한 후 인덱스가 꼬이지 않도록 역순으로 탐색
            CheeseCoordinate cheeseCoordinate = cheeseCoordinateList.get(i);
            if (cheeseCoordinate.count >= 2) { // 공기가 2개 이상 닿아있으면 치즈를 녹이는 조건
                GRAPH[cheeseCoordinate.x][cheeseCoordinate.y] = AIR; // 그래프를 공기로 변경
                cheeseCoordinateList.remove(i); // 치즈 좌표 리스트에서 삭제
                airCoordinateList.add(new Coordinate(cheeseCoordinate.x, cheeseCoordinate.y)); // 공기 좌표 리스트에 추가
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        GRAPH = new int[N][M]; // 0: 공기, 1: 치즈를 저장하는 그래프
        visited = new boolean[N][M]; // 방문 여부를 저장하는 배열
        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < M; j++) {
                int value = input[j];
                if (value == CHEESE) cheeseCoordinateList.add(new CheeseCoordinate(i, j, 0)); // 치즈(1)인 경우 좌표를 리스트에 저장
                GRAPH[i][j] = value;
            }
        }
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class CheeseCoordinate extends Coordinate {
        int count;

        public CheeseCoordinate(int x, int y, int count) {
            super(x, y);
            this.count = count;
        }
    }
}
