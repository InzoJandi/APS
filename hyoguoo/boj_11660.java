/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11660
 * Level: Silver I
 * Algorithm: Dynamic Programming / Prefix Sum
 */

/* Pseudocode *
1. prefixSum 배열을 생성 및 계산
2. prefixSum 배열을 이용하여 구간 합을 구함
 */


package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindingSumIntervals5 {

    static int N;
    static int[][] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        int length = info[1];
        prefixSum = new int[N + 1][N + 1]; // 1만큼 패딩을 준 상태로 배열 생성

        for (int i = 1; i <= N; i++) {
            int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= N; j++) {
                // 1. 현재 위치의 값
                // 2. 현재 위치의 왼쪽 값
                // 3. 현재 위치의 위쪽 값
                // 4. 현재 위치의 왼쪽 위 대각선 값
                // 1 ~ 4의 합에서 2와 3을 두 번 더한 값이 중복으로 더해진 것이므로 4를 빼줌
                prefixSum[i][j] = numbers[j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        for (int i = 0; i < length; i++) {
            int[] intervals = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(getSum(intervals[0], intervals[1], intervals[2], intervals[3]));
        }
    }

    private static int getSum(int x1, int y1, int x2, int y2) {
        // 마지막 위치의 누적 합에서 시작 위치의 누적 합을 뺴서 해당 범위의 누적 합을 구함
        return prefixSum[x2][y2] - prefixSum[x1 - 1][y2] - prefixSum[x2][y1 - 1] + prefixSum[x1 - 1][y1 - 1];
    }
}
