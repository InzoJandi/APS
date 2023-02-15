import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1229
 * Level: GOLD IV
 * Algorithm: DP
 */

/*
육각수 함수 h(x)
h(x) = sumAll(a(n)) + 1

각 육각수마다 더해지는 등차 수열 a(n)
a(n) = 4(n-1) + 1

h(1) = 1
h(2) = 5 + 1 = 6
h(3) = 5 + 9 + 1 = 15 ...

주어지는 수 N 보다 큰 육각수가 나올 때 까지 육각수 초기화
초기화 육각수 배열로 DP 값 계산
DP 출력
 */
public class Main {
    static int hexSum = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        List<Integer> hexList = new ArrayList<>();
        int count = 1;
        while (hexSum < N) {
            hexList.add(hexN(count));
            count++;
        }

        int[] hexArr = hexList.stream().mapToInt(Integer::intValue).toArray();


        int[] DP = new int[N + 1];
        Arrays.fill(DP, 6);
        DP[0] = 0;
        for (int k : hexArr) {
            for (int j = 1; j <= N; j++) {
                if (j < k) {
                    continue;
                }
                DP[j] = Math.min(DP[j], DP[j - k] + 1);
            }
        }

        System.out.println(DP[N]);

    }

    private static int hexN(int n) {
        hexSum += aN(n);
        return hexSum;
    }

    private static int aN(int n) {
        return 4 * (n - 1) + 1;
    }
}
