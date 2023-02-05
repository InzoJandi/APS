/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2470
 * Level: GOLD V
 * Algorithm: Two Pointer
 */

/* Pseudocode *
두 수의 합이 0에 가장 가까운 두 수를 찾는 문제
투 포인터를 이용하여 풀 수 있다.
두 수의 합이 0보다 작으면 왼쪽 포인터를 오른쪽으로, 0보다 크면 오른쪽 포인터를 왼쪽으로 이동시키는 방식으로 풀 수 있다.

입력받은 숫자 배열을 정렬
가장 첫 인덱스와 가장 마지막 인덱스를 가리키도록 함
while (첫 인덱스 < 마지막 인덱스) {
    sum = 첫 인덱스의 값 + 마지막 인덱스의 값
    if (sum < 0) 첫 인덱스를 오른쪽으로 이동
    else if (sum > 0) 마지막 인덱스를 왼쪽으로 이동
    else break;
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSolution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        bufferedReader.readLine();
        // 숫자 배열을 입력받아 정렬
        int[] numbers = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);

        Answer answer = solution(numbers);
        System.out.println(answer.number1 + " " + answer.number2);
    }

    private static Answer solution(int[] numbers) {
        // 투 포인터를 이용하여 가장 첫 인덱스와 가장 마지막 인덱스를 가리키도록 함
        int startIndex = 0;
        int endIndex = numbers.length - 1;
        // 가장 첫 인덱스와 가장 마지막 인덱스의 합의 절대값을 가지는 Answer 객체를 생성
        Answer answer = new Answer(numbers[0], numbers[numbers.length - 1], Math.abs(numbers[0] + numbers[numbers.length - 1]));

        while (startIndex < endIndex) {
            int sum = numbers[startIndex] + numbers[endIndex];
            // 현재 가리키는 두 인덱스의 합의 절대값이 작은 경우
            if (Math.abs(sum) < answer.difference) {
                // Answer 객체를 갱신
                answer = new Answer(numbers[startIndex], numbers[endIndex], Math.abs(sum));
            }

            // 정렬 된 배열이므로 합이 0보다 작으면 startIndex를 증가시키고, 0보다 크면 endIndex를 감소시킴
            if (sum < 0) startIndex++;
            else if (sum > 0) endIndex--;
            // 0이면 더 이상 탐색할 필요가 없으므로 종료
            else break;
        }

        // 가장 차이가 작은 두 수를 가지는 Answer 객체를 반환
        return answer;
    }

    static class Answer {
        int number1;
        int number2;
        int difference;

        public Answer(int number1, int number2, int difference) {
            this.number1 = number1;
            this.number2 = number2;
            this.difference = difference;
        }
    }
}
