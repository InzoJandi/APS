/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2293
 * Level: GOLD V
 * Algorithm: Dynamic Programming
 */

/* Pseudocode *
dp[i] = i원을 만들 수 있는 경우의 수
dp[0] = 1

for coin in coinList
    for i in 0 to target
        if i + coin <= target
            dp[i + coin] += dp[i]

동전을 목표까지 만들 수 있는 경우의 수를 bottom-up 방식으로 구함
동전의 사용 순서를 고려하지 않기 때문에 한 동전에 대해 모든 경우의 수를 구한 뒤 다음 동전으로 넘어가 누적 합을 구하는 방식으로 구현
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coin1 {

    final static List<Integer> coinList = new ArrayList<>();
    static int[] dp;
    static int N;
    static int TARGET;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        TARGET = info[1];
        for (int i = 0; i < N; i++) coinList.add(Integer.parseInt(bufferedReader.readLine()));
        dp = new int[TARGET + 1];

        solution();
        System.out.println(dp[TARGET]);
    }

    private static void solution() {
        // dp[i] = i원을 만들 수 있는 경우의 수
        dp[0] = 1; // 0원을 만들 수 있는 경우의 수는 1가지
        for (Integer coin : coinList) { // 동전 하나에 대해
            for (int i = 0; i <= TARGET; i++) { // 목표 금액까지 모든 경우의 수를 구함
                if (i + coin <= TARGET) dp[i + coin] += dp[i]; // i원을 만들 수 있는 경우의 수에 i + coin원을 만들 수 있는 경우의 수를 더함
            }
        }
    }
}
