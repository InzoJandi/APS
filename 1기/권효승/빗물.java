/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 14719
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RainWater {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] size = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] blocks = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int height = size[0];
        int width = size[1];
        int[][] map = new int[height][width];

        makeBlock(map, blocks);
        System.out.println(countWater(map));
    }

    private static int countWater(int[][] map) {
        int count = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 1; j < map[i].length - 1; j++) {
                if (map[i][j] == 0 && checkBlocked(map, i, j)) count++;
            }
        }
        return count;
    }

    private static boolean checkBlocked(int[][] map, int i, int j) {
        return checkLeft(map, i, j) && checkRight(map, i, j);
    }

    private static boolean checkLeft(int[][] map, int i, int j) {
        for (int x = j - 1; x >= 0; x--) {
            if (map[i][x] == 1) return true;
        }
        return false;
    }

    private static boolean checkRight(int[][] map, int i, int j) {
        for (int x = j + 1; x < map[i].length; x++) {
            if (map[i][x] == 1) return true;
        }
        return false;
    }

    public static void makeBlock(int[][] map, int[] blocks) {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = map.length - 1; j >= map.length - blocks[i]; j--) {
                map[j][i] = 1;
            }
        }
    }
}
