/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 7576
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Tomato {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static int WIDTH;
    static int HEIGHT;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] infos = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        WIDTH = infos[0];
        HEIGHT = infos[1];
        int[][] tomatoBox = new int[HEIGHT][WIDTH];
        Queue<Coordinate> ripeTomatoList = new LinkedList<>();

        for (int x = 0; x < HEIGHT; x++) {
            int[] tomatoList = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int y = 0; y < WIDTH; y++) {
                tomatoBox[x][y] = tomatoList[y];
                if (tomatoBox[x][y] == 1) ripeTomatoList.add(new Coordinate(x, y));
            }
        }

        bfsBox(tomatoBox, ripeTomatoList);
        System.out.println(getMaxValue(tomatoBox));

    }

    private static int getMaxValue(int[][] tomatoBox) {
        int max = Integer.MIN_VALUE;
        for (int[] tomatoes : tomatoBox) {
            for (int tomato : tomatoes) {
                if (tomato == 0) return -1;
                if (max < tomato) max = tomato;
            }
        }
        return max - 1;
    }

    private static void bfsBox(int[][] tomatoBox, Queue<Coordinate> ripeTomatoList) {
        while (!ripeTomatoList.isEmpty()) {
            Coordinate coordinate = ripeTomatoList.poll();
            traversal(tomatoBox, ripeTomatoList, coordinate);
        }
    }

    private static void traversal(int[][] tomatoBox, Queue<Coordinate> ripeTomatoList, Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int currentDay = tomatoBox[x][y];

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < HEIGHT && ny < WIDTH) {
                if (tomatoBox[nx][ny] == 0) {
                    ripeTomatoList.add(new Coordinate(nx, ny));
                    tomatoBox[nx][ny] = currentDay + 1;
                }
            }
        }

    }
}


class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
