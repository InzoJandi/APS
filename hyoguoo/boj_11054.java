/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11054
 * Level: GOLD IV
 * Algorithm: Dynamic Programing / LIS
 */

/* Pseudocode *
1. 증가하는 부분 수열의 길이 배열과 감소하는 부분 수열의 길이 배열을 얻는다.
2. 배열의 합을 구하게 되면, 증가하면서 감소하는 부분 수열의 길이가 된다.
3. 합을 구한 뒤 1을 뺸다(중복된 수열을 제거하기 위함)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestBitonicSubsequence {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); // 숫자 배열 입력

        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers) {
        int[] lis = getLIS(numbers); // 증가하는 부분 수열의 길이 배열
        int[] lds = getLIS(reverse(numbers)); // 거꾸로 뒤집어 감소하는 부분 수열의 길이 배열을 얻음

        return getMax(lis, lds); // 증가하는 부분 수열의 길이 배열과 감소하는 부분 수열의 길이 배열을 합친 최대 길이를 구함
    }

    private static int getMax(int[] lis, int[] lds) {
        int max = 0;

        for (int i = 0; i < lis.length; i++) {
            max = Math.max(max, lis[i] + lds[lis.length - i - 1] - 1);
        }

        return max;
    }

    private static int[] getLIS(int[] numbers) {
        int[] dp = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (numbers[j] < numbers[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        return dp;
    }

    private static int[] reverse(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) reversed[i] = numbers[numbers.length - i - 1];
        return reversed;
    }
}
