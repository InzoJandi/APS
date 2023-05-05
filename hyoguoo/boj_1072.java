/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1072
 * Level: SILVER III
 * Algorithm: Mathematics
 */

/* Pseudocode *
winRate = (winCount * 100) / gameCount

위의 승률 공식에서 이기는 홧수를 x로 두어 다음과 같은 방정식을 세움

winRate + 1 = ((winCount + x) * 100) / (gameCount + x)

이를 x에 대해 정리

winRate + 1 = ((winCount + x) * 100) / (gameCount + x)
(winRate + 1) * (gameCount + x) = (winCount + x) * 100
winRate * gameCount + winRate * x + gameCount + x = winCount * 100 + x * 100
winRate * gameCount + winRate * x + gameCount + x - x * 100 = winCount * 100
winRate * gameCount + winRate * x + gameCount - x * 99 = winCount * 100
winRate * gameCount + gameCount - x * 99 = winCount * 100 - winRate * x
winRate * gameCount + gameCount = winCount * 100 - winRate * x + x * 99
winRate * gameCount + gameCount = winCount * 100 - x * (winRate - 99)
winRate * gameCount + gameCount - winCount * 100 = - x * (winRate - 99)
- (winRate * gameCount + gameCount - winCount * 100) = x * (winRate - 99)
- (winRate * gameCount + gameCount - winCount * 100) / (winRate - 99) = x
(winCount * 100 - (winRate * gameCount) - gameCount) / (winRate - 99) = x
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution(info[0], info[1]));
    }

    private static int solution(long gameCount, long winCount) {
        long winRate = getWinRate(gameCount, winCount);
        if (winRate >= 99) return -1;
        return (int) Math.ceil((double) ((winCount * 100) - (gameCount * winRate) - gameCount) / (winRate - 99));
    }

    private static long getWinRate(long gameCount, long winCount) {
        return (winCount * 100) / gameCount;
    }
}
