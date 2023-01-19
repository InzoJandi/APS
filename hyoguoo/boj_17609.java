/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 17609
 * Level: GOLD V
 * Algorithm: String / Two Pointer
 */

/* Pseudocode *
문자열과 문자열의 가장 왼쪽 인덱스와 가장 오른쪽 인덱스 삽입
단순 뒤집었을 경우 회문이라면 바로 0을 반환
문자열 왼쪽 끝과 오른쪽 끝에서부터 비교
왼쪽 끝과 오른쪽 끝이 같으면 다음 안 쪽 인덱스로 이동
왼쪽 끝과 오른쪽 끝이 다르면 한 번에 한하여 왼쪽 끝을 무시하거나 오른쪽 끝을 무시하고 비교
그 후 비교했을 때 회문이라면 1을 반환
아니라면 2를 반환

if string == reverse(string)
    return 0
while left <= right
    if string[left] == string[right]
        left++
        right--
    else if !isSkip
        leftSkip = isPalindromeString(string, left + 1, right, true)
        rightSkip = isPalindromeString(string, left, right - 1, true)
        return min(leftSkip, rightSkip)
    else
        return 2
 */


package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        // 각 입력에 대해 회문인지 확인하므로 length만큼 반복
        for (int i = 0; i < length; i++) {
            String string = bufferedReader.readLine();
            // 반복되는 println 대신 속도를 위해 StringBuilder를 사용
            stringBuilder.append(isPalindromeString(string, 0, string.length() - 1, false)).append("\n");
        }

        System.out.println(stringBuilder);
    }

    /**
     * 회문인지 확인하는 함수
     *
     * @param string 문자열
     *               left, right는 문자열의 왼쪽, 오른쪽 인덱스
     *               isSkip은 문자열의 왼쪽, 오른쪽 인덱스가 다른 경우 한 번만 건너뛰기 위한 변수
     * @return 회문이면 0, 유사회문이면 1, 회문이 아니면 2
     */
    private static int isPalindromeString(String string, int left, int right, boolean isSkip) {
        String reverseString = getReverseString(string);
        // 문자열과 문자열의 역순이 같으면 회문이므로 0 반환
        if (string.equals(reverseString)) return 0;

        // 문자열의 왼쪽, 오른쪽 인덱스가 서로 만날 때 까지 반복
        while (left <= right) {
            char leftChar = string.charAt(left);
            char rightChar = string.charAt(right);
            // 문자열의 왼쪽, 오른쪽 인덱스가 같으면 인덱스를 1씩 증가, 감소
            if (leftChar == rightChar) {
                left++;
                right--;
                // 문자열이 서로 다르고 건너뛴적이 없다면 한 문자를 건너 띈 후 남은 문자열에 대해 회문인지 확인
            } else if (!isSkip) {
                /*
                왼쪽과 오른쪽 문자를 건너뛴 후 남은 문자열에 대해 회문인지 확인
                여기서 isSkip을 true로 설정하여 더이상 건너뛰지 않도록 함
                 */
                int leftSkip = isPalindromeString(string, left + 1, right, true);
                int rightSkip = isPalindromeString(string, left, right - 1, true);
                // 둘 중 낮은 값을 반환(하나라도 회문인 경우 1 반환)
                return Math.min(leftSkip, rightSkip);
            } else {
                // 문자열이 서로 다르고 건너뛴적이 있다면 회문이 아니므로 2 반환
                return 2;
            }
        }

        // 건너뛴적이 있는 상태에서 위의 반복문을 빠져나왔다면 유사회문이므로 1 반환
        return 1;
    }

    private static String getReverseString(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) stringBuilder.append(input.charAt(i));
        return stringBuilder.toString();
    }
}
