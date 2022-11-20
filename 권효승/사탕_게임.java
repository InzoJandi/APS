/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 3085
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bomboni {
    public static char[][] BOARD;
    public static int N;
    public static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        BOARD = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] row = bufferedReader.readLine().toCharArray();
            System.arraycopy(row, 0, BOARD[i], 0, N);
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                char temp = BOARD[i][j];
                BOARD[i][j] = BOARD[i][j + 1];
                BOARD[i][j + 1] = temp;
                arrCheck();
                temp = BOARD[i][j];
                BOARD[i][j] = BOARD[i][j + 1];
                BOARD[i][j + 1] = temp;

                temp = BOARD[j][i];
                BOARD[j][i] = BOARD[j + 1][i];
                BOARD[j + 1][i] = temp;
                arrCheck();
                temp = BOARD[j][i];
                BOARD[j][i] = BOARD[j + 1][i];
                BOARD[j + 1][i] = temp;
            }
        }
        System.out.println(MAX);

    }

    public static void arrCheck() {
        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (BOARD[i][j] == BOARD[i][j + 1]) count++;
                else count = 1;
                MAX = Math.max(MAX, count);
            }
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N - 1; j++) {
                if (BOARD[j][i] == BOARD[j + 1][i]) count++;
                else count = 1;
                MAX = Math.max(MAX, count);
            }
        }
    }
}
