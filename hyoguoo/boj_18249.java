/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 16235
 * Level: SILVER IV
 * Algorithm: Brute Force / Backtracking
 */

/* Pseudocode *
모든 경우의 수 탐색하여 백트래킹
 */

package BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MuscleLoss {

    static final int BASE_WEIGHT = 500;
    static int DAY, DECREASE;
    static int[] INCREMENTS;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        init();
        backtracking(0, BASE_WEIGHT, new boolean[DAY]);
        System.out.println(count);
    }

    private static void backtracking(int day, int weight, boolean[] used) {
        if (day == DAY) {
            count++;
            return;
        }

        for (int i = 0; i < DAY; i++) {
            if (used[i]) continue;
            if (weight + INCREMENTS[i] - DECREASE < BASE_WEIGHT) continue;
            used[i] = true;
            backtracking(day + 1, weight + INCREMENTS[i] - DECREASE, used);
            used[i] = false;
        }
    }

    private static void init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        DAY = info[0];
        DECREASE = info[1];
        INCREMENTS = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
