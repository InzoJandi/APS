import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1106
 * Level: Gold V
 * Algorithm: Dynamic Programming
 */

/*
입력값을 배열에 담는다. (모든 입력값은 +1 padding)
DP 세팅 및 MAX_VALUE 셋업(최솟값을 구해야 하므로)
모든 도시에 대해 모든 DP 값을 업데이트 한다.
해당 DP값 출력
 */


public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int goal = Integer.parseInt(s[0]);
        int citiesCount = Integer.parseInt(s[1]);
        int[][] values = new int[citiesCount+1][2];
        for (int i = 1; i <= citiesCount; i++) {
            String[] s1 = br.readLine().split(" ");
            values[i][0] = Integer.parseInt(s1[0]);
            values[i][1] = Integer.parseInt(s1[1]);
        }
        int[] DP = new int[goal+1];
        Arrays.fill(DP, Integer.MAX_VALUE);
        // 도시 선택 i
        for (int i = 1; i <= citiesCount; i++) {
            // DP 선택 j
            for (int j = 1; j < DP.length; j++) {
                int cost = values[i][0];
                int customer = values[i][1];
                if (j <= customer) {
                    DP[j] = Math.min(DP[j], cost);
                    continue;
                }
                DP[j] = Math.min(DP[j], DP[j-customer] + cost);
            }
        }
        System.out.println(DP[goal]);
    }
}

