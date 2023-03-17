/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 22862
 * Level: GOLD V
 * Algorithm: Two Pointer
 */

/* Pseudocode *
탐색 할 범위를 시작 인덱스 끝 인덱스로 나타냄

시작 인덱스 = 0
끝 인덱스 = 0
짝수 갯수 = 0
삭제한 홀수 갯수 = 0

while (끝 인덱스 < 수열의 길이)
    if 끝 인덱스가 짝수
        짝수 갯수++
    else
        삭제한 홀수 갯수++
        while (삭제한 홀수 갯수 > 삭제할 수 있는 홀수의 최대 개수)
            if (시작 인덱스가 홀수)
                삭제한 홀수 갯수--
            else
                짝수 갯수--
            시작 인덱스++
    최대 짝수 갯수 = max(최대 짝수 갯수, 짝수 갯수)
    끝 인덱스++

return 최대 짝수 갯수
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestEvenConsecutiveSubsequence {

    static int ODD_COUNT_LIMIT; // 삭제할 수 있는 홀수의 최대 개수
    static int[] numbers; // 수열

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ODD_COUNT_LIMIT = info[1];
        numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(solution());
    }

    private static int solution() { // 핵심 로직
        int startIndex = 0; // 범위의 시작 인덱스
        int endIndex = 0; // 범위의 끝 인덱스
        int count = 0; // 범위 내의 짝수의 개수
        int max = 0; // 탐색 한 범위 중에서 짝수의 최대 개수
        int oddCount = 0; // 범위 내의 홀수의 개수

        while (endIndex < numbers.length) { // 범위의 끝 인덱스가 수열의 끝에 도달할 때까지 탐색
            if (isEven(numbers[endIndex])) { // 범위의 끝 인덱스가 짝수라면
                count++; // 짝수의 개수를 증가
            } else { // 범위의 끝 인덱스가 홀수라면
                oddCount++; // 홀수의 개수를 증가
                while (oddCount > ODD_COUNT_LIMIT) { // 삭제할 수 있는 홀수의 최대 개수를 초과했다면
                    if (!isEven(numbers[startIndex])) oddCount--; // 범위의 시작 인덱스가 홀수라면 홀수의 개수를 감소
                    else count--; // 범위의 시작 인덱스가 짝수라면 짝수의 개수를 감소
                    startIndex++; // 범위의 시작 인덱스를 증가(범위를 줄임)
                }
            }
            max = Math.max(max, count); // 탐색 한 범위 중에서 짝수의 최대 개수를 갱신
            endIndex++; // 범위의 끝 인덱스를 증가
        }

        return max;
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
