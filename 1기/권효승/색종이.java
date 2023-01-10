/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2630
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColorPaper {

    static int[][] paper;
    static int N;
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = bufferedReader.readLine().split(" ");
            for (int j = 0; j < N; j++) paper[i][j] = Integer.parseInt(line[j]);
        }

        recursion(0, 0, N);
        System.out.println(zeroCount);
        System.out.println(oneCount);
    }

    private static void recursion(int x, int y, int length) {
        if (checkIsCompleted(x, y, length)) return;

        int half = length / 2;
        if (half == 0) {
            recursion(x, y, half);
            return;
        }
        recursion(x, y, half);
        recursion(x + half, y, half);
        recursion(x, y + half, half);
        recursion(x + half, y + half, half);
    }

    private static boolean checkIsCompleted(int x, int y, int length) {
        int reference = paper[x][y] == 1 ? 1 : 0;
        for (int i = x; i < x + length; i++) {
            for (int j = y; j < y + length; j++) {
                if (paper[i][j] != reference) return false;
            }
        }

        if (reference == 0) zeroCount++;
        if (reference == 1) oneCount++;
        return true;
    }
}
